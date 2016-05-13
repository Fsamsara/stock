package com.metersbonwe.stock.biz.schedule.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.b2b.udc.dubbo.api.AdDeliveryTimeDubboService;
import org.b2b.udc.dubbo.api.AdjustmentReservedDubboService;
import org.b2b.udc.dubbo.api.model.AdDeliveryTimeDtlDubboBean;
import org.b2b.udc.dubbo.api.model.AdDeliveryTimeDubboBean;
import org.b2b.udc.dubbo.api.model.AdjustmentReservedDtlDubboBean;
import org.b2b.udc.dubbo.api.model.AdjustmentReservedDubboBean;
import org.b2b.udc.dubbo.api.model.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleModifyDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleModifyMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleReservedHstMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleReservedMapper;
import com.metersbonwe.stock.facade.schedule.StockPreSaleFacadeService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleDetail;
import com.metersbonwe.stock.po.core.StockPreSaleDetailExample;
import com.metersbonwe.stock.po.core.StockPreSaleModify;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetailExample;
import com.metersbonwe.stock.po.core.StockPreSaleReserved;
import com.metersbonwe.stock.po.core.StockPreSaleReservedExample;
import com.metersbonwe.stock.po.core.StockPreSaleReservedHst;
import com.metersbonwe.stock.po.core.StockPreSaleReservedHstExample;
import com.metersbonwe.stock.pojo.Page;

@Service public class StockPreSaleFacadeServiceImpl implements StockPreSaleFacadeService {

    private static StockLog                           logger                       = StockLogFactory.getLogger(StockPreSaleFacadeServiceImpl.class);

    @Autowired private StockPreSaleReservedMapper     stockPreSaleReservedMapper;

    @Autowired private StockPreSaleReservedHstMapper  stockPreSaleReservedHstMapper;

    @Autowired private StockPreSaleMapper             stockPreSaleMapper;

    @Autowired private StockPreSaleDetailMapper       stockPreSaleDetailMapper;

    @Autowired private StockPreSaleModifyMapper       stockPreSaleModifyMapper;

    @Autowired private StockPreSaleModifyDetailMapper stockPreSaleModifyDetailMapper;

    @Resource private AdDeliveryTimeDubboService      adDeliveryTimeDubboService;

    @Resource private AdjustmentReservedDubboService  adjustmentReservedDubboService;

    //调整类别:需求增加
    private final String                              CONST_RESERVE_ORDERTYPE_ADD  = "URINSERT";

    //调整类别:需求释放
    private final String                              CONST_RESERVE_ORDERTYPE_FREE = "LDRELEASE";

    //预留类型
    private final String                              CONST_RESERVE_URTYPE         = "39";

    /**
     * TODO 把预售、预售调整传递给B2B做预留
     * 
     * @see com.metersbonwe.stock.facade.schedule.StockPreSaleFacadeService#processStockPreSalePassToReserved()
     */
    @Override
    public void processStockPreSalePassToReserved() {
        try {
            logger.debug("processStockPreSalePassToReserved:预售转预留定时任务开启");
            process();
            logger.debug("processStockPreSalePassToReserved:预售转预留定时任务执行完成");
        } catch (Exception ex) {
            logger.error("定时任务拉取商品预售、商品预售调整数据并处理出错：" + ex);
        } finally {
            logger.debug("processStockPreSalePassToReserved:预售转预留定时任务结束");
        }
    }

    /**
     * 实际处理类
     */
    private void process() throws Exception {
        StockPreSaleReservedExample example = new StockPreSaleReservedExample();
        example.setOrderByClause("create_time");
        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(5000); //每次查询5000条记录
        List<StockPreSaleReserved> list = this.stockPreSaleReservedMapper.selectByExample(example);
        if (list == null || list.size() <= 0) {
            logger.info("目前没有找到需要发送去生成预留的数据");
            return;
        }
        for (StockPreSaleReserved preSaleReserved : list) {
            long relationId = preSaleReserved.getRelationId();
            short optionType = preSaleReserved.getOptionType(); //1:预售需求增加 2:预售调整数量 3:预售调整时间
            try {
                logger.info("开始执行单据" + String.valueOf(relationId) + ",类型" + String.valueOf(optionType));

                //调用分配系统的预留独占接口，把预售参数实体对象传过去
                String msg = passToReserved(relationId, optionType);
                if (msg != null && !("".equals(msg))) {
                    logger.error("调用分配系统的预留独占接口不成功，原因" + msg + ",参数：单据" + String.valueOf(relationId) + ",类型" + String.valueOf(optionType));

                    preSaleReserved.setRemark(msg);
                    this.stockPreSaleReservedMapper.updateByPrimaryKeySelective(preSaleReserved);
                    continue;
                }

                //把数据转移到历史记录表，并删除自己表中当前数据
                updateData(preSaleReserved);

                logger.info("执行成功单据" + String.valueOf(relationId) + ",类型" + String.valueOf(optionType));
            } catch (Exception ex) {
                logger.error("执行单据" + String.valueOf(relationId) + ",类型" + String.valueOf(optionType) + "出现异常", ex);

                preSaleReserved.setRemark(ex.getMessage());
                try {
                    this.stockPreSaleReservedMapper.updateByPrimaryKeySelective(preSaleReserved);
                } catch (Exception e) {
                    logger.error("更新错误数据到表中出现异常", e);
                    continue;
                }

                continue;
            }
        }
    }

    /**
     * TODO 1:预售需求增加(需求增加)
     * 
     * @param id
     * @return
     */
    private String passToReserved_ONE(long id, String orderType) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        boolean isFreed = CONST_RESERVE_ORDERTYPE_FREE.equals(orderType); //需求释放
        StockPreSale stockPreSale = this.stockPreSaleMapper.selectByPrimaryKey(id);

        StockPreSaleDetailExample example = new StockPreSaleDetailExample();
        example.createCriteria().andRelationIdEqualTo(id);
        List<StockPreSaleDetail> stockPreSaleDetailList = this.stockPreSaleDetailMapper.selectByExample(example);

        Map<String, StockPreSaleDetail> stockPreSaleDetailMap = new HashMap<String, StockPreSaleDetail>();
        List<AdjustmentReservedDtlDubboBean> reserveDtlDubboBeanList = new ArrayList<AdjustmentReservedDtlDubboBean>();
        for (StockPreSaleDetail stockPreSaleDetail : stockPreSaleDetailList) {
            String warehId = stockPreSaleDetail.getWarehId();
            String prodId = stockPreSaleDetail.getProdId();
            String key = warehId + ":" + prodId;
            if (!stockPreSaleDetailMap.containsKey(key)) {
                stockPreSaleDetail.setReservedStatus(1); //默认设置为成功
                stockPreSaleDetailMap.put(key, stockPreSaleDetail);
            }
            AdjustmentReservedDtlDubboBean reserveDtlDubboBean = new AdjustmentReservedDtlDubboBean();
            reserveDtlDubboBean.setUnitCode(stockPreSale.getChannelCode());
            reserveDtlDubboBean.setWarehCode(warehId);
            reserveDtlDubboBean.setProdCode(prodId);
            reserveDtlDubboBean.setOrderType(orderType);
            int v = stockPreSaleDetail.getPrePrivateStock();
            if (isFreed) { //需求释放
                v = -v;
            }
            reserveDtlDubboBean.setAdQty(Double.valueOf(v));
            reserveDtlDubboBean.setUrType(CONST_RESERVE_URTYPE);
            reserveDtlDubboBean.setDeliveryDate(dateFormater.format(stockPreSaleDetail.getEndTime()));
            reserveDtlDubboBeanList.add(reserveDtlDubboBean);
        }
        AdjustmentReservedDubboBean reserveDubboBean = new AdjustmentReservedDubboBean();
        reserveDubboBean.setDocState("1");
        reserveDubboBean.setName(stockPreSale.getName());
        reserveDubboBean.setRelationId(String.valueOf(id));
        if (isFreed) {
            reserveDubboBean.setRemark("C" + String.valueOf(id));
        } else {
            reserveDubboBean.setRemark(String.valueOf(id));
        }
        reserveDubboBean.setUser(stockPreSale.getUpdateBy());
        reserveDubboBean.setAdjustmentReservedDtls(reserveDtlDubboBeanList);

        String jsonData = JSON.toJSONString(reserveDubboBean);
        logger.debug("passToReserved_ONE调用预留传入参数:" + jsonData);
        String jsonResultData = this.adjustmentReservedDubboService.addAndhandle(jsonData);
        logger.debug("passToReserved_ONE调用预留返回参数:" + jsonResultData);

        try {
            @SuppressWarnings("unchecked")
            ResultBean<JSONObject> resultBean = JSON.parseObject(jsonResultData, ResultBean.class);
            List<JSONObject> errList = resultBean.getErrDtls();
            if (errList != null && errList.size() > 0) {
                List<StockPreSaleDetail> updatePreSaleDetailList = new ArrayList<>();
                for (JSONObject jsonObject : errList) {

                    String warehId = jsonObject.getString("warehCode");
                    String prodId = jsonObject.getString("prodCode");
                    String errMsg = jsonObject.getString("errMsg");
                    String key = warehId + ":" + prodId;
                    StockPreSaleDetail stockPreSaleDetail = stockPreSaleDetailMap.get(key);
                    if (stockPreSaleDetail != null) {
                        StockPreSaleDetail upPreSaleDetail = new StockPreSaleDetail();
                        upPreSaleDetail.setId(stockPreSaleDetail.getId());
                        upPreSaleDetail.setReservedStatus(2);
                        upPreSaleDetail.setReservedRemark(errMsg);
                        updatePreSaleDetailList.add(upPreSaleDetail);
                    }
                }
                updateStockPreSaleDetailReservedRemark(updatePreSaleDetailList);
            }

            if (resultBean.getIsSuccess()) {
                return "";
            } else {
                return resultBean.getErrMsg();
            }
        } catch (Exception ex) {
            return "操作失败," + ex.getMessage();
        }
    }

    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private void updateStockPreSaleDetailReservedRemark(List<StockPreSaleDetail> stockPreSaleDetailList) {
        for (StockPreSaleDetail stockPreSaleDetail : stockPreSaleDetailList) {
            stockPreSaleDetailMapper.updateByPrimaryKeySelective(stockPreSaleDetail);
        }
    }

    /**
     * TODO 2:预售调整数量(需求增加，需求释放)
     * 
     * @param id
     * @return
     */
    private String passToReserved_TWO(long id) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

        StockPreSaleModify stockPreSaleModify = this.stockPreSaleModifyMapper.selectByPrimaryKey(id);
        StockPreSaleModifyDetailExample example = new StockPreSaleModifyDetailExample();
        example.createCriteria().andRelationIdEqualTo(id);
        List<StockPreSaleModifyDetail> stockPreSaleModifyDetailList = this.stockPreSaleModifyDetailMapper.selectByExample(example);
        Map<String, StockPreSaleModifyDetail> stockPreSaleModifyDetailMap = new HashMap<String, StockPreSaleModifyDetail>();

        List<AdjustmentReservedDtlDubboBean> reserveDtlDubboBeanList = new ArrayList<AdjustmentReservedDtlDubboBean>();
        for (StockPreSaleModifyDetail stockPreSaleModifyDetail : stockPreSaleModifyDetailList) {
            String warehId = stockPreSaleModifyDetail.getWarehId();
            String prodId = stockPreSaleModifyDetail.getProdId();
            String key = warehId + ":" + prodId;
            if (!stockPreSaleModifyDetailMap.containsKey(key)) {
                stockPreSaleModifyDetail.setReservedStatus(1); //默认设置为成功
                stockPreSaleModifyDetailMap.put(key, stockPreSaleModifyDetail);
            }
            AdjustmentReservedDtlDubboBean reserveDtlDubboBean = new AdjustmentReservedDtlDubboBean();
            reserveDtlDubboBean.setUnitCode(stockPreSaleModify.getChannelCode());
            reserveDtlDubboBean.setWarehCode(stockPreSaleModifyDetail.getWarehId());
            reserveDtlDubboBean.setProdCode(stockPreSaleModifyDetail.getProdId());
            int v = stockPreSaleModifyDetail.getPrePrivateStockModify();
            int v1 = stockPreSaleModifyDetail.getPrePrivateStock();
            if (v - v1 > 0) { //需求增加
                reserveDtlDubboBean.setOrderType(CONST_RESERVE_ORDERTYPE_ADD);
            } else { //需求释放
                reserveDtlDubboBean.setOrderType(CONST_RESERVE_ORDERTYPE_FREE);
            }
            reserveDtlDubboBean.setAdQty(Double.valueOf(v - v1));
            reserveDtlDubboBean.setUrType(CONST_RESERVE_URTYPE);
            reserveDtlDubboBean.setDeliveryDate(dateFormater.format(stockPreSaleModifyDetail.getEndTime()));

            reserveDtlDubboBeanList.add(reserveDtlDubboBean);
        }
        AdjustmentReservedDubboBean reserveDubboBean = new AdjustmentReservedDubboBean();
        reserveDubboBean.setDocState("1");
        reserveDubboBean.setName(stockPreSaleModify.getName());
        reserveDubboBean.setRemark("T" + String.valueOf(stockPreSaleModify.getId()));
        reserveDubboBean.setRelationId(String.valueOf(stockPreSaleModify.getRelationId()));
        reserveDubboBean.setUser(stockPreSaleModify.getUpdateBy());
        reserveDubboBean.setAdjustmentReservedDtls(reserveDtlDubboBeanList);

        String jsonData = JSON.toJSONString(reserveDubboBean);
        logger.debug("passToReserved_TWO调用预留传入参数:" + jsonData);
        String jsonResultData = this.adjustmentReservedDubboService.addAndhandle(jsonData);
        logger.debug("passToReserved_TWO调用预留返回参数:" + jsonResultData);

        try {
            @SuppressWarnings("unchecked")
            ResultBean<JSONObject> resultBean = JSON.parseObject(jsonResultData, ResultBean.class);
            List<JSONObject> errList = resultBean.getErrDtls();
            if (errList != null && errList.size() > 0) {
                List<StockPreSaleModifyDetail> updatePreSaleModifyDetailList = new ArrayList<>();
                for (JSONObject jsonObject : errList) {
                    String warehId = jsonObject.getString("warehCode");
                    String prodId = jsonObject.getString("prodCode");
                    String errMsg = jsonObject.getString("errMsg");
                    String key = warehId + ":" + prodId;
                    StockPreSaleModifyDetail stockPreSaleModifyDetail = stockPreSaleModifyDetailMap.get(key);
                    if (stockPreSaleModifyDetail != null) {
                        StockPreSaleModifyDetail upPreSaleModifyDetail = new StockPreSaleModifyDetail();
                        upPreSaleModifyDetail.setId(stockPreSaleModifyDetail.getId());
                        upPreSaleModifyDetail.setReservedStatus(2);
                        upPreSaleModifyDetail.setReservedRemark(errMsg);
                        updatePreSaleModifyDetailList.add(upPreSaleModifyDetail);
                    }
                }
                updateStockPreSaleModifyDetailReservedRemark(updatePreSaleModifyDetailList);
            }

            if (resultBean.getIsSuccess()) {
                return "";
            } else {
                return resultBean.getErrMsg();
            }
        } catch (Exception ex) {
            return "操作失败," + ex.getMessage();
        }
    }

    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private void updateStockPreSaleModifyDetailReservedRemark(List<StockPreSaleModifyDetail> stockPreSaleModifyDetailList) {
        for (StockPreSaleModifyDetail stockPreSaleModifyDetail : stockPreSaleModifyDetailList) {
            stockPreSaleModifyDetailMapper.updateByPrimaryKeySelective(stockPreSaleModifyDetail);
        }
    }

    /**
     * TODO 3:预售调整时间
     * 
     * @param id
     * @return
     */
    private String passToReserved_THREE(long id) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

        StockPreSaleModify stockPreSaleModify = this.stockPreSaleModifyMapper.selectByPrimaryKey(id);
        StockPreSaleModifyDetailExample example = new StockPreSaleModifyDetailExample();
        example.createCriteria().andRelationIdEqualTo(id);
        List<StockPreSaleModifyDetail> stockPreSaleModifyDetailList = this.stockPreSaleModifyDetailMapper.selectByExample(example);
        Map<String, StockPreSaleModifyDetail> stockPreSaleModifyDetailMap = new HashMap<String, StockPreSaleModifyDetail>();

        List<AdDeliveryTimeDtlDubboBean> timeDtlDubboBeanList = new ArrayList<AdDeliveryTimeDtlDubboBean>();
        for (StockPreSaleModifyDetail stockPreSaleModifyDetail : stockPreSaleModifyDetailList) {
            String prodId = stockPreSaleModifyDetail.getProdId();
            String key = prodId;
            if (!stockPreSaleModifyDetailMap.containsKey(key)) {
                stockPreSaleModifyDetail.setReservedStatus(1); //默认设置为成功
                stockPreSaleModifyDetailMap.put(key, stockPreSaleModifyDetail);
            }

            AdDeliveryTimeDtlDubboBean timeDtlDubboBean = new AdDeliveryTimeDtlDubboBean();
            timeDtlDubboBean.setUnitCode(stockPreSaleModify.getChannelCode());
            //timeDtlDubboBean.setWarehCode(stockPreSaleModifyDetail.getWarehId());
            timeDtlDubboBean.setProdCode(stockPreSaleModifyDetail.getProdId());
            timeDtlDubboBean.setUrType(CONST_RESERVE_URTYPE);
            timeDtlDubboBean.setRecDeliveryDate(dateFormater.format(stockPreSaleModifyDetail.getEndTimeModify()));

            timeDtlDubboBeanList.add(timeDtlDubboBean);
        }
        AdDeliveryTimeDubboBean timeDubboBean = new AdDeliveryTimeDubboBean();
        timeDubboBean.setDocState("1");
        timeDubboBean.setName(stockPreSaleModify.getName());
        timeDubboBean.setRemark("T" + String.valueOf(stockPreSaleModify.getId()));
        timeDubboBean.setRelationId(String.valueOf(stockPreSaleModify.getRelationId()));
        timeDubboBean.setUser(stockPreSaleModify.getUpdateBy());
        timeDubboBean.setAdDeliveryTimeDtls(timeDtlDubboBeanList);

        String jsonData = JSON.toJSONString(timeDubboBean);
        logger.debug("passToReserved_THREE调用预留传入参数:" + jsonData);
        String jsonResultData = this.adDeliveryTimeDubboService.addAndhandle(jsonData);
        logger.debug("passToReserved_THREE调用预留返回参数:" + jsonResultData);

        try {
            @SuppressWarnings("unchecked")
            ResultBean<JSONObject> resultBean = JSON.parseObject(jsonResultData, ResultBean.class);
            List<JSONObject> errList = resultBean.getErrDtls();
            if (errList != null && errList.size() > 0) {
                List<StockPreSaleModifyDetail> updatePreSaleModifyDetailList = new ArrayList<>();
                for (JSONObject jsonObject : errList) {
                    String prodId = jsonObject.getString("prodCode");
                    String errMsg = jsonObject.getString("errMsg");
                    String key = prodId;
                    StockPreSaleModifyDetail stockPreSaleModifyDetail = stockPreSaleModifyDetailMap.get(key);
                    if (stockPreSaleModifyDetail != null) {
                        StockPreSaleModifyDetail upPreSaleModifyDetail = new StockPreSaleModifyDetail();
                        upPreSaleModifyDetail.setId(stockPreSaleModifyDetail.getId());
                        upPreSaleModifyDetail.setReservedStatus(2);
                        upPreSaleModifyDetail.setReservedRemark(errMsg);
                        updatePreSaleModifyDetailList.add(upPreSaleModifyDetail);
                    }
                }
                updateStockPreSaleModifyDetailReservedRemark(updatePreSaleModifyDetailList);
            }

            if (resultBean.getIsSuccess()) {
                return "";
            } else {
                return resultBean.getErrMsg();
            }
        } catch (Exception ex) {
            return "操作失败," + ex.getMessage();
        }
    }

    /**
     * TODO 调用分配系统的预留独占接口，把预售参数实体对象传过去
     * 
     * @param relationId
     * @param optionType
     *            1:预售需求增加(需求增加) 2:预售调整数量(需求增加，需求释放) 3:预售调整时间
     * @return
     */
    private String passToReserved(long id, short optionType) {
        String msg = "";
        if (optionType == 1) { //预售单
            msg = passToReserved_ONE(id, CONST_RESERVE_ORDERTYPE_ADD);
        } else if (optionType == 4) { //撤销已经审核的预售单
            msg = passToReserved_ONE(id, CONST_RESERVE_ORDERTYPE_FREE);
        } else { //预售调整单
            if (optionType == 2) { //预售调整数量(需求增加，需求释放)
                msg = passToReserved_TWO(id);
            } else { //预售调整时间 
                msg = passToReserved_THREE(id);
            }
        }

        //        ResultBean resultBean = JSON.parseObject(jsonResultData, ResultBean.class);
        //        List errList = resultBean.getErrDtls();
        //        if (resultBean.getIsSuccess()) {
        //            msg = "";
        //        } else {
        //
        //            msg = resultBean.getErrMsg();
        //        }

        return msg;
    }

    /**
     * TODO 把数据转移到历史记录表，并删除自己表中当前数据
     * 
     * @param preSaleReserved
     */
    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private void updateData(StockPreSaleReserved preSaleReserved) {
        int id = preSaleReserved.getId();
        long relationId = preSaleReserved.getRelationId();
        short optionType = preSaleReserved.getOptionType();
        boolean isDeleted = false;

        StockPreSaleReservedHstExample example = new StockPreSaleReservedHstExample();
        example.createCriteria().andRelationIdEqualTo(relationId).andOptionTypeEqualTo(optionType);
        List<StockPreSaleReservedHst> hstList = this.stockPreSaleReservedHstMapper.selectByExample(example);
        if (hstList == null || hstList.size() <= 0) {
            StockPreSaleReservedHst preSaleReservedHst = new StockPreSaleReservedHst();
            preSaleReservedHst.setRelationId(relationId);
            preSaleReservedHst.setOptionType(optionType);
            preSaleReservedHst.setrCreateTime(preSaleReserved.getCreateTime());
            preSaleReservedHst.setCreateTime(new Date());

            int rCount = this.stockPreSaleReservedHstMapper.insertSelective(preSaleReservedHst);
            isDeleted = rCount > 0;
        } else {
            isDeleted = true;
        }
        if (isDeleted) {
            this.stockPreSaleReservedMapper.deleteByPrimaryKey(id);
        }
    }

}

class ResultBean_s extends ResultBean<AdjustmentReservedDtlDubboBean> {

}
