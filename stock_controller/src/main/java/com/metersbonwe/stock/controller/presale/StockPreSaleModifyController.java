package com.metersbonwe.stock.controller.presale;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.ExceptionConstants.ExceptionCode;
import com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService;
import com.metersbonwe.stock.biz.manager.service.StockPreSaleService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModify;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetail;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.StockPreSaleModifyResultBean;
import com.metersbonwe.stock.pojo.imexcel.StockPreSaleModifyDetailExcelBean;
import com.metersbonwe.stock.utils.FileEncodeUtil;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;
import com.metersbonwe.stock.vo.presale.StockPreSaleModifyDetailVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleModifyReqVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleModifyResVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleModifyVo;

@Controller public class StockPreSaleModifyController extends BaseController {

    private static StockLog                     stockLog = StockLogFactory.getLogger(StockPreSaleModifyController.class);

    @Resource private StockPreSaleModifyService stockPreSaleModifyServiceImpl;

    @Resource private StockPreSaleService       stockPreSaleServiceImpl;

    /**
     * TODO 检查验证数据是否有效
     * 
     * @param req
     * @return
     */
    private String checkDataValied(StockPreSaleModifyReqVo req) {
        StockPreSaleModifyVo masterVo = req.getMaster();
        String channelCode = masterVo.getChannelCode();
        if (channelCode == null || "".equals(channelCode)) {
            return "渠道编码为空";
        }

        List<StockPreSaleModifyDetailVo> detailVoList = req.getDetailList();

        //检查同仓库同商品是否有多条记录
        Map<String, Integer> detailCountMap = new HashMap<String, Integer>();
        for (StockPreSaleModifyDetailVo detailVo : detailVoList) {
            String key = detailVo.getWarehId() + ":" + detailVo.getProdId();
            int dCount = 1;
            if (detailCountMap.containsKey(key)) {
                int v = detailCountMap.get(key);
                dCount = dCount + v;
            }
            detailCountMap.put(key, dCount);
        }
        StringBuilder sBuilder = new StringBuilder();
        for (Entry<String, Integer> entry : detailCountMap.entrySet()) {
            int v = entry.getValue();
            if (v > 1) { //存在多条记录
                String key = entry.getKey();
                sBuilder.append(key);
            }
        }
        if (sBuilder.length() > 0) {
            sBuilder.append("有多条记录出现仓库商品一样,不允许保存");
            return sBuilder.toString();
        }

        //检查同一商品是否有多个开始预售时间和结束预售时间
        Set<String> prodSet = new HashSet<String>();
        Map<String, StockPreSaleModifyDetailVo> detailVoMap = new HashMap<String, StockPreSaleModifyDetailVo>();
        for (StockPreSaleModifyDetailVo detailVo : detailVoList) {
            String key = detailVo.getProdId();
            StockPreSaleModifyDetailVo voBean = detailVoMap.get(key);
            if (voBean != null) {
                if (voBean.getStartTime() != detailVo.getStartTime() || voBean.getEndTime() != detailVo.getEndTime()) {
                    prodSet.add(key);
                }
            } else {
                detailVoMap.put(key, detailVo);
            }
        }
        if (prodSet.size() > 0) {
            StringBuilder sBuilder1 = new StringBuilder();
            for (String key : prodSet) {
                sBuilder1.append(key);
            }
            sBuilder1.append("有多条记录出现预售开始时间与预售结束时间不同,不允许保存");
            return sBuilder1.toString();
        }
        return "";
    }

    /**
     * TODO 新增商品预售调整单
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveStockPreSaleModify")
    //@RequestParam("json") String jsonData
    public String saveStockPreSaleModify(HttpServletRequest request) {
        Map<String, String> paraMap = assembleSelectParam(request);
        String jsonData = paraMap.get("json");
        stockLog.info("saveStockPreSaleModify传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);

            StockPreSaleModifyVo masterVo = req.getMaster();
            if (masterVo == null) {
                res.setMsg("传入的参数为空");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            //检查验证数据
            Long relationId = masterVo.getRelationId();
            if (relationId == null || relationId <= 0) {
                res.setMsg("预售单号不能为空");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            String name = masterVo.getName();
            if (name == null || "".equals(name)) {
                res.setMsg("调整单名称不能为空");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSale preSale = stockPreSaleServiceImpl.getStockPreSale(relationId);
            if (preSale == null) {
                res.setMsg("预售单号" + relationId + "在预售单中不存在");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            masterVo.setChannelCode(preSale.getChannelCode());

            boolean isNewed = masterVo.getId() == null || masterVo.getId() <= 0;
            Calendar c = Calendar.getInstance();
            if (isNewed) {
                masterVo.setCreateBy("0001");
                masterVo.setCreateTime(c.getTime());
            }
            masterVo.setUpdateBy("0001");
            masterVo.setUpdateTime(c.getTime());
            masterVo.setExamineStatus("0");

            //组装数据
            StockPreSaleModify masterBean = new StockPreSaleModify();
            BeanUtils.copyProperties(masterBean, masterVo);

            try {
                //保存数据
                StockPreSaleModifyResultBean resultBean = null;
                if (isNewed) {
                    resultBean = this.stockPreSaleModifyServiceImpl.insertStockPreSaleModify(masterBean);
                } else {
                    resultBean = this.stockPreSaleModifyServiceImpl.updateStockPreSaleModify(masterBean);
                }
                if (!resultBean.isSucess()) {
                    res.setMsg(resultBean.getMsg());
                    res.setSucess(false);
                    res.setMaster(masterVo);
                } else {
                    res.setSucess(true);
                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
                    res.setMaster(masterVo);
                }
            } catch (Exception ex) {
                stockLog.error("saveStockPreSaleModify:插入商品预售表失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("saveStockPreSaleModify操作出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * TODO 新增商品预售调整单明细
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStockPreSaleModifyDetail")
    public String addStockPreSaleModifyDetail(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            StockPreSaleModifyDetail vo = new StockPreSaleModifyDetail();
            BeanUtils.populate(vo, paraMap);

            vo.setUpdateBy("0001");
            vo.setUpdateTime(new Date());
            succCount = stockPreSaleModifyServiceImpl.insertStockPreSaleModifyDetail(vo);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * TODO 修改商品预售调整单明细
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStockPreSaleModifyDetail")
    public String updateStockPreSaleModifyDetail(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            StockPreSaleModifyDetail vo = new StockPreSaleModifyDetail();
            BeanUtils.populate(vo, paraMap);
            vo.setUpdateBy("0001");
            vo.setUpdateTime(new Date());
            succCount = stockPreSaleModifyServiceImpl.updateStockPreSaleModifyDetail(vo);
        } catch (Exception e) {
            errCode = ExceptionCode.DUPLICATION_RECODE;
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * TODO 删除商品预售调整单明细
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteStockPreSaleModifyDetail")
    public String deleteStockPreSaleModifyDetail(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            String ids = paraMap.get("id");
            if (StringUtils.isNotBlank(ids)) {
                String[] idStrs = ids.split(",");
                for (String id : idStrs) {
                    StockPreSaleModifyDetail vo = new StockPreSaleModifyDetail();
                    vo.setId(Integer.valueOf(id));
                    succCount = stockPreSaleModifyServiceImpl.deleteStockPreSaleModifyDetail(vo);
                }
            }
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * TODO 新增商品预售
     * 
     * @param jsonData
     * @return
     */
    //    @ResponseBody
    //    @RequestMapping(value = "/insertStockPreSaleModifyAndDtl", method = RequestMethod.GET)
    //    public String insertStockPreSaleModifyAndDtl(@RequestParam("json") String jsonData) {
    //        stockLog.info("saveStockPreSale传入的参数为:" + jsonData);
    //        String resJson = "";
    //        try {
    //            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
    //            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);
    //
    //            //检查验证数据
    //            String msg = checkDataValied(req);
    //            if (msg != null && !("".equals(msg))) {
    //                res.setMsg(msg);
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            StockPreSaleModifyVo masterVo = req.getMaster();
    //            List<StockPreSaleModifyDetailVo> detailVoList = req.getDetailList();
    //
    //            //组装数据
    //            StockPreSaleModify masterBean = new StockPreSaleModify();
    //            List<StockPreSaleModifyDetail> detailBeanList = new ArrayList<StockPreSaleModifyDetail>();
    //            BeanUtils.copyProperties(masterBean, masterVo);
    //            for (StockPreSaleModifyDetailVo vo : detailVoList) {
    //                StockPreSaleModifyDetail beanDetail = new StockPreSaleModifyDetail();
    //                BeanUtils.copyProperties(beanDetail, vo);
    //                detailBeanList.add(beanDetail);
    //            }
    //
    //            try {
    //                //保存数据
    //                StockPreSaleModifyResultBean resultBean = this.stockPreSaleModifyServiceImpl.insertStockPreSaleModifyAndDtl(
    //                        masterBean,
    //                        detailBeanList);
    //                if (!resultBean.isSucess()) {
    //                    res.setMsg(resultBean.getMsg());
    //                    res.setSucess(false);
    //                    res.setMaster(masterVo);
    //                } else {
    //                    res.setSucess(true);
    //                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
    //                    res.setMaster(masterVo);
    //                }
    //            } catch (Exception ex) {
    //                stockLog.error("insertStockPreSale:插入商品预售表失败", ex);
    //            }
    //            resJson = JSON.toJSONString(res);
    //        } catch (Exception ex) {
    //            stockLog.error("insertStockPreSale操作出现异常:", ex);
    //            resJson = "";
    //        }
    //        return resJson;
    //    }

    /**
     * TODO 修改商品预售
     * 
     * @param jsonData
     * @return
     */
    //    @ResponseBody
    //    @RequestMapping(value = "/updateStockPreSaleModify", method = RequestMethod.GET)
    //    public String updateStockPreSaleModify(@RequestParam("json") String jsonData) {
    //        stockLog.info("updateStockPreSale传入的参数为:" + jsonData);
    //        String resJson = "";
    //        try {
    //            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
    //            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);
    //
    //            //检查验证数据
    //            String msg = checkDataValied(req);
    //            if (msg != null && !("".equals(msg))) {
    //                res.setMsg(msg);
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            StockPreSaleModifyVo masterVo = req.getMaster();
    //            List<StockPreSaleModifyDetailVo> detailVoList = req.getDetailList();
    //
    //            long id = masterVo.getId();
    //            if (id <= 0) {
    //                res.setMsg("预售主表ID值无效不能做修改操作");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            StockPreSaleModify newMasterBean = this.stockPreSaleModifyServiceImpl.getStockPreSaleModify(id);
    //            if (newMasterBean == null) { //没有查询到数据
    //                res.setMsg("根据预售主表ID" + id + "没有查询到数据");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
    //                BeanUtils.copyProperties(masterVo, newMasterBean);
    //                res.setMaster(masterVo);
    //                res.setMsg("当前商品预售已经审批,不允许做修改操作");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            List<StockPreSaleModifyDetail> insertDetailBeanList = new ArrayList<StockPreSaleModifyDetail>();
    //            //组装数据
    //            StockPreSaleModify masterBean = new StockPreSaleModify();
    //            List<StockPreSaleModifyDetail> detailBeanList = new ArrayList<StockPreSaleModifyDetail>();
    //            BeanUtils.copyProperties(masterBean, masterVo);
    //            for (StockPreSaleModifyDetailVo vo : detailVoList) {
    //                StockPreSaleModifyDetail beanDetail = new StockPreSaleModifyDetail();
    //                BeanUtils.copyProperties(beanDetail, vo);
    //                detailBeanList.add(beanDetail);
    //
    //                Integer detailId = beanDetail.getId();
    //                if (detailId == null || detailId <= 0) { //无id插入
    //                    insertDetailBeanList.add(beanDetail);
    //                }
    //            }
    //
    //            //检查明细数据是否不一致
    //            List<StockPreSaleModifyDetail> newDetailBeanList = this.stockPreSaleModifyServiceImpl.getStockPreSaleModifyDetailList(id);
    //            if (insertDetailBeanList.size() > 0) {
    //                newDetailBeanList.addAll(insertDetailBeanList);
    //            }
    //            if (detailBeanList.size() != newDetailBeanList.size()) {
    //                res.setMsg("明细数据发生过变更,不允许做修改操作");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //            insertDetailBeanList.clear();
    //            newDetailBeanList.clear();
    //
    //            try {
    //                //保存数据
    //                StockPreSaleModifyResultBean resultBean = this.stockPreSaleModifyServiceImpl.updateStockPreSaleModifyAndDtl(
    //                        masterBean,
    //                        detailBeanList);
    //                if (!resultBean.isSucess()) {
    //                    res.setMsg(resultBean.getMsg());
    //                    res.setSucess(false);
    //                    res.setMaster(masterVo);
    //                } else {
    //                    res.setSucess(true);
    //                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
    //                    res.setMaster(masterVo);
    //                }
    //            } catch (Exception ex) {
    //                stockLog.error("updateStockPreSale:插入商品预售表失败", ex);
    //            }
    //            resJson = JSON.toJSONString(res);
    //        } catch (Exception ex) {
    //            stockLog.error("updateStockPreSale操作出现异常:", ex);
    //            resJson = "";
    //        }
    //        return resJson;
    //    }

    /**
     * TODO 删除商品预售
     * 
     * @param jsonData
     * @return
     */
    //    @ResponseBody
    //    @RequestMapping(value = "/deleteStockPreSaleModify", method = RequestMethod.GET)
    //    public String deleteStockPreSaleModify(@RequestParam("json") String jsonData) {
    //        stockLog.info("deleteStockPreSale传入的参数为:" + jsonData);
    //        String resJson = "";
    //        try {
    //            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
    //            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);
    //
    //            StockPreSaleModifyVo masterVo = req.getMaster();
    //
    //            long id = masterVo.getId();
    //            if (id <= 0) {
    //                res.setMsg("预售主表ID值无效不能做删除操作");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            StockPreSaleModify newMasterBean = this.stockPreSaleModifyServiceImpl.getStockPreSaleModify(id);
    //            if (newMasterBean == null) { //没有查询到数据
    //                res.setMsg("根据预售主表ID" + id + "没有查询到数据");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
    //                BeanUtils.copyProperties(masterVo, newMasterBean);
    //                res.setMaster(masterVo);
    //                res.setMsg("当前商品预售已经审批,不允许做删除操作");
    //                res.setSucess(false);
    //                return JSON.toJSONString(res);
    //            }
    //
    //            //组装数据
    //            StockPreSaleModify masterBean = new StockPreSaleModify();
    //            BeanUtils.copyProperties(masterBean, masterVo);
    //
    //            try {
    //                //保存数据
    //                StockPreSaleModifyResultBean resultBean = this.stockPreSaleModifyServiceImpl.deleteStockPreSaleModify(masterBean);
    //                if (!resultBean.isSucess()) {
    //                    res.setMsg(resultBean.getMsg());
    //                    res.setSucess(false);
    //                    res.setMaster(masterVo);
    //                } else {
    //                    res.setSucess(true);
    //                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
    //                    res.setMaster(masterVo);
    //                }
    //            } catch (Exception ex) {
    //                stockLog.error("deleteStockPreSale:删除商品预售失败", ex);
    //            }
    //            resJson = JSON.toJSONString(res);
    //        } catch (Exception ex) {
    //            stockLog.error("deleteStockPreSale删除商品预售出现异常:", ex);
    //            resJson = "";
    //        }
    //        return resJson;
    //    }

    /**
     * TODO 审批商品预售
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitFlowStockPreSaleModify")
    public String submitFlowStockPreSaleModify(HttpServletRequest request) {
        Map<String, String> paraMap = assembleSelectParam(request);
        String jsonData = paraMap.get("json");
        stockLog.info("submitFlowStockPreSaleModify传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);

            StockPreSaleModifyVo masterVo = req.getMaster();

            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("商品预售调整单主表ID值无效不能做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSaleModify newMasterBean = this.stockPreSaleModifyServiceImpl.getStockPreSaleModify(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据商品预售调整单主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售调整单已经审批,不需要做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            } else if ("2".equals(newMasterBean.getExamineStatus())) { //已经撤销
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售调整单已经撤销,不能做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            try {
                //保存数据
                StockPreSaleModifyResultBean resultBean = this.stockPreSaleModifyServiceImpl.submitFlowStockPreSaleModify(newMasterBean);
                if (!resultBean.isSucess()) {
                    res.setMsg(resultBean.getMsg());
                    res.setSucess(false);
                    res.setMaster(masterVo);
                } else {
                    res.setSucess(true);
                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
                    res.setMaster(masterVo);
                }
            } catch (Exception ex) {
                stockLog.error("submitFlowStockPreSale:审批商品预售调整单失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("submitFlowStockPreSale审批出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * TODO 撤销商品预售
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelFlowStockPreSaleModify")
    public String cancelFlowStockPreSaleModify(HttpServletRequest request) {
        Map<String, String> paraMap = assembleSelectParam(request);
        String jsonData = paraMap.get("json");
        stockLog.info("cancelFlowStockPreSaleModify传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleModifyResVo res = new StockPreSaleModifyResVo();
            StockPreSaleModifyReqVo req = JSON.parseObject(jsonData, StockPreSaleModifyReqVo.class);

            StockPreSaleModifyVo masterVo = req.getMaster();

            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("商品预售调整单主表ID值无效不能做撤销操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSaleModify newMasterBean = this.stockPreSaleModifyServiceImpl.getStockPreSaleModify(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据商品预售调整单主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售调整单已经审批,不能做撤销操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            } else if ("2".equals(newMasterBean.getExamineStatus())) { //已经撤销
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售调整单已经撤销,不需要做撤销操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            //组装数据
            StockPreSaleModify masterBean = new StockPreSaleModify();
            BeanUtils.copyProperties(masterBean, masterVo);

            masterBean.setUpdateBy("0001");
            Calendar c = Calendar.getInstance();
            masterBean.setUpdateTime(c.getTime());
            masterBean.setExamineStatus("2"); //已撤销

            try {
                //保存数据
                StockPreSaleModifyResultBean resultBean = this.stockPreSaleModifyServiceImpl.updateStockPreSaleModify(masterBean);
                if (!resultBean.isSucess()) {
                    res.setMsg(resultBean.getMsg());
                    res.setSucess(false);
                    res.setMaster(masterVo);
                } else {
                    res.setSucess(true);
                    BeanUtils.copyProperties(masterVo, resultBean.getMasterBean());
                    res.setMaster(masterVo);
                }
            } catch (Exception ex) {
                stockLog.error("cancelFlowStockPreSaleModify:撤销商品预售调整单失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("cancelFlowStockPreSaleModify撤销出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * TODO 根据预售主表id查询预售主表信息
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getStockPreSaleModifyVo", method = RequestMethod.GET)
    public String getStockPreSaleModifyVo(@RequestParam("id") long id) {
        StockPreSaleModify stockPreSale = this.stockPreSaleModifyServiceImpl.getStockPreSaleModify(id);
        StockPreSaleModifyVo stockPreSaleVo = new StockPreSaleModifyVo();
        try {
            BeanUtils.copyProperties(stockPreSaleVo, stockPreSale);
        } catch (Exception ex) {
            return "";
        }
        return JSON.toJSONString(stockPreSaleVo);
    }

    /**
     * TODO 根据预售主表id查询预售明细信息
     * 
     * @param relationId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getStockPreSaleModifyDetailVoList", method = RequestMethod.GET)
    public String getStockPreSaleModifyDetailVoList(@RequestParam("relationId") long relationId) {
        List<StockPreSaleModifyDetail> detailBeanList = this.stockPreSaleModifyServiceImpl.getStockPreSaleModifyDetailList(relationId);
        List<StockPreSaleModifyDetailVo> detailBeanVoList = new ArrayList<StockPreSaleModifyDetailVo>();
        try {
            for (StockPreSaleModifyDetail detail : detailBeanList) {
                StockPreSaleModifyDetailVo detailVo = new StockPreSaleModifyDetailVo();
                BeanUtils.copyProperties(detailVo, detail);
                detailBeanVoList.add(detailVo);
            }
        } catch (Exception ex) {
            return "";
        }
        return JSON.toJSONString(detailBeanVoList);
    }

    /**
     * TODO 查询所有预售主表信息
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getStockPreSaleModifyList", method = RequestMethod.GET)
    public String getStockPreSaleModifyList() {
        List<StockPreSaleModify> masterList = this.stockPreSaleModifyServiceImpl.getStockPreSaleModifyList();
        List<StockPreSaleModifyVo> masterVoList = new ArrayList<StockPreSaleModifyVo>();
        try {
            for (StockPreSaleModify master : masterList) {
                StockPreSaleModifyVo masterVo = new StockPreSaleModifyVo();
                BeanUtils.copyProperties(masterVo, master);
                masterVoList.add(masterVo);
            }
        } catch (Exception ex) {
            return "";
        }
        return JSON.toJSONString(masterVoList);
    }

    @ResponseBody
    @RequestMapping(value = "/selectStockPreSaleModifyList")
    public String selectStockPreSaleModifyList(HttpServletRequest request) {
        List<StockPreSaleModify> masterList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            page = assemblePageSelect(paraMap);
            masterList = stockPreSaleModifyServiceImpl.selectPreSaleModifyList(paraListMap);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(masterList, page);
    }

    @ResponseBody
    @RequestMapping(value = "/selectStockPreSaleModifyDetailVoList")
    public String selectStockPreSaleModifyDetailVoList(HttpServletRequest request, HttpServletResponse response) {
        List<StockPreSaleModifyDetailVo> detailBeanVoList = new ArrayList<StockPreSaleModifyDetailVo>();
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }

            List<StockPreSaleModifyDetail> detailBeanList = this.stockPreSaleModifyServiceImpl.selectStockPreSaleModifyDetailList(paraListMap);
            if (StringUtils.isBlank(fileDownFlag)) {
                for (StockPreSaleModifyDetail detail : detailBeanList) {
                    StockPreSaleModifyDetailVo detailVo = new StockPreSaleModifyDetailVo();
                    BeanUtils.copyProperties(detailVo, detail);
                    detailBeanVoList.add(detailVo);
                }
            } else {
                List<StockPreSaleModifyDetailExcelBean> excelBeanList = new ArrayList<StockPreSaleModifyDetailExcelBean>();
                for (StockPreSaleModifyDetail detail : detailBeanList) {
                    StockPreSaleModifyDetailVo detailVo = new StockPreSaleModifyDetailVo();
                    BeanUtils.copyProperties(detailVo, detail);
                    detailBeanVoList.add(detailVo);

                    StockPreSaleModifyDetailExcelBean excelBean = new StockPreSaleModifyDetailExcelBean();
                    BeanUtils.copyProperties(excelBean, detail);
                    excelBeanList.add(excelBean);
                }
                //获取的预售渠道
                Map<String, List<String>> paramMap = new HashMap<>();
                String relationId = paraListMap.get("relationId").get(0);
                List<String> list = new ArrayList<>();
                list.add(relationId);
                paramMap.put("id", list);
                StockPreSaleModify stockPreSaleModify = stockPreSaleModifyServiceImpl.selectPreSaleModifyList(paramMap).get(0);
                String values = ImportExportDataUtil.getExportData(excelBeanList, StockPreSaleModifyDetailExcelBean.class);
                fileDownload("预售调整单_" + relationId + "_" + stockPreSaleModify.getChannelCode(), values, response);
                return null;
            }

        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(detailBeanVoList, page);
    }

    @ResponseBody
    @RequestMapping(value = "/selectStockPreSaleModifyDetailVo02List")
    public String selectStockPreSaleModifyDetailVo02List(HttpServletRequest request) {
        List<StockPreSaleModifyDetailVo> detailBeanVoList = new ArrayList<StockPreSaleModifyDetailVo>();
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            page = assemblePageSelect(paraMap);
            List<StockPreSaleModifyDetail> detailBeanList = this.stockPreSaleModifyServiceImpl.selectStockPreSaleModifyDetailList(paraListMap);
            Map<String, StockPreSaleModifyDetailVo> detailMap = new HashMap<String, StockPreSaleModifyDetailVo>();
            for (StockPreSaleModifyDetail detail : detailBeanList) {
                String prodId = detail.getProdId();
                StockPreSaleModifyDetailVo detailVo = detailMap.get(prodId);
                if (detailVo == null) {
                    detailVo = new StockPreSaleModifyDetailVo();
                    detailVo.setProdId(prodId);
                    detailVo.setStartTime(detail.getStartTime());
                    detailVo.setEndTime(detail.getEndTime());
                    detailVo.setEndTimeModify(detail.getEndTimeModify());
                    detailMap.put(prodId, detailVo);
                    detailBeanVoList.add(detailVo);
                }

            }
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(detailBeanVoList, page);
    }

    @ResponseBody
    @RequestMapping(value = "/selectStockPreSaleModifiedDetail")
    public String selectStockPreSaleModifiedDetail(HttpServletRequest request) {
        String resJson = "";
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            StockPreSaleModifyDetailVo detailBeanVo = null;
            List<StockPreSaleModifiedDetail> detailBeanList = this.stockPreSaleModifyServiceImpl.selectStockPreSaleModifiedDetailList(paraListMap);
            for (StockPreSaleModifiedDetail detail : detailBeanList) {
                detailBeanVo = new StockPreSaleModifyDetailVo();
                detailBeanVo.setPrePrivateStock(detail.getPrePrivateStock());
                detailBeanVo.setStartTime(detail.getStartTime());
                detailBeanVo.setEndTime(detail.getEndTime());

                break;
            }
            //resJson = JSON.toJSONString(detailBeanVo);
            //assembleSelectResult(obj)
            resJson = JSONObject.fromObject(detailBeanVo, jsonConfig).toString();
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return resJson;
    }

    @ResponseBody
    @RequestMapping(value = "/preSaleModifyDetailUpload")
    public String preSaleModifyDetailUpload(HttpServletRequest request, HttpServletResponse response) {
        String errCode = "";
        try {
            File file = fileUploadSingle(request);
            if (file == null) {
                return "文件找不到";
            }
            Map<String, String> paraMap = assembleRequestParam(request);
            long relationId = Long.parseLong(paraMap.get("relationId"));
            Map<String, List<String>> paramMap = new HashMap<>();
            List<String> list = new ArrayList<String>();
            list.add(String.valueOf(relationId));
            paramMap.put("id", list);
            List<StockPreSaleModify> stockPreSaleModifyList = this.stockPreSaleModifyServiceImpl.selectPreSaleModifyList(paramMap);
            if (stockPreSaleModifyList == null || stockPreSaleModifyList.size() <= 0) {
                //没有查询到对应的数据
                return "没有查询到对应的预售调整单数据";
            }
            StockPreSaleModify stockPreSaleModify = stockPreSaleModifyList.get(0);
            if (!("0".equals(stockPreSaleModify.getExamineStatus()))) { //非待审核状态不允许导入数据
                return "状态已改变,非待审核状态不允许导入数据";
            }
            // 获取文件编码格式
            String code = FileEncodeUtil.getFileEncode(file.getPath());
            List<String> fileStrs = FileUtils.readLines(file, code);

            errCode = stockPreSaleModifyServiceImpl.uploadPreSaleModifyDetail(stockPreSaleModify, fileStrs);
        } catch (Exception e) {
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        if (errCode == null || "".equals(errCode)) {
            return assembleUnSelectResult(1, "导入成功！");
        } else {
            return assembleUnSelectResult(0, errCode);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getDownFileTempLate")
    public void getDownFileTempLate(HttpServletRequest request, HttpServletResponse response) {
        getDownFileTempLate(response, StockPreSaleModifyDetailExcelBean.class);
    }
}
