package com.metersbonwe.stock.controller.presale;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.manager.service.StockPreSaleService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleDetail;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.StockPreSaleResultBean;
import com.metersbonwe.stock.utils.FileEncodeUtil;
import com.metersbonwe.stock.vo.presale.StockPreSaleDetailVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleReqVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleResVo;
import com.metersbonwe.stock.vo.presale.StockPreSaleVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;

@Controller public class StockPreSaleController extends BaseController {

    private static StockLog               stockLog = StockLogFactory.getLogger(StockPreSaleController.class);

    @Resource private StockPreSaleService stockPreSaleServiceImpl;

    private StockPreSaleReqVo getStockPreSaleReqVo() {
        StockPreSaleReqVo req = new StockPreSaleReqVo();
        StockPreSaleVo masterVo = new StockPreSaleVo();
        masterVo.setChannelCode("A00019S001");
        masterVo.setCreateBy("0001");
        Calendar c = Calendar.getInstance();
        masterVo.setCreateTime(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 20);
        Date startTime = c.getTime();
        masterVo.setStartTime(startTime);
        c.add(Calendar.DAY_OF_MONTH, 20);
        Date endTime = c.getTime();
        masterVo.setEndTime(endTime);

        List<StockPreSaleDetailVo> detailVoList = new ArrayList<StockPreSaleDetailVo>();
        StockPreSaleDetailVo vo = new StockPreSaleDetailVo();
        vo.setWarehId("HQ01W550");
        vo.setProdId("24822921130");
        vo.setPrePrivateStock(2);
        vo.setStartTime(startTime);
        vo.setEndTime(endTime);
        detailVoList.add(vo);

        StockPreSaleDetailVo vo1 = new StockPreSaleDetailVo();
        vo1.setWarehId("HQ01W700");
        vo1.setProdId("25737141136");
        vo1.setPrePrivateStock(2);
        vo1.setStartTime(startTime);
        vo1.setEndTime(endTime);
        detailVoList.add(vo1);

        StockPreSaleDetailVo vo2 = new StockPreSaleDetailVo();
        vo2.setWarehId("HQ01W850");
        vo2.setProdId("25737141136");
        vo2.setPrePrivateStock(4);
        vo2.setStartTime(startTime);
        vo2.setEndTime(endTime);
        detailVoList.add(vo2);

        req.setMaster(masterVo);
        req.setDetailList(detailVoList);
        return req;
    }

    private StockPreSaleReqVo getStockPreSaleReqVo_update() {
        StockPreSaleReqVo reqVo = getStockPreSaleReqVo();
        long id = 1459412316515L;
        reqVo.getMaster().setId(id);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 100);
        Date startTimeDate = c.getTime();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_MONTH, 200);
        Date endTimeDate = c1.getTime();
        int detailId = 6;
        List<StockPreSaleDetailVo> detailVoList = reqVo.getDetailList();
        for (StockPreSaleDetailVo detailVo : detailVoList) {
            detailId = detailId + 1;
            detailVo.setId(detailId);
            detailVo.setPrePrivateStock(100);
            detailVo.setStartTime(startTimeDate);
            detailVo.setEndTime(endTimeDate);
        }

        StockPreSaleDetailVo vo2 = new StockPreSaleDetailVo();
        vo2.setWarehId("HQ01W520");
        vo2.setProdId("25737141136");
        vo2.setPrePrivateStock(14);
        vo2.setStartTime(startTimeDate);
        vo2.setEndTime(endTimeDate);
        detailVoList.add(vo2);

        return reqVo;
    }

    private StockPreSaleReqVo getStockPreSaleReqVo_submit() {
        StockPreSaleReqVo reqVo = getStockPreSaleReqVo();
        long id = 1459412316515L;
        reqVo.getMaster().setId(id);
        Calendar c = Calendar.getInstance();
        reqVo.getMaster().setUpdateTime(c.getTime());
        return reqVo;
    }

    /**
     * TODO 检查验证数据是否有效
     * 
     * @param req
     * @return
     */
    private String checkDataValied(StockPreSaleReqVo req) {
        StockPreSaleVo masterVo = req.getMaster();
        String channelCode = masterVo.getChannelCode();
        if (channelCode == null || "".equals(channelCode)) {
            return "渠道编码为空";
        }

        List<StockPreSaleDetailVo> detailVoList = req.getDetailList();

        //检查同仓库同商品是否有多条记录
        Map<String, Integer> detailCountMap = new HashMap<String, Integer>();
        for (StockPreSaleDetailVo detailVo : detailVoList) {
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
        Map<String, StockPreSaleDetailVo> detailVoMap = new HashMap<String, StockPreSaleDetailVo>();
        for (StockPreSaleDetailVo detailVo : detailVoList) {
            String key = detailVo.getProdId();
            StockPreSaleDetailVo voBean = detailVoMap.get(key);
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
     * TODO 新增商品预售
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertStockPreSale", method = RequestMethod.GET)
    public String insertStockPreSale(@RequestParam("json") String jsonData) {
        stockLog.info("saveStockPreSale传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleResVo res = new StockPreSaleResVo();
            StockPreSaleReqVo req = getStockPreSaleReqVo();//JSON.parseObject(jsonData, StockPreSaleReqVo.class);

            //检查验证数据
            String msg = checkDataValied(req);
            if (msg != null && !("".equals(msg))) {
                res.setMsg(msg);
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSaleVo masterVo = req.getMaster();
            List<StockPreSaleDetailVo> detailVoList = req.getDetailList();

            //组装数据
            StockPreSale masterBean = new StockPreSale();
            List<StockPreSaleDetail> detailBeanList = new ArrayList<StockPreSaleDetail>();
            BeanUtils.copyProperties(masterBean, masterVo);
            for (StockPreSaleDetailVo vo : detailVoList) {
                StockPreSaleDetail beanDetail = new StockPreSaleDetail();
                BeanUtils.copyProperties(beanDetail, vo);
                detailBeanList.add(beanDetail);
            }

            try {
                //保存数据
                StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.insertStockPreSale(masterBean, detailBeanList);
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
                stockLog.error("insertStockPreSale:插入商品预售表失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("insertStockPreSale操作出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * TODO 修改商品预售
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStockPreSale", method = RequestMethod.GET)
    public String updateStockPreSale(@RequestParam("json") String jsonData) {
        stockLog.info("updateStockPreSale传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleResVo res = new StockPreSaleResVo();
            StockPreSaleReqVo req = getStockPreSaleReqVo_update();//JSON.parseObject(jsonData, StockPreSaleReqVo.class);

            //检查验证数据
            String msg = checkDataValied(req);
            if (msg != null && !("".equals(msg))) {
                res.setMsg(msg);
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSaleVo masterVo = req.getMaster();
            List<StockPreSaleDetailVo> detailVoList = req.getDetailList();

            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("预售主表ID值无效不能做修改操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSale newMasterBean = this.stockPreSaleServiceImpl.getStockPreSale(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据预售主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售已经审批,不允许做修改操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            List<StockPreSaleDetail> insertDetailBeanList = new ArrayList<StockPreSaleDetail>();
            //组装数据
            StockPreSale masterBean = new StockPreSale();
            List<StockPreSaleDetail> detailBeanList = new ArrayList<StockPreSaleDetail>();
            BeanUtils.copyProperties(masterBean, masterVo);
            for (StockPreSaleDetailVo vo : detailVoList) {
                StockPreSaleDetail beanDetail = new StockPreSaleDetail();
                BeanUtils.copyProperties(beanDetail, vo);
                detailBeanList.add(beanDetail);

                Integer detailId = beanDetail.getId();
                if (detailId == null || detailId <= 0) { //无id插入
                    insertDetailBeanList.add(beanDetail);
                }
            }

            //检查明细数据是否不一致
            List<StockPreSaleDetail> newDetailBeanList = this.stockPreSaleServiceImpl.getStockPreSaleDetailList(id);
            if (insertDetailBeanList.size() > 0) {
                newDetailBeanList.addAll(insertDetailBeanList);
            }
            if (detailBeanList.size() != newDetailBeanList.size()) {
                res.setMsg("明细数据发生过变更,不允许做修改操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            insertDetailBeanList.clear();
            newDetailBeanList.clear();

            try {
                //保存数据
                StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.updateStockPreSale(masterBean, detailBeanList);
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
                stockLog.error("updateStockPreSale:插入商品预售表失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("updateStockPreSale操作出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * TODO 删除商品预售
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteStockPreSale")
    public String deleteStockPreSale(@RequestParam("json") String jsonData) {
        stockLog.info("deleteStockPreSale传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleResVo res = new StockPreSaleResVo();
            StockPreSaleReqVo req = getStockPreSaleReqVo_submit();//JSON.parseObject(jsonData, StockPreSaleReqVo.class);

            StockPreSaleVo masterVo = req.getMaster();

            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("预售主表ID值无效不能做删除操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSale newMasterBean = this.stockPreSaleServiceImpl.getStockPreSale(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据预售主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售已经审批,不允许做删除操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            //组装数据
            StockPreSale masterBean = new StockPreSale();
            BeanUtils.copyProperties(masterBean, masterVo);

            try {
                //保存数据
                StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.deleteStockPreSale(masterBean);
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
                stockLog.error("deleteStockPreSale:删除商品预售失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("deleteStockPreSale删除商品预售出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * 审批商品预售
     * 
     * @param request
     *            request
     * @return String 审核结果
     */
    @ResponseBody
    @RequestMapping(value = "/submitFlowStockPreSale")
    public String submitFlowStockPreSaleModify(HttpServletRequest request) {
        Map<String, String> paraMap = assembleSelectParam(request);
        String jsonData = paraMap.get("json");
        stockLog.info("submitFlowStockPreSaleModify传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleResVo res = new StockPreSaleResVo();
            StockPreSaleReqVo req = JSON.parseObject(jsonData, StockPreSaleReqVo.class);
            StockPreSaleVo masterVo = req.getMaster();

            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("预售主表ID值无效不能做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            StockPreSale newMasterBean = this.stockPreSaleServiceImpl.getStockPreSale(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据预售主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            if ("1".equals(newMasterBean.getExamineStatus())) { //已经审批
                BeanUtils.copyProperties(masterVo, newMasterBean);
                res.setMaster(masterVo);
                res.setMsg("当前商品预售已经审批,不需要做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            } else if ("2".equals(newMasterBean.getExamineStatus())) {
                res.setMsg("当前商品预售已经撤销,不需要做审批操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }

            try {
                //保存数据
                StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.submitFlowStockPreSale(newMasterBean);
                BeanUtils.copyProperties(masterVo, newMasterBean);
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
                stockLog.error("submitFlowStockPreSale:审批商品预售失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("submitFlowStockPreSale审批出现异常:", ex);
            resJson = "";
        }
        return resJson;
    }

    /**
     * 撤销商品预售
     * 
     * @param request
     *            request请求
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/cancelFlowStockPreSale")
    public String cancelFlowStockPreSale(HttpServletRequest request) {
        Map<String, String> paraMap = assembleSelectParam(request);
        String jsonData = paraMap.get("json");
        stockLog.info("cancelFlowStockPreSale传入的参数为:" + jsonData);
        String resJson = "";
        try {
            StockPreSaleResVo res = new StockPreSaleResVo();
            StockPreSaleReqVo req = JSON.parseObject(jsonData, StockPreSaleReqVo.class);
            StockPreSaleVo masterVo = req.getMaster();
            long id = masterVo.getId();
            if (id <= 0) {
                res.setMsg("商品预售单主表ID值无效不能做撤销操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            StockPreSale newMasterBean = this.stockPreSaleServiceImpl.getStockPreSale(id);
            if (newMasterBean == null) { //没有查询到数据
                res.setMsg("根据商品预售单主表ID" + id + "没有查询到数据");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            if ("2".equals(newMasterBean.getExamineStatus())) { //已经撤销
                res.setMsg("当前商品预售单已经撤销,不需要做撤销操作");
                res.setSucess(false);
                return JSON.toJSONString(res);
            }
            //组装数据
            StockPreSale masterBean = new StockPreSale();
            BeanUtils.copyProperties(masterBean, masterVo);
            masterBean.setUpdateBy("0001");
            Calendar c = Calendar.getInstance();
            masterBean.setUpdateTime(c.getTime());
            masterBean.setExamineStatus(newMasterBean.getExamineStatus());
            try {
                //保存数据
                StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.cancelFlowStockPreSale(masterBean);
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
                stockLog.error("cancelFlowStockPreSale:撤销商品预售单失败", ex);
            }
            resJson = JSON.toJSONString(res);
        } catch (Exception ex) {
            stockLog.error("cancelFlowStockPreSale撤销出现异常:", ex);
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
    @RequestMapping(value = "/getStockPreSaleVo", method = RequestMethod.GET)
    public String getStockPreSaleVo(@RequestParam("id") long id) {
        StockPreSale stockPreSale = this.stockPreSaleServiceImpl.getStockPreSale(id);
        StockPreSaleVo stockPreSaleVo = new StockPreSaleVo();
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
    @RequestMapping(value = "/getStockPreSaleDetailVoList", method = RequestMethod.GET)
    public String getStockPreSaleDetailVoList(@RequestParam("relationId") long relationId) {
        List<StockPreSaleDetail> detailBeanList = this.stockPreSaleServiceImpl.getStockPreSaleDetailList(relationId);
        List<StockPreSaleDetailVo> detailBeanVoList = new ArrayList<StockPreSaleDetailVo>();
        try {
            for (StockPreSaleDetail detail : detailBeanList) {
                StockPreSaleDetailVo detailVo = new StockPreSaleDetailVo();
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
    @RequestMapping(value = "/getStockPreSaleList", method = RequestMethod.GET)
    public String getStockPreSaleList() {
        List<StockPreSale> masterList = this.stockPreSaleServiceImpl.getStockPreSaleList();
        List<StockPreSaleVo> masterVoList = new ArrayList<StockPreSaleVo>();
        try {
            for (StockPreSale master : masterList) {
                StockPreSaleVo masterVo = new StockPreSaleVo();
                BeanUtils.copyProperties(masterVo, master);
                masterVoList.add(masterVo);
            }
        } catch (Exception ex) {
            return "";
        }
        return JSON.toJSONString(masterVoList);
    }

    /**
     * @description 根據查詢條件查詢預售信息
     * @return 查询结果集合
     */
    @ResponseBody
    @RequestMapping(value = "/selectPreSale")
    public String selectPreSale(HttpServletRequest request) {
        List<StockPreSale> masterList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            page = assemblePageSelect(paraMap);
            masterList = stockPreSaleServiceImpl.selectPreSale(paraListMap);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(masterList, page);
    }

    /**
     * @description 根据预售主表ID查询预售子表信息
     * @param request
     *            客户端请求
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/selectPreSaleDetail")
    public String selectPreSaleDetail(HttpServletRequest request, HttpServletResponse response) {
        List<StockPreSaleDetail> stockPreSaleDetailList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);

            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            stockPreSaleDetailList = stockPreSaleServiceImpl.selectPreSaleDetail(paraListMap);

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                for (StockPreSaleDetail stockPreSaleDetail : stockPreSaleDetailList) {
                    objects.add(stockPreSaleDetail);
                }
                //获取的预售渠道
                Map<String, List<String>> paramMap = new HashMap<>();
                String relationId = paraListMap.get("relationId").get(0);
                List<String> list = new ArrayList<>();
                list.add(relationId);
                paramMap.put("id", list);
                StockPreSale stockPreSale = stockPreSaleServiceImpl.selectPreSale(paramMap).get(0);
                fileDownload(
                        "预售单_" + relationId + "_" + stockPreSale.getChannelCode(),
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.PRESALEDETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(stockPreSaleDetailList, page);
    }

    /**
     * @description 新增商品预售
     * @param request
     *            前台传递过来的参数等信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPreSale")
    public String addPreSale(HttpServletRequest request) {
        long newRecodeId = 0;
        try {
            //Map<String, String> paraMap = assembleUnSelectParam(request);
            Map<String, String> paraMap = new HashMap<>();
            String channelCode = request.getParameter("channelCode");
            String name = request.getParameter("name");
            paraMap.put("channelCode", channelCode);
            paraMap.put("name", name);
            StockPreSale vo = new StockPreSale();
            BeanUtils.populate(vo, paraMap);
            String user = "0001";
            vo.setCreateBy(user);
            vo.setCreateTime(new Date());
            vo.setUpdateBy(user);
            vo.setUpdateTime(new Date());
            vo.setExamineStatus("0");

            stockPreSaleServiceImpl.addPreSale(vo);
            newRecodeId = vo.getId();
        } catch (Exception e) {
            //errCode = Constants.DUPLICATION_ERROR_CODE;
            stockLog.error(e.getMessage(), e);
        }
        return String.valueOf(newRecodeId);
    }

    /**
     * @description 新增商品预售明细
     * @param request
     *            前台传递过来的参数等信息
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/addPreSaleDetail")
    public String addPreSaleDetail(HttpServletRequest request) {
        int insCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            insCount = stockPreSaleServiceImpl.addPreSaleDetail(paraMap);
        } catch (Exception e) {
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(insCount, errCode);
    }

    /**
     * @description 根据relationId获取已存在的sku信息
     * @param request
     *            客户端请求
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/getExistPreSaleDetail")
    public String getExistPreSaleDetail(HttpServletRequest request) {
        List<StockPreSaleDetail> masterList = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            masterList = stockPreSaleServiceImpl.getExistPreSaleDetail(paraListMap);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleSelectResult(masterList);
    }

    /**
     * @description 更新预售主表信息
     * @param request
     *            请求参数
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/updatePreSale")
    public String updatePreSale(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            succCount = stockPreSaleServiceImpl.updatePreSale(paraMap);
        } catch (Exception e) {
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * @description 更新预售明细表信息
     * @param request
     *            请求参数
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/updatePreSaleDetail")
    public String updatePreSaleDetail(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            succCount = stockPreSaleServiceImpl.updatePreSaleDetail(paraMap);
        } catch (Exception e) {
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * @description 删除预售明细
     * @param request
     *            请求参数
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/deletePreSaleDetail")
    public String deletePreSaleDetail(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            succCount = stockPreSaleServiceImpl.deletePreSaleDetail(paraMap);
        } catch (Exception e) {
            //TODO errCode修改
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    @ResponseBody
    @RequestMapping(value = "/preSaleDetailUpload")
    public String preSaleDetailUpload(HttpServletRequest request, HttpServletResponse response) {
        String errCode = "";
        try {
            File file = fileUploadSingle(request);
            if (file == null) {
                return "";
            }
            Map<String, String> paraMap = assembleRequestParam(request);
            String code = FileEncodeUtil.getFileEncode(file.getPath());
            List<String> fileStrs = FileUtils.readLines(file, code);
            long relationId = Long.parseLong(paraMap.get("relationId"));
            errCode = stockPreSaleServiceImpl.uploadPreSaleDetail(fileStrs, relationId);
        } catch (Exception e) {
            errCode = e.getMessage();
            stockLog.error(e.getMessage(), e);
        }
        int status = errCode.length() > 0 ? 0 : 1;
        errCode = errCode.length() > 0 ? errCode : "文件上传成功";
        return assembleUnSelectResult(status, errCode);
    }

}
