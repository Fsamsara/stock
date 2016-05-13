package com.metersbonwe.stock.biz.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metersbonwe.stock.ExceptionConstants.ExceptionCode;
import com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleModifiedDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleModifyDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleModifyMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleReservedMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleResultMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetailExample;
import com.metersbonwe.stock.po.core.StockPreSaleModify;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetailExample;
import com.metersbonwe.stock.po.core.StockPreSaleModifyExample;
import com.metersbonwe.stock.po.core.StockPreSaleReserved;
import com.metersbonwe.stock.po.core.StockPreSaleResult;
import com.metersbonwe.stock.po.core.StockPreSaleResultExample;
import com.metersbonwe.stock.pojo.StockPreSaleModifyResultBean;
import com.metersbonwe.stock.pojo.imexcel.StockPreSaleModifyDetailExcelBean;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;

@Service public class StockPreSaleModifyServiceImpl implements StockPreSaleModifyService {

    private static StockLog                             stockLog             = StockLogFactory.getLogger(StockPreSaleModifyServiceImpl.class);

    @Autowired private StockPreSaleModifyMapper         stockPreSaleModifyMapper;

    @Autowired private StockPreSaleModifyDetailMapper   stockPreSaleModifyDetailMapper;

    @Autowired private StockPreSaleModifiedDetailMapper stockPreSaleModifiedDetailMapper;

    @Autowired private StockPreSaleResultMapper         stockPreSaleResultMapper;

    @Autowired private StockPreSaleReservedMapper       stockPreSaleReservedMapper;

    //调整数量
    private final String                                CONST_MODIFY_TYPE_01 = "01";

    /**
     * TODO 保存商品预售调整单
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#insertStockPreSaleModify(com.metersbonwe.stock.po.core.StockPreSaleModify)
     */
    @Override
    public StockPreSaleModifyResultBean insertStockPreSaleModify(StockPreSaleModify masterBean) throws Exception {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        long id = System.currentTimeMillis();
        masterBean.setId(id);

        int rCount = this.stockPreSaleModifyMapper.insertSelective(masterBean);
        if (rCount <= 0) {
            throw new Exception("插入商品预售主表失败,返回记录数" + rCount + ",渠道为" + masterBean.getChannelCode());
        }

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 修改商品预售调整单
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#updateStockPreSaleModify(com.metersbonwe.stock.po.core.StockPreSaleModify)
     */
    @Override
    public StockPreSaleModifyResultBean updateStockPreSaleModify(StockPreSaleModify masterBean) throws Exception {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        int rCount = this.stockPreSaleModifyMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount <= 0) {
            throw new Exception("修改商品预售主表失败,返回记录数" + rCount + ",渠道为" + masterBean.getChannelCode());
        }

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 插入商品预售调整单明细
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#insertStockPreSaleModifyDetail(com.metersbonwe.stock.po.core.StockPreSaleModifyDetail)
     */
    @Override
    public int insertStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean) throws Exception {
        //检查数据是否重复
        String prodId = detailBean.getProdId();
        String warehId = detailBean.getWarehId();
        StockPreSaleModifyDetailExample example = new StockPreSaleModifyDetailExample();
        StockPreSaleModifyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andRelationIdEqualTo(detailBean.getRelationId()).andProdIdEqualTo(prodId);
        if (warehId != null && !("".equals(warehId))) {
            criteria.andWarehIdEqualTo(warehId);
        }
        List<StockPreSaleModifyDetail> list = this.stockPreSaleModifyDetailMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            throw new Exception("插入商品预售调整明细失败,商品为" + detailBean.getProdId() + ",仓库为" + detailBean.getWarehId() + "已经存在,不允许重复！");
        }
        int rCount = this.stockPreSaleModifyDetailMapper.insertSelective(detailBean);
        if (rCount <= 0) {
            throw new Exception("插入商品预售调整明细失败,返回记录数" + rCount + ",商品为" + detailBean.getProdId() + ",仓库为" + detailBean.getWarehId());
        }
        return rCount;
    }

    /**
     * TODO 修改商品预售调整单明细
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#updateStockPreSaleModifyDetail(com.metersbonwe.stock.po.core.StockPreSaleModifyDetail)
     */
    @Override
    public int updateStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean) throws Exception {
        int rCount = this.stockPreSaleModifyDetailMapper.updateByPrimaryKeySelective(detailBean);
        if (rCount <= 0) {
            throw new Exception("修改商品预售调整明细失败,返回记录数" + rCount + ",商品为" + detailBean.getProdId() + ",仓库为" + detailBean.getWarehId());
        }
        return rCount;
    }

    /**
     * TODO 删除商品预售调整单明细
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#deleteStockPreSaleModifyDetail(com.metersbonwe.stock.po.core.StockPreSaleModifyDetail)
     */
    @Override
    public int deleteStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean) {
        return this.stockPreSaleModifyDetailMapper.deleteByPrimaryKey(detailBean.getId());
    }

    /**
     * TODO 保存商品预售调整单和明细
     * 
     * @throws Exception
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#saveStockPreSale(com.metersbonwe.stock.pojo.StockPreSaleBean,
     *      java.util.List)
     */
    @Override
    @Transactional
    public StockPreSaleModifyResultBean insertStockPreSaleModifyAndDtl(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList)
            throws Exception {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        long id = System.currentTimeMillis();
        masterBean.setId(id);

        int rCount = this.stockPreSaleModifyMapper.insertSelective(masterBean);
        if (rCount > 0) {
            int dCount = 0;
            for (StockPreSaleModifyDetail detail : detailBeanList) {
                detail.setId(null);
                detail.setRelationId(id);
                dCount = dCount + this.stockPreSaleModifyDetailMapper.insertSelective(detail);
            }
            if (dCount != detailBeanList.size()) {
                throw new Exception("商品预售明细保存失败");
            }
        } else {
            throw new Exception("插入商品预售主表失败,返回记录数" + rCount + ",渠道为" + masterBean.getChannelCode());
        }

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 修改商品预售调整单和明细
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#updateStockPreSaleModifyAndDtl(com.metersbonwe.stock.po.core.StockPreSaleModify,
     *      java.util.List)
     */
    @Override
    public StockPreSaleModifyResultBean updateStockPreSaleModifyAndDtl(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList)
            throws Exception {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();
        int rCount = this.stockPreSaleModifyMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount > 0) {
            int dCount = 0;
            for (StockPreSaleModifyDetail detail : detailBeanList) {
                Integer detailId = detail.getId();
                if (detailId == null || detailId <= 0) { //无id插入
                    detail.setRelationId(id);
                    dCount = dCount + this.stockPreSaleModifyDetailMapper.insertSelective(detail);
                } else { //有id修改
                    dCount = dCount + this.stockPreSaleModifyDetailMapper.updateByPrimaryKeySelective(detail);
                }
            }
            if (dCount != detailBeanList.size()) {
                throw new Exception("商品预售明细保存失败");
            }
        } else {
            throw new Exception("修改商品预售主表失败,返回记录数" + rCount + ",渠道为" + masterBean.getChannelCode());
        }

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 删除商品预售调整单和明细
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#deleteStockPreSale(com.metersbonwe.stock.po.core.StockPreSale)
     */
    @Override
    @Transactional
    public StockPreSaleModifyResultBean deleteStockPreSaleModify(StockPreSaleModify masterBean) {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();

        //删除明细
        StockPreSaleModifyDetailExample example = new StockPreSaleModifyDetailExample();
        example.createCriteria().andRelationIdEqualTo(id);
        this.stockPreSaleModifyDetailMapper.deleteByExample(example);

        //删除主表
        this.stockPreSaleModifyMapper.deleteByPrimaryKey(id);

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    private int IntegerToInt(Integer v) {
        return v == null ? 0 : v;
    }

    /**
     * TODO 检查数据是否有被变更过且设置ID
     * 
     * @param masterBean
     * @param modifiedDetailMap
     * @param resultMap
     * @param updateModifiedList
     *            返回需要变化的预售需求修改明细表集合
     * @param updateResultList
     *            返回需要变化的预售结果表集合
     * @return
     */
    private String stockPreSaleModify_CheckData(boolean isQueryQtyed, StockPreSaleModify masterBean,
            Map<String, StockPreSaleModifiedDetail> modifiedDetailMap, Map<String, StockPreSaleResult> resultMap,
            List<StockPreSaleModifiedDetail> updateModifiedList, List<StockPreSaleResult> updateResultList) {
        Date stime = new Date();

        long relationId = masterBean.getRelationId();
        Map<String, Integer> resultProdMap = new HashMap<String, Integer>();
        //预售中间表集合【预售修改后需求明细表】
        StockPreSaleModifiedDetailExample example = new StockPreSaleModifiedDetailExample();
        example.createCriteria().andRelationIdEqualTo(relationId);
        List<StockPreSaleModifiedDetail> modifiedBeanList = this.stockPreSaleModifiedDetailMapper.selectByExample(example);
        for (StockPreSaleModifiedDetail modifiedDetail : modifiedBeanList) {
            String warehId = modifiedDetail.getWarehId();
            String prod = modifiedDetail.getProdId();
            String wpKey = warehId + ":" + prod;
            String pKey = prod;
            Integer v = modifiedDetail.getPrePrivateStock();

            StockPreSaleModifiedDetail updateModifiedDetail = null;
            if (isQueryQtyed) { //调整数量是针对商品+仓库
                updateModifiedDetail = modifiedDetailMap.get(wpKey);
            } else { //调整时间是针对商品
                updateModifiedDetail = modifiedDetailMap.get(pKey);
            }
            if (updateModifiedDetail != null) {
                if (isQueryQtyed) {
                    v = updateModifiedDetail.getPrePrivateStock();
                    modifiedDetail.setPrePrivateStock(v);
                } else {
                    modifiedDetail.setEndTime(updateModifiedDetail.getEndTime());
                }
                modifiedDetail.setUpdateBy(updateModifiedDetail.getUpdateBy());
                modifiedDetail.setUpdateTime(updateModifiedDetail.getUpdateTime());
                updateModifiedList.add(modifiedDetail);
            }

            if (isQueryQtyed) {
                if (resultProdMap.containsKey(pKey)) {
                    Integer v1 = resultProdMap.get(pKey);
                    resultProdMap.put(pKey, IntegerToInt(v) + IntegerToInt(v1));
                } else {
                    resultProdMap.put(pKey, v);
                }
            }
        }
        stockLog.debug("submit check预售中间表集合【预售修改后需求明细表】数据耗时： " + (new Date().getTime() - stime.getTime()));

        if (isQueryQtyed) {
            if (updateModifiedList.size() != modifiedDetailMap.size()) {
                return "调整数量：预售需求修改后明细表发生过变更,不允许审批";
            }
        } else {
            if (updateModifiedList.size() < modifiedDetailMap.size()) {
                return "调整日期：预售需求修改后明细表发生过变更,不允许审批";
            }
        }

        //预售结果表
        stime = new Date();

        StockPreSaleResultExample resultExample = new StockPreSaleResultExample();
        resultExample.createCriteria().andRelationIdEqualTo(relationId); //根据预售ID查询数据
        List<StockPreSaleResult> resultList = this.stockPreSaleResultMapper.selectByExample(resultExample);
        for (StockPreSaleResult result : resultList) {
            String key = result.getProdId();

            StockPreSaleResult updateResult = resultMap.get(key);
            if (updateResult != null) {
                if (isQueryQtyed) {
                    Integer v = resultProdMap.get(key);
                    if (v != null) {
                        updateResult.setPrePrivateStock(v);
                    }
                }
                updateResult.setId(result.getId());
                updateResultList.add(updateResult);
            }
        }

        stockLog.debug("submit check预售结果表数据耗时： " + (new Date().getTime() - stime.getTime()));
        if (updateResultList.size() != resultMap.size()) {
            return "预售结果表发生过变更,不允许审批";
        }

        return "";
    }

    /**
     * TODO 预售调整调整数量的逻辑处理
     * 
     * @param masterBean
     * @param detailBeanList
     * @param updateModifiedList
     *            返回需要变化的预售需求修改明细表集合
     * @param updateResultList
     *            返回需要变化的预售结果表集合
     * @return
     */
    private String stockPreSaleModify_UpdateQty(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList,
            List<StockPreSaleModifiedDetail> updateModifiedList, List<StockPreSaleResult> updateResultList) {
        String channelCode = masterBean.getChannelCode();
        long relationId = masterBean.getRelationId();
        Calendar c = Calendar.getInstance();
        Date currDate = c.getTime();

        //预售中间表Map
        Map<String, StockPreSaleModifiedDetail> modifiedDetailMap = new HashMap<String, StockPreSaleModifiedDetail>();
        //预售结果表Map
        Map<String, StockPreSaleResult> resultMap = new HashMap<String, StockPreSaleResult>();

        for (StockPreSaleModifyDetail detail : detailBeanList) {
            String warehId = detail.getWarehId();
            String prodId = detail.getProdId();
            String wpKey = warehId + ":" + prodId;
            String pKey = prodId;
            int prePrivateStockModify = detail.getPrePrivateStockModify();

            //创建预售中间表
            StockPreSaleModifiedDetail modifiedDetail = modifiedDetailMap.get(wpKey);
            if (modifiedDetail == null) {
                modifiedDetail = new StockPreSaleModifiedDetail();
                modifiedDetail.setRelationId(relationId);
                modifiedDetail.setWarehId(warehId);
                modifiedDetail.setProdId(prodId);
                modifiedDetail.setPrePrivateStock(prePrivateStockModify);
                modifiedDetail.setUpdateBy(masterBean.getUpdateBy());
                modifiedDetail.setUpdateTime(currDate);

                modifiedDetailMap.put(wpKey, modifiedDetail);
            } else {
                int v = modifiedDetail.getPrePrivateStock();
                modifiedDetail.setPrePrivateStock(v + prePrivateStockModify);
            }

            //创建预售结果表对象
            StockPreSaleResult result = resultMap.get(pKey);
            if (result == null) {
                result = new StockPreSaleResult();
                result.setRelationId(relationId);
                result.setChannelCode(channelCode);
                result.setProdId(prodId);
                result.setPrePrivateStock(prePrivateStockModify);
                result.setIsControling(1); //需要做开始预售操作
                result.setUpdateBy(masterBean.getUpdateBy());
                result.setUpdateTime(currDate);

                resultMap.put(pKey, result);
            } else {
                int v1 = result.getPrePrivateStock();
                result.setPrePrivateStock(v1 + prePrivateStockModify);
            }
        }

        return stockPreSaleModify_CheckData(true, masterBean, modifiedDetailMap, resultMap, updateModifiedList, updateResultList);
    }

    /**
     * TODO 预售调整调整时间的逻辑处理
     * 
     * @param masterBean
     * @param detailBeanList
     * @param updateModifiedList
     *            返回需要变化的预售需求修改明细表集合
     * @param updateResultList
     *            返回需要变化的预售结果表集合
     * @return
     */
    private String stockPreSaleModify_UpdateDate(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList,
            List<StockPreSaleModifiedDetail> updateModifiedList, List<StockPreSaleResult> updateResultList) {
        String channelCode = masterBean.getChannelCode();
        long relationId = masterBean.getRelationId();
        Calendar c = Calendar.getInstance();
        Date currDate = c.getTime();

        //预售中间表Map
        Map<String, StockPreSaleModifiedDetail> modifiedDetailMap = new HashMap<String, StockPreSaleModifiedDetail>();
        //预售结果表Map
        Map<String, StockPreSaleResult> resultMap = new HashMap<String, StockPreSaleResult>();

        for (StockPreSaleModifyDetail detail : detailBeanList) {
            String prodId = detail.getProdId();
            String pKey = prodId;

            if (!modifiedDetailMap.containsKey(pKey)) {
                StockPreSaleModifiedDetail modifiedDetail = new StockPreSaleModifiedDetail();
                modifiedDetail.setRelationId(relationId);
                modifiedDetail.setProdId(prodId);
                modifiedDetail.setStartTime(detail.getStartTime());
                modifiedDetail.setEndTime(detail.getEndTimeModify());
                modifiedDetail.setUpdateBy(masterBean.getUpdateBy());
                modifiedDetail.setUpdateTime(currDate);

                modifiedDetailMap.put(pKey, modifiedDetail);
            }

            if (!resultMap.containsKey(pKey)) { //创建预售结果表对象
                StockPreSaleResult result = new StockPreSaleResult();
                result.setRelationId(relationId);
                result.setChannelCode(channelCode);
                result.setProdId(prodId);
                result.setStartTime(detail.getStartTime());
                result.setEndTime(detail.getEndTimeModify());
                result.setIsControling(1); //需要做开始预售操作
                result.setUpdateBy(masterBean.getUpdateBy());
                result.setUpdateTime(currDate);

                resultMap.put(pKey, result);
            }
        }

        return stockPreSaleModify_CheckData(false, masterBean, modifiedDetailMap, resultMap, updateModifiedList, updateResultList);
    }

    /**
     * TODO 审批商品预售
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#submitFlowStockPreSale(com.metersbonwe.stock.po.core.StockPreSale)
     */
    @Override
    public StockPreSaleModifyResultBean submitFlowStockPreSaleModify(StockPreSaleModify masterBean) {
        StockPreSaleModifyResultBean resultBean = new StockPreSaleModifyResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();

        boolean isUpdateQtyed = false;//修改类型是否是修改数量

        //根据商品预售主表id查询明细
        List<StockPreSaleModifyDetail> detailBeanList = this.getStockPreSaleModifyDetailList(id);
        if (detailBeanList == null || detailBeanList.size() <= 0) {
            resultBean.setMsg("当前商品预售调整单没有明细不允许审批");
            resultBean.setSucess(false);
            return resultBean;
        }

        isUpdateQtyed = CONST_MODIFY_TYPE_01.equals(masterBean.getModifyType()); //获取修改类型

        List<StockPreSaleModifiedDetail> updateModifiedList = new ArrayList<StockPreSaleModifiedDetail>();
        List<StockPreSaleResult> updateResultList = new ArrayList<StockPreSaleResult>();
        String msg = "";
        if (isUpdateQtyed) { //调整数量
            msg = stockPreSaleModify_UpdateQty(masterBean, detailBeanList, updateModifiedList, updateResultList);
        } else { //调整时间
            msg = stockPreSaleModify_UpdateDate(masterBean, detailBeanList, updateModifiedList, updateResultList);
        }
        if (msg != null && !("".equals(msg))) {
            resultBean.setMsg(msg);
            resultBean.setSucess(false);
            return resultBean;
        }

        masterBean.setExamineStatus("1"); //已审核

        StockPreSaleReserved preSaleReserved = new StockPreSaleReserved();
        preSaleReserved.setRelationId(masterBean.getId());
        Short optionType = (short) (isUpdateQtyed ? 2 : 3); //1:预售需求增加 2:预售调整数量 3:预售调整时间
        preSaleReserved.setOptionType(optionType);
        preSaleReserved.setCreateTime(new Date());

        //保存数据操作
        boolean isSucessed;
        try {
            Date stime = new Date();
            isSucessed = saveSubmitFlowStockPreSaleModify(masterBean, updateModifiedList, updateResultList, preSaleReserved);
            stockLog.debug("submit保存数据耗时： " + (new Date().getTime() - stime.getTime()));
            if (!isSucessed) {
                resultBean.setMsg("审批操作失败");
                resultBean.setSucess(false);
                return resultBean;
            }
        } catch (Exception ex) {
            resultBean.setMsg(ex.getMessage());
            resultBean.setSucess(false);
            return resultBean;
        }

        //调用分配系统的预留独占接口，把预售参数实体对象传过去。【要求异步】

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    @Transactional
    private boolean saveSubmitFlowStockPreSaleModify(StockPreSaleModify masterBean, List<StockPreSaleModifiedDetail> modifiedBeanList,
            List<StockPreSaleResult> resultList, StockPreSaleReserved preSaleReserved) throws Exception {
        int rCount = this.stockPreSaleModifyMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount > 0) {

            //插入到预售转预留中间表中
            this.stockPreSaleReservedMapper.insertSelective(preSaleReserved);

            int dCount = 0;
            //修改预售中间表
            for (StockPreSaleModifiedDetail modifiedBean : modifiedBeanList) {
                dCount = dCount + this.stockPreSaleModifiedDetailMapper.updateByPrimaryKeySelective(modifiedBean);
            }
            if (dCount != modifiedBeanList.size()) {
                throw new Exception("数据发生过变更,更新商品预售需求修改明细表失败");
            }

            //修改预售结果表
            dCount = 0;
            for (StockPreSaleResult result : resultList) {
                dCount = this.stockPreSaleResultMapper.updateByPrimaryKeySelective(result);
                if (dCount <= 0) {
                    throw new Exception("修改商品预售结果表失败,商品预售结果表数据发生过变更[可能预售已关闭],参数为:id" + String.valueOf(result.getId()) + ",渠道编码"
                            + result.getChannelCode() + ",商品编码" + result.getProdId());
                }
            }
        } else {
            throw new Exception("数据发生过变更,更新商品预售主表失败");
        }
        return true;
    }

    /**
     * TODO 根据预售主表id查询预售主表信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSale(long)
     */
    @Override
    public StockPreSaleModify getStockPreSaleModify(long id) {
        StockPreSaleModify stockPreSaleModify = this.stockPreSaleModifyMapper.selectByPrimaryKey(id);
        return stockPreSaleModify;
    }

    /**
     * TODO 根据预售主表id查询预售明细信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSaleDetailList(long)
     */
    @Override
    public List<StockPreSaleModifyDetail> getStockPreSaleModifyDetailList(long relationId) {
        StockPreSaleModifyDetailExample example = new StockPreSaleModifyDetailExample();
        example.createCriteria().andRelationIdEqualTo(relationId);
        List<StockPreSaleModifyDetail> detailBeanList = this.stockPreSaleModifyDetailMapper.selectByExample(example);
        return detailBeanList;
    }

    /**
     * TODO 查询所有预售主表信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSale(long)
     */
    @Override
    public List<StockPreSaleModify> getStockPreSaleModifyList() {
        List<StockPreSaleModify> stockPreSaleModifyList = this.stockPreSaleModifyMapper.selectByExample(null);
        return stockPreSaleModifyList;
    }

    /**
     * TODO 根据渠道编码、调整类型等条件来查询所有预售主表信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#selectPreSaleModifyList(java.util.Map)
     */
    @Override
    public List<StockPreSaleModify> selectPreSaleModifyList(Map<String, List<String>> paraListMap) {
        StockPreSaleModifyExample stockPreSaleModifyExample = new StockPreSaleModifyExample();
        StockPreSaleModifyExample.Criteria criteria = stockPreSaleModifyExample.createCriteria();
        List<String> ids = paraListMap.get("id");
        if (CollectionUtils.isNotEmpty(ids)) {
            List<Long> idList = new ArrayList<Long>();
            for (String v : ids) {
                Long id = Long.parseLong(v);
                idList.add(id);
            }
            criteria.andIdIn(idList);
        }
        List<String> relationIds = paraListMap.get("relationId");
        if (CollectionUtils.isNotEmpty(relationIds)) {
            List<Long> relationIdList = new ArrayList<Long>();
            for (String relationIdString : relationIds) {
                Long relationId = Long.parseLong(relationIdString);
                relationIdList.add(relationId);
            }
            criteria.andRelationIdIn(relationIdList);
        }
        List<String> names = paraListMap.get("name");
        if (CollectionUtils.isNotEmpty(names)) {
            criteria.andNameIn(names);
        }
        List<String> channelCodes = paraListMap.get("channelCode");
        if (CollectionUtils.isNotEmpty(channelCodes)) {
            criteria.andChannelCodeIn(channelCodes);
        }
        List<String> modifyTypes = paraListMap.get("modifyType");
        if (CollectionUtils.isNotEmpty(modifyTypes)) {
            List<String> modifyTypeList = new ArrayList<String>();
            for (String modifyType : modifyTypes) {
                if ("调整预售数量".equals(modifyType)) {
                    modifyType = "01";
                } else if ("调整结束日期".equals(modifyType)) {
                    modifyType = "02";
                }
                modifyTypeList.add(modifyType);
            }
            criteria.andModifyTypeIn(modifyTypeList);
        }

        List<String> examineStatuss = paraListMap.get("examineStatus");
        if (CollectionUtils.isNotEmpty(examineStatuss)) {
            List<String> examineStatusList = new ArrayList<String>();
            for (String examineStatus : examineStatuss) {
                if ("未审批".equals(examineStatus)) {
                    examineStatus = "0";
                } else if ("已审批".equals(examineStatus)) {
                    examineStatus = "1";
                } else if ("已撤销".equals(examineStatus)) {
                    examineStatus = "2";
                }
                examineStatusList.add(examineStatus);
            }
            criteria.andExamineStatusIn(examineStatusList);
        }

        List<String> createTimeList = paraListMap.get("createTime");
        if (createTimeList != null && createTimeList.size() > 0) {
            List<String> endCreateTimeList = paraListMap.get("endcreateTime");

            String createTime = createTimeList.get(0);
            String endCreateTime = endCreateTimeList.get(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date startDate = sdf.parse(createTime);
                Date endDate = sdf.parse(endCreateTime);
                criteria.andCreateTimeBetween(startDate, endDate);
            } catch (Exception ex) {
                //
            }
        }
        stockPreSaleModifyExample.setOrderByClause("id desc");
        return stockPreSaleModifyMapper.selectByExample(stockPreSaleModifyExample);
    }

    /**
     * TODO 根据预售调整单id、商品编码、仓库编码、调整结束日期等条件来查询所有预售调整明细信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#selectStockPreSaleModifyDetailList(java.util.Map)
     */
    @Override
    public List<StockPreSaleModifyDetail> selectStockPreSaleModifyDetailList(Map<String, List<String>> paraListMap) {
        StockPreSaleModifyDetailExample stockPreSaleModifyDetailExample = new StockPreSaleModifyDetailExample();
        StockPreSaleModifyDetailExample.Criteria criteria = stockPreSaleModifyDetailExample.createCriteria();
        List<String> relationIds = paraListMap.get("relationId");
        if (CollectionUtils.isNotEmpty(relationIds)) {
            String relationIdStr = relationIds.get(0);
            long relationId = Long.parseLong(relationIdStr);
            criteria.andRelationIdEqualTo(relationId);
        }
        List<String> prodIds = paraListMap.get("prodId");
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdIn(prodIds);
        }
        List<String> reservedStatuss = paraListMap.get("reservedStatus");
        if (CollectionUtils.isNotEmpty(reservedStatuss)) {
            List<Integer> reservedStatusList = new ArrayList<Integer>();
            int reservedStatus_i = 0;
            for (String reservedStatus : reservedStatuss) {
                if ("未开始".equals(reservedStatus)) {
                    reservedStatus_i = 0;
                } else if ("执行成功".equals(reservedStatus)) {
                    reservedStatus_i = 1;
                } else if ("执行失败".equals(reservedStatus)) {
                    reservedStatus_i = 2;
                }
                reservedStatusList.add(reservedStatus_i);
            }
            criteria.andReservedStatusIn(reservedStatusList);
        }
        List<String> createTimeList = paraListMap.get("endTimeModify");
        if (createTimeList != null && createTimeList.size() > 0) {
            List<String> endCreateTimeList = paraListMap.get("endendTimeModify");

            String createTime = createTimeList.get(0);
            String endCreateTime = endCreateTimeList.get(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date startDate = sdf.parse(createTime);
                Date endDate = sdf.parse(endCreateTime);
                criteria.andEndTimeModifyBetween(startDate, endDate);
            } catch (Exception ex) {
                //
            }
        }
        stockPreSaleModifyDetailExample.setOrderByClause("id desc");
        return stockPreSaleModifyDetailMapper.selectByExample(stockPreSaleModifyDetailExample);
    }

    /**
     * TODO 根据预售单id、商品编码、仓库编码等条件来查询所有预售修改后明细信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#selectStockPreSaleModifiedDetailList(java.util.Map)
     */
    @Override
    public List<StockPreSaleModifiedDetail> selectStockPreSaleModifiedDetailList(Map<String, List<String>> paraListMap) {
        StockPreSaleModifiedDetailExample stockPreSaleModifiedDetailExample = new StockPreSaleModifiedDetailExample();
        StockPreSaleModifiedDetailExample.Criteria criteria = stockPreSaleModifiedDetailExample.createCriteria();
        List<String> relationIds = paraListMap.get("relationId");
        if (CollectionUtils.isNotEmpty(relationIds)) {
            String relationIdStr = relationIds.get(0);
            long relationId = Long.parseLong(relationIdStr);
            criteria.andRelationIdEqualTo(relationId);
        }
        List<String> prodIds = paraListMap.get("prodId");
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdIn(prodIds);
        }

        List<String> warehIds = paraListMap.get("warehId");
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdIn(warehIds);
        }

        return stockPreSaleModifiedDetailMapper.selectByExample(stockPreSaleModifiedDetailExample);
    }

    private String checkImportData(List<StockPreSaleModifyDetailExcelBean> excelBeanList, StockPreSaleModify stockPreSaleModify,
            boolean ismodifyQtyed, List<StockPreSaleModifyDetail> preSaleModifyDetailInsertList,
            List<StockPreSaleModifyDetail> preSaleModifyDetailUpdateList) {
        String errCode = "";
        boolean isErrored = false;
        StringBuilder sbBuilder = new StringBuilder();

        //检查是否重复
        Map<String, Integer> excelBeanMap = new HashMap<String, Integer>();
        for (StockPreSaleModifyDetailExcelBean excelBean : excelBeanList) {
            String key = "";
            if (ismodifyQtyed) { //调整数量
                key = excelBean.getWarehId() + ":" + excelBean.getProdId();
            } else { //调整日期
                key = excelBean.getProdId();
            }
            Integer count = excelBeanMap.get(key);
            if (count == null || count <= 0) {
                excelBeanMap.put(key, 1);
            } else {
                //excelBeanMap.put(key, count + 1);
                sbBuilder.append(key + "重复,");
                isErrored = true;
                //                errCode = ExceptionCode.DUPLICATION_RECODE;
                //                return errCode;
            }
        }
        if (isErrored) { //有重复
            errCode = sbBuilder.toString();
            return errCode;
        }

        long relationId = stockPreSaleModify.getRelationId(); //预售单id
        //预售中间表集合【预售修改后需求明细表】
        StockPreSaleModifiedDetailExample example = new StockPreSaleModifiedDetailExample();
        example.createCriteria().andRelationIdEqualTo(relationId);
        List<StockPreSaleModifiedDetail> modifiedBeanList = this.stockPreSaleModifiedDetailMapper.selectByExample(example);
        Map<String, StockPreSaleModifiedDetail> modifiedBeanMap = new HashMap<String, StockPreSaleModifiedDetail>();
        for (StockPreSaleModifiedDetail modifiedBean : modifiedBeanList) {
            String key = "";
            if (ismodifyQtyed) { //调整数量
                key = modifiedBean.getWarehId() + ":" + modifiedBean.getProdId();
            } else { //调整日期
                key = modifiedBean.getProdId();
            }
            if (!modifiedBeanMap.containsKey(key)) {
                modifiedBeanMap.put(key, modifiedBean);
            }
        }

        //查询出当前调整单的预售调整单明细
        List<StockPreSaleModifyDetail> preSaleModifyDtlList = this.getStockPreSaleModifyDetailList(stockPreSaleModify.getId());
        Map<String, StockPreSaleModifyDetail> preSaleModifyDtlMap = new HashMap<String, StockPreSaleModifyDetail>();
        for (StockPreSaleModifyDetail preSaleModifyDtl : preSaleModifyDtlList) {
            String key = "";
            if (ismodifyQtyed) { //调整数量
                key = preSaleModifyDtl.getWarehId() + ":" + preSaleModifyDtl.getProdId();
            } else { //调整日期
                key = preSaleModifyDtl.getProdId();
            }
            if (!preSaleModifyDtlMap.containsKey(key)) {
                preSaleModifyDtlMap.put(key, preSaleModifyDtl);
            }
        }

        isErrored = false;
        if (sbBuilder.length() > 0) {
            sbBuilder.delete(0, sbBuilder.length());
        }
        //检查是否在预售变更源单中并且创建对象放入预售调整单明细集合
        for (StockPreSaleModifyDetailExcelBean excelBean : excelBeanList) {
            String key = "";
            if (ismodifyQtyed) { //调整数量
                key = excelBean.getWarehId() + ":" + excelBean.getProdId();
            } else { //调整日期
                key = excelBean.getProdId();
            }
            StockPreSaleModifiedDetail modifiedBean = modifiedBeanMap.get(key);
            if (modifiedBean == null) { //预售单中不存在的数据
                isErrored = true;
                sbBuilder.append(key + "数据在预售单中不存在,");
                continue;
                //return ExceptionCode.CHECK_NOTIN_PRESALE_RECODE;
            }

            StockPreSaleModifyDetail preSaleModifyDetail = null;
            if (preSaleModifyDtlMap.containsKey(key)) { //在当前预售调整单明细数据记录中已经存在，数量累加
                preSaleModifyDetail = preSaleModifyDtlMap.get(key);
                if (ismodifyQtyed) { //调整数量
                    preSaleModifyDetail.setPrePrivateStock(modifiedBean.getPrePrivateStock());
                    preSaleModifyDetail.setPrePrivateStockModify(preSaleModifyDetail.getPrePrivateStockModify()
                            + excelBean.getPrePrivateStockModify());
                } else { //调整日期
                    preSaleModifyDetail.setEndTimeModify(excelBean.getEndTimeModify());
                }
                preSaleModifyDetailUpdateList.add(preSaleModifyDetail);
            } else {
                preSaleModifyDetail = new StockPreSaleModifyDetail();
                preSaleModifyDetail.setRelationId(stockPreSaleModify.getId());
                preSaleModifyDetail.setProdId(excelBean.getProdId());
                preSaleModifyDetail.setStartTime(modifiedBean.getStartTime());
                preSaleModifyDetail.setEndTime(modifiedBean.getEndTime());
                if (ismodifyQtyed) { //调整数量
                    preSaleModifyDetail.setWarehId(excelBean.getWarehId());
                    preSaleModifyDetail.setPrePrivateStock(modifiedBean.getPrePrivateStock());
                    preSaleModifyDetail.setPrePrivateStockModify(excelBean.getPrePrivateStockModify());
                } else { //调整日期
                    preSaleModifyDetail.setEndTimeModify(excelBean.getEndTimeModify());
                }

                preSaleModifyDetailInsertList.add(preSaleModifyDetail);
            }
            preSaleModifyDetail.setUpdateBy("0001");
            preSaleModifyDetail.setUpdateTime(new Date());
        }
        if (isErrored) { //预售单中不存在的数据
            errCode = sbBuilder.toString();
            return errCode;
        }

        return "";
    }

    /**
     * TODO 上传数据
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#uploadPreSaleModifyDetail(java.util.List, long)
     */
    @Override
    public String uploadPreSaleModifyDetail(StockPreSaleModify stockPreSaleModify, List<String> fileStrs) {
        String errCode = "";
        if (fileStrs == null || fileStrs.size() == 0) {
            errCode = ExceptionCode.FILE_IS_NULL;
            return errCode;
        }

        //组装导入数据
        Date stime = new Date();
        List<StockPreSaleModifyDetailExcelBean> excelBeanList = ImportExportDataUtil.getImportData(fileStrs, StockPreSaleModifyDetailExcelBean.class);
        stockLog.debug("import组装导入数据耗时： " + (new Date().getTime() - stime.getTime()));
        if (excelBeanList == null || excelBeanList.size() <= 0) {
            errCode = ExceptionCode.FILE_IS_NULL;
            return errCode;
        }

        String modifyType = stockPreSaleModify.getModifyType();

        //检查是否在预售单中并且创建预售调整单明细集合
        List<StockPreSaleModifyDetail> preSaleModifyDetailInsertList = new ArrayList<StockPreSaleModifyDetail>();
        List<StockPreSaleModifyDetail> preSaleModifyDetailUpdateList = new ArrayList<StockPreSaleModifyDetail>();

        stime = new Date();
        errCode = checkImportData(
                excelBeanList,
                stockPreSaleModify,
                "01".equals(modifyType),
                preSaleModifyDetailInsertList,
                preSaleModifyDetailUpdateList);
        stockLog.debug("import检查导入数据耗时： " + (new Date().getTime() - stime.getTime()));

        if (!("".equals(errCode))) {
            return errCode;
        }

        //保存数据
        stime = new Date();
        errCode = saveImportStockPreSaleModifyDetailData(preSaleModifyDetailInsertList, preSaleModifyDetailUpdateList);
        stockLog.debug("import保存导入数据耗时： " + (new Date().getTime() - stime.getTime()));

        return errCode;
    }

    /**
     * TODO 保存导入的明细数据
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleModifyService#saveImportStockPreSaleModifyDetailData(java.util.List, java.util.List)
     */
    @Override
    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    public String saveImportStockPreSaleModifyDetailData(List<StockPreSaleModifyDetail> preSaleModifyDetailInsertList,
            List<StockPreSaleModifyDetail> preSaleModifyDetailUpdateList) {
        if (preSaleModifyDetailInsertList != null && preSaleModifyDetailInsertList.size() > 0) {
            for (StockPreSaleModifyDetail detail : preSaleModifyDetailInsertList) {
                this.stockPreSaleModifyDetailMapper.insert(detail);
            }
        }
        if (preSaleModifyDetailUpdateList != null && preSaleModifyDetailUpdateList.size() > 0) {
            for (StockPreSaleModifyDetail detail : preSaleModifyDetailUpdateList) {
                this.stockPreSaleModifyDetailMapper.updateByPrimaryKeySelective(detail);
            }
        }
        return "";
    }
}
