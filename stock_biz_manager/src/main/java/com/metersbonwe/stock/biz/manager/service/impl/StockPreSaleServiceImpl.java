package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.ExceptionConstants.ExceptionCode;
import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.manager.service.StockPreSaleService;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.dal.auto.core.mapper.*;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleResultDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.*;
import com.metersbonwe.stock.pojo.StockPreSaleResultBean;
import com.metersbonwe.stock.utils.CommonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service public class StockPreSaleServiceImpl implements StockPreSaleService {
    private static StockLog stockLog = StockLogFactory.getLogger(StockPreSaleServiceImpl.class);

    @Autowired private StockPreSaleMapper stockPreSaleMapper;

    @Autowired private StockPreSaleDetailMapper stockPreSaleDetailMapper;

    @Autowired private StockPreSaleModifiedDetailMapper stockPreSaleModifiedDetailMapper;

    @Autowired private StockPreSaleResultMapper stockPreSaleResultMapper;

    @Autowired private StockPreSaleReservedMapper stockPreSaleReservedMapper;

    @Autowired private StockPreSaleResultDefineMapper stockPreSaleResultDefineMapper;

    @Resource ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * TODO 保存商品预售
     *
     * @throws Exception
     */
    @Override @Transactional public StockPreSaleResultBean insertStockPreSale(StockPreSale masterBean, List<StockPreSaleDetail> detailBeanList)
            throws Exception {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);

        long id = System.currentTimeMillis();
        masterBean.setId(id);

        int rCount = this.stockPreSaleMapper.insertSelective(masterBean);
        if (rCount > 0) {
            int dCount = 0;
            for (StockPreSaleDetail detail : detailBeanList) {
                detail.setId(null);
                detail.setRelationId(id);
                dCount = dCount + this.stockPreSaleDetailMapper.insertSelective(detail);
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
     * TODO 修改商品预售
     *
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#updateStockPreSale(com.metersbonwe.stock.po.core.StockPreSale,
     *      java.util.List)
     */
    @Override
    @Transactional
    public StockPreSaleResultBean updateStockPreSale(StockPreSale masterBean, List<StockPreSaleDetail> detailBeanList) throws Exception {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();
        int rCount = this.stockPreSaleMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount > 0) {
            int dCount = 0;
            for (StockPreSaleDetail detail : detailBeanList) {
                Integer detailId = detail.getId();
                if (detailId == null || detailId <= 0) { //无id插入
                    detail.setRelationId(id);
                    dCount = dCount + this.stockPreSaleDetailMapper.insertSelective(detail);
                } else { //有id修改
                    dCount = dCount + this.stockPreSaleDetailMapper.updateByPrimaryKeySelective(detail);
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
     * TODO 删除商品预售
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#deleteStockPreSale(com.metersbonwe.stock.po.core.StockPreSale)
     */
    @Override
    @Transactional
    public StockPreSaleResultBean deleteStockPreSale(StockPreSale masterBean) {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();

        //删除明细
        StockPreSaleDetailExample example = new StockPreSaleDetailExample();
        example.createCriteria().andRelationIdEqualTo(id);
        this.stockPreSaleDetailMapper.deleteByExample(example);

        //删除主表
        this.stockPreSaleMapper.deleteByPrimaryKey(id);

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * 审批商品预售
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#submitFlowStockPreSale(com.metersbonwe.stock.po.core.StockPreSale)
     */
    @Override
    public StockPreSaleResultBean submitFlowStockPreSale(StockPreSale masterBean) {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);

        long id = masterBean.getId();

        //根据商品预售主表id查询明细
        List<StockPreSaleDetail> detailBeanList = this.getStockPreSaleDetailList(id);

        Calendar c = Calendar.getInstance();
        Date currDate = c.getTime();

        //预售中间表集合【预售修改后需求明细表】
        List<StockPreSaleModifiedDetail> modifiedBeanList = new ArrayList<StockPreSaleModifiedDetail>();
        //预售结果表集合
        List<StockPreSaleResult> resultList = new ArrayList<StockPreSaleResult>();
        Map<String, StockPreSaleResult> resultMap = new HashMap<String, StockPreSaleResult>();
        for (StockPreSaleDetail detail : detailBeanList) {
            String key = detail.getProdId();
            //创建预售中间表对象
            StockPreSaleModifiedDetail modifiedBean = new StockPreSaleModifiedDetail();
            modifiedBean.setRelationId(id);
            modifiedBean.setWarehId(detail.getWarehId());
            modifiedBean.setProdId(detail.getProdId());
            modifiedBean.setPrePrivateStock(detail.getPrePrivateStock());
            modifiedBean.setStartTime(detail.getStartTime());
            modifiedBean.setEndTime(detail.getEndTime());
            modifiedBean.setUpdateBy(masterBean.getUpdateBy());
            modifiedBean.setUpdateTime(c.getTime());
            modifiedBeanList.add(modifiedBean);

            //创建预售结果表对象
            StockPreSaleResult result = resultMap.get(key);
            if (result == null) {
                result = new StockPreSaleResult();
                result.setRelationId(id);
                result.setChannelCode(masterBean.getChannelCode());
                result.setProdId(detail.getProdId());
                result.setPrePrivateStock(detail.getPrePrivateStock());
                result.setStartTime(detail.getStartTime());
                result.setEndTime(detail.getEndTime());
                result.setIsControling(1); //需要做开始预售操作
                result.setUpdateBy(masterBean.getUpdateBy());
                result.setUpdateTime(currDate);

                resultMap.put(key, result);

                resultList.add(result);
            } else {
                int v = result.getPrePrivateStock();
                int v1 = detail.getPrePrivateStock();
                result.setPrePrivateStock(v + v1);
            }
        }

        masterBean.setExamineStatus("1"); //已审核

        StockPreSaleReserved preSaleReserved = new StockPreSaleReserved();
        preSaleReserved.setRelationId(masterBean.getId());
        Short optionType = 1; //1:预售需求增加 2:预售调整数量 3:预售调整时间
        preSaleReserved.setOptionType(optionType);
        preSaleReserved.setCreateTime(new Date());

        //保存数据操作
        boolean isSucessed;
        try {
            isSucessed = saveSubmitFlowStockPreSale(masterBean, modifiedBeanList, resultList, preSaleReserved);
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

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 撤销商品预售
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#cancelFlowStockPreSale(com.metersbonwe.stock.po.core.StockPreSale)
     */
    @Override
    public StockPreSaleResultBean cancelFlowStockPreSale(StockPreSale masterBean) {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);
        boolean isChecked = "1".equals(masterBean.getExamineStatus());

        masterBean.setExamineStatus("2"); //已撤销
        StockPreSaleReserved preSaleReserved = null; //需释放预留的中间表
        //List<StockPreSaleResult> resultList = null; //预售结果表集合
        if (isChecked) { //已经审批
            //判断有没有预售单数据已经开启，如果有数据已经开启就抛异常
            int count = stockPreSaleResultDefineMapper.selectStockPreSaleResultCountByPreSaleId(masterBean.getId());
            if (count > 0) {
                resultBean.setMsg("当前预售单" + masterBean.getId() + "已经有数据已经开启预售,不允许撤单");
                resultBean.setSucess(false);
                return resultBean;
            }

            //            //计算预售结果表
            //            //根据商品预售主表id查询明细
            //            List<StockPreSaleDetail> detailBeanList = this.getStockPreSaleDetailList(masterBean.getId());
            //            //预售结果表集合
            //            resultList = new ArrayList<StockPreSaleResult>();
            //            Map<String, StockPreSaleResult> resultMap = new HashMap<String, StockPreSaleResult>();
            //            for (StockPreSaleDetail detail : detailBeanList) {
            //                String key = detail.getProdId();
            //                //创建预售结果表对象
            //                StockPreSaleResult result = resultMap.get(key);
            //                if (result == null) {
            //                    result = new StockPreSaleResult();
            //                    result.setRelationId(masterBean.getId());
            //                    result.setChannelCode(masterBean.getChannelCode());
            //                    result.setProdId(detail.getProdId());
            //                    result.setIsControling(1);
            //
            //                    resultMap.put(key, result);
            //
            //                    resultList.add(result);
            //                }
            //            }

            //写入数据到需释放预留的中间表
            preSaleReserved = new StockPreSaleReserved();
            preSaleReserved.setRelationId(masterBean.getId());
            Short optionType = 4; //1:预售需求增加 2:预售调整数量 3:预售调整时间 4:预售需求撤销
            preSaleReserved.setOptionType(optionType);
            preSaleReserved.setCreateTime(new Date());
        }

        //撤销保存数据操作
        boolean isSucessed;
        try {
            isSucessed = saveCancelFlowStockPreSale(masterBean, preSaleReserved);
            if (!isSucessed) {
                resultBean.setMsg("撤单操作失败");
                resultBean.setSucess(false);
                return resultBean;
            }
        } catch (Exception ex) {
            resultBean.setMsg(ex.getMessage());
            resultBean.setSucess(false);
            return resultBean;
        }
        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);
        return resultBean;
    }

    @Transactional
    private boolean saveSubmitFlowStockPreSale(StockPreSale masterBean, List<StockPreSaleModifiedDetail> modifiedBeanList,
            List<StockPreSaleResult> resultList, StockPreSaleReserved preSaleReserved) throws Exception {
        int rCount = this.stockPreSaleMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount > 0) {
            //插入到预售转预留中间表中
            this.stockPreSaleReservedMapper.insertSelective(preSaleReserved);

            //保存预售中间表
            for (StockPreSaleModifiedDetail modifiedBean : modifiedBeanList) {
                this.stockPreSaleModifiedDetailMapper.insertSelective(modifiedBean);
            }

            //保存预售结果表
            for (StockPreSaleResult result : resultList) {
                this.stockPreSaleResultMapper.insertSelective(result);
            }
        } else {
            throw new Exception("更新商品预售主表失败");
        }
        return true;
    }

    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private boolean saveCancelFlowStockPreSale(StockPreSale masterBean, StockPreSaleReserved preSaleReserved) throws Exception {
        int rCount = this.stockPreSaleMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount > 0) {
            if (preSaleReserved != null) { //表示已经审批过
                //删除预售结果表
                StockPreSaleResultExample example = new StockPreSaleResultExample();
                StockPreSaleResultExample.Criteria criteria = example.createCriteria();
                criteria.andRelationIdEqualTo(masterBean.getId());
                //撤单删除整个预售单的预售结果表数据
                rCount = this.stockPreSaleResultMapper.deleteByExample(example);
                if (rCount <= 0) {
                    throw new Exception("删除商品预售结果表失败,预售结果表数据发生过变更[可能预售已关闭],参数为:渠道编码" + masterBean.getChannelCode() + ",预售单编码"
                            + String.valueOf(masterBean.getId()));
                }
                //插入到预售转预留中间表中
                this.stockPreSaleReservedMapper.insertSelective(preSaleReserved);
            }
        } else {
            throw new Exception("更新商品预售主表失败");
        }
        return true;
    }

    @Override
    public StockPreSaleResultBean updateStockPreSale(StockPreSale masterBean) throws Exception {
        StockPreSaleResultBean resultBean = new StockPreSaleResultBean();
        resultBean.setSucess(false);

        int rCount = this.stockPreSaleMapper.updateByPrimaryKeySelective(masterBean);
        if (rCount <= 0) {
            throw new Exception("修改商品预售主表失败,返回记录数" + rCount + ",渠道为" + masterBean.getChannelCode());
        }

        resultBean.setMasterBean(masterBean);
        resultBean.setSucess(true);

        return resultBean;
    }

    /**
     * TODO 根据预售主表id查询预售主表信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSale(long)
     */
    @Override
    public StockPreSale getStockPreSale(long id) {
        StockPreSale stockPreSale = this.stockPreSaleMapper.selectByPrimaryKey(id);
        return stockPreSale;
    }

    /**
     * TODO 根据预售主表id查询预售明细信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSaleDetailList(long)
     */
    @Override
    public List<StockPreSaleDetail> getStockPreSaleDetailList(long relationId) {
        StockPreSaleDetailExample example = new StockPreSaleDetailExample();
        example.createCriteria().andRelationIdEqualTo(relationId);
        List<StockPreSaleDetail> detailBeanList = this.stockPreSaleDetailMapper.selectByExample(example);
        return detailBeanList;
    }

    /**
     * TODO 查询所有预售主表信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockPreSaleService#getStockPreSale(long)
     */
    @Override
    public List<StockPreSale> getStockPreSaleList() {
        List<StockPreSale> stockPreSaleList = this.stockPreSaleMapper.selectByExample(null);
        return stockPreSaleList;
    }

    @Override
    public List<StockPreSale> selectPreSale(Map<String, List<String>> paraListMap) {
        StockPreSaleExample stockPreSaleExample = new StockPreSaleExample();
        StockPreSaleExample.Criteria criteria = stockPreSaleExample.createCriteria();
        List<String> channelCodes = paraListMap.get("channelCode");
        List<String> idsStr = paraListMap.get("id");
        List<String> names = paraListMap.get("name");
        List<String> status = paraListMap.get("status");
        if (CollectionUtils.isNotEmpty(idsStr)) {
            List<Long> idsLong = new ArrayList<>();
            for (String id : idsStr) {
                idsLong.add(Long.parseLong(id));
            }
            if (CollectionUtils.isNotEmpty(idsLong)) {
                criteria.andIdIn(idsLong);
            }
        }
        if (CollectionUtils.isNotEmpty(channelCodes)) {
            criteria.andChannelCodeIn(channelCodes);
        }
        if (CollectionUtils.isNotEmpty(names)) {
            criteria.andNameIn(names);
        }
        if (CollectionUtils.isNotEmpty(status)) {
            criteria.andExamineStatusIn(status);
        }
        stockPreSaleExample.setOrderByClause("id desc");
        return stockPreSaleMapper.selectByExample(stockPreSaleExample);
    }

    @Override
    public List<StockPreSaleDetail> selectPreSaleDetail(Map<String, List<String>> paraListMap) {
        StockPreSaleDetailExample stockPreSaleDetailExample = new StockPreSaleDetailExample();
        StockPreSaleDetailExample.Criteria criteria = stockPreSaleDetailExample.createCriteria();
        List<String> ids = paraListMap.get("relationId");
        List<String> prodIds = paraListMap.get("prodId");
        List<String> warehIds = paraListMap.get("warehId");
        if (CollectionUtils.isNotEmpty(ids)) {
            criteria.andRelationIdEqualTo(Long.parseLong(ids.get(0)));
        }
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdEqualTo(prodIds.get(0));
        }
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdEqualTo(warehIds.get(0));
        }
        stockPreSaleDetailExample.setOrderByClause("id desc");
        return stockPreSaleDetailMapper.selectByExample(stockPreSaleDetailExample);
    }

    @Override
    public long addPreSale(StockPreSale vo) {
        return stockPreSaleMapper.insert(vo);
    }

    @Override
    @Transactional
    public int addPreSaleDetail(Map<String, String> paraMap) throws Exception {
        StockPreSaleDetail stockPreSaleDetail = new StockPreSaleDetail();
        BeanUtils.populate(stockPreSaleDetail, paraMap);
        stockPreSaleDetail.setUpdateTime(new Date());
        stockPreSaleDetail.setUpdateBy("从Session里面获取");
        String errCode = addPreSaleDetailCheck(stockPreSaleDetail, paraMap);
        if (errCode.length() > 0) {
            throw new Exception(errCode);
        }
        updtExistRecord(stockPreSaleDetail, paraMap);
        return stockPreSaleDetailMapper.insert(stockPreSaleDetail);
    }

    private String addPreSaleDetailCheck(StockPreSaleDetail stockPreSaleDetail, Map<String, String> paramMap) throws Exception {
        String errCode = "";
        Map<String, List<String>> paraListMap = assembleSelectListParam(paramMap);
        List<StockPreSaleDetail> stockPreSaleDetails = selectPreSaleDetail(paraListMap);
        //1、相同的预售单下面已经存在相同的prodId、warehId
        if (stockPreSaleDetails.size() > 0) {
            errCode = ExceptionCode.DUPLICATION_ERROR_CODE;
            return errCode;
        }
        //2、相同预售渠道下，同样的sku预售时间不能重叠
        long relationId = Long.parseLong(paraListMap.get("relationId").get(0));
        StockPreSale stockPreSale = getStockPreSale(relationId);
        String preChannel = stockPreSale.getChannelCode();
        Map<String, List<String>> getPreSaleMap = new HashMap<>();
        List<String> channelList = new ArrayList<>();
        List<String> statusList = new ArrayList<>();
        channelList.add(preChannel);
        //找出当前有有效的预售单号
        statusList.add("0");
        statusList.add("1");
        getPreSaleMap.put("channelCode", channelList);
        getPreSaleMap.put("status", statusList);
        List<StockPreSale> stockPreSales = selectPreSale(getPreSaleMap);
        //同一渠道下所有的预售明细记录
        List<StockPreSaleDetail> stockPreSaleDetaiList = new ArrayList<>();
        for (StockPreSale stockPreSaleTemp : stockPreSales) {
            //忽略本预售单已经添加的sku
            if (Objects.equals(stockPreSaleTemp.getId(), stockPreSaleDetail.getRelationId())) {
                continue;
            }
            long relationIdTmp = stockPreSaleTemp.getId();
            Map<String, List<String>> getSaleDetailParams = new HashMap<>();
            List<String> prodIds = new ArrayList<>();
            List<String> relationIds = new ArrayList<>();
            relationIds.add(String.valueOf(relationIdTmp));
            prodIds.add(stockPreSaleDetail.getProdId());
            getSaleDetailParams.put("relationId", relationIds);
            getSaleDetailParams.put("prodId", prodIds);
            List<StockPreSaleDetail> stockPreSaleDetail1 = selectPreSaleDetail(getSaleDetailParams);
            if (stockPreSaleDetail1 != null && stockPreSaleDetail1.size() != 0) {
                stockPreSaleDetaiList.add(stockPreSaleDetail1.get(0));
            }
        }
        //遍历明细记录，若果新加的预售明细的渠道的sku和统一渠道下的其他的sku时间重叠则报错
        for (StockPreSaleDetail spsd : stockPreSaleDetaiList) {
            if ((spsd.getStartTime().before(stockPreSaleDetail.getEndTime()) && spsd.getEndTime().after(stockPreSaleDetail.getEndTime()))
                    || (spsd.getStartTime().before(stockPreSaleDetail.getStartTime()) && spsd.getEndTime().after(stockPreSaleDetail.getStartTime()))) {
                stockLog.error("统一渠道下，同一sku的预售时间不能重复");
                errCode = ExceptionCode.TIMEREPEATED_ERRO_CODE;
                break;
            }
        }
        return errCode;
    }

    @Override
    public List<StockPreSaleDetail> getExistPreSaleDetail(Map<String, List<String>> paraListMap) {
        List<StockPreSaleDetail> stockPreSaleDetails = selectPreSaleDetail(paraListMap);
        return stockPreSaleDetails;
    }

    @Override
    public int updatePreSaleDetail(Map<String, String> paramMap) throws InvocationTargetException, IllegalAccessException {
        StockPreSaleDetail stockPreSaleDetail = new StockPreSaleDetail();
        BeanUtils.populate(stockPreSaleDetail, paramMap);
        StockPreSaleDetailExample stockPreSaleExample = new StockPreSaleDetailExample();
        StockPreSaleDetailExample.Criteria criteria = stockPreSaleExample.createCriteria();
        criteria.andIdEqualTo(stockPreSaleDetail.getId());
        return updtExistRecord(stockPreSaleDetail, paramMap)
                + stockPreSaleDetailMapper.updateByExampleSelective(stockPreSaleDetail, stockPreSaleExample);
    }

    @Override
    public int deletePreSaleDetail(Map<String, String> paramMap) throws InvocationTargetException, IllegalAccessException {
        Map<String, List<String>> paraListMap = assembleSelectListParam(paramMap);
        int deleteCount = 0;
        List<String> idList = paraListMap.get("id");
        for (String id : idList) {
            StockPreSaleDetailExample example = new StockPreSaleDetailExample();
            example.createCriteria().andIdEqualTo(Integer.parseInt(id));
            deleteCount = deleteCount + stockPreSaleDetailMapper.deleteByExample(example);
        }
        return deleteCount;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    public String uploadPreSaleDetail(List<String> fileStrs, long relationId) throws InterruptedException {
        String errCode = "";
        if (fileStrs == null || fileStrs.size() == 0) {
            errCode = "导入预售明细数据时候文件不能为空!";
            return errCode;
        }
        List<StockPreSaleDetail> beanList = new ArrayList<>();
        String[] firstLine = fileStrs.get(0).split(",");
        for (int i = 1; i < fileStrs.size(); i++) {
            StockPreSaleDetail stockPreSaleDetail = fileDataToBean(firstLine, fileStrs.get(i), FileConstants.PRESALEDETAIL);
            stockPreSaleDetail.setRelationId(relationId);
            for (StockPreSaleDetail stockPreSaleDetail_1 : beanList) {
                if (stockPreSaleDetail.getProdId().equals(stockPreSaleDetail_1.getProdId())
                        && stockPreSaleDetail.getWarehId().equals(stockPreSaleDetail_1.getWarehId())) {
                    errCode = "文件中含有重复的数据!";
                    return errCode;
                }
            }
            beanList.add(stockPreSaleDetail);
        }
        List<List<StockPreSaleDetail>> stockPreSaleDetailListList = CommonUtil.splitList(beanList, 2000);
        stockLog.debug("更新或者插入预售明细表开始" + new Date());
        final ThreadConfig tmpconfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_UPLOAD_PREDETAIL);
        for (List<StockPreSaleDetail> stockPreSaleDetailList : stockPreSaleDetailListList) {
            while (true) {
                if (tmpconfig.isThreadPoolNotEmpty()) {
                    tmpconfig.threadUp();
                    threadPoolTaskExecutor.submit(new UpdateOrInsertRecords(stockPreSaleDetailList, tmpconfig));
                    break;
                }
            }
        }
        tmpconfig.waitAllThreadDown();
        stockLog.debug("更新或者插入预售明细表开始结束" + new Date());
        return errCode;
    }

    class UpdateOrInsertRecords implements Runnable{

        private ThreadConfig tmpconfig;

        private List<StockPreSaleDetail> stockPreSaleDetails;

        public UpdateOrInsertRecords(List<StockPreSaleDetail> stockPreSaleDetails, ThreadConfig tmpconfig) {
            this.tmpconfig = tmpconfig;
            this.stockPreSaleDetails = stockPreSaleDetails;
        }
        @Override public void run() {
            try {
                for (StockPreSaleDetail stockPreSaleDetail : stockPreSaleDetails) {
                    Map<String, List<String>> params = new HashMap<>();
                    List<String> relationIds = new ArrayList<>();
                    List<String> prodIds = new ArrayList<>();
                    List<String> warehIds = new ArrayList<>();
                    relationIds.add(String.valueOf(stockPreSaleDetail.getRelationId()));
                    prodIds.add(stockPreSaleDetail.getProdId());
                    warehIds.add(stockPreSaleDetail.getWarehId());
                    params.put("relationId", relationIds);
                    params.put("prodId", prodIds);
                    params.put("warehId", warehIds);
                    List<StockPreSaleDetail> details = selectPreSaleDetail(params);
                    if (details != null && details.size() > 0) {
                        //预留量 = 已存在的记录的预留量 + 导入的相同sku，relationId，warehId的预留量
                        StockPreSaleDetail existDetail = details.get(0);
                        stockPreSaleDetail.setPrePrivateStock(existDetail.getPrePrivateStock() + stockPreSaleDetail.getPrePrivateStock());
                        StockPreSaleDetailExample stockPreSaleExample = new StockPreSaleDetailExample();
                        StockPreSaleDetailExample.Criteria criteria = stockPreSaleExample.createCriteria();
                        criteria.andIdEqualTo(existDetail.getId());
                        stockPreSaleDetailMapper.updateByExampleSelective(stockPreSaleDetail, stockPreSaleExample);
                    } else {
                        stockPreSaleDetailMapper.insert(stockPreSaleDetail);
                    }
                    //更新relationId,prodId相同的记录的时间
                    Map<String, String> upExistRecordParams = new HashMap<>();
                    upExistRecordParams.put("relationId", String.valueOf(stockPreSaleDetail.getRelationId()));
                    upExistRecordParams.put("prodId", String.valueOf(stockPreSaleDetail.getProdId()));
                    updtExistRecord(stockPreSaleDetail, upExistRecordParams);
                }
            }finally {
                tmpconfig.threadDown();
            }
        }
    }

    @Override
    public int updatePreSale(Map<String, String> paraMap) {
        StockPreSale stockPreSale = new StockPreSale();
        try {
            BeanUtils.populate(stockPreSale, paraMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            stockLog.error("map:" + paraMap.toString() + "转成StockPreSale错误！" + e.getMessage(), e);
            return 0;
        }
        StockPreSaleExample stockPreSaleExample = new StockPreSaleExample();
        StockPreSaleExample.Criteria criteria = stockPreSaleExample.createCriteria();
        criteria.andIdEqualTo(stockPreSale.getId());
        return stockPreSaleMapper.updateByExampleSelective(stockPreSale, stockPreSaleExample);
    }

    private StockPreSaleDetail fileDataToBean(String[] firstLine, String lineDataStr, Map<String, String> colMap) {
        StockPreSaleDetail stockPreSaleDetail = new StockPreSaleDetail();
        try {
            String[] lineDataArray = lineDataStr.split(",");
            Map<String, String> paraMap = new HashMap<>();
            for (int i = 0; i < lineDataArray.length; i++) {
                for (@SuppressWarnings("rawtypes")
                Map.Entry entry : colMap.entrySet()) {
                    if (entry.getValue().equals(firstLine[i])) {
                        paraMap.put(String.valueOf(entry.getKey()), lineDataArray[i]);
                    }
                }
            }
            BeanUtils.populate(stockPreSaleDetail, paraMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockPreSaleDetail;
    }

    private int updtExistRecord(StockPreSaleDetail stockPreSaleDetail, Map<String, String> paramMap) {
        Map<String, List<String>> paraListMap = assembleSelectListParam(paramMap);
        //不传wareh,只通过ProdId，和relationId查相关记录
        paraListMap.put("warehId", new ArrayList<String>());
        List<StockPreSaleDetail> stockPreSaleDetailList = selectPreSaleDetail(paraListMap);
        for (StockPreSaleDetail stockPreSaleDetailTemp : stockPreSaleDetailList) {
            stockPreSaleDetailTemp.setStartTime(stockPreSaleDetail.getStartTime());
            stockPreSaleDetailTemp.setEndTime(stockPreSaleDetail.getEndTime());
            stockPreSaleDetailTemp.setUpdateTime(stockPreSaleDetail.getUpdateTime());
            stockPreSaleDetailTemp.setUpdateBy(stockPreSaleDetail.getUpdateBy());
            //更新
            StockPreSaleDetailExample stockPreSaleExample = new StockPreSaleDetailExample();
            StockPreSaleDetailExample.Criteria criteria = stockPreSaleExample.createCriteria();
            criteria.andIdEqualTo(stockPreSaleDetailTemp.getId());
            stockPreSaleDetailMapper.updateByExampleSelective(stockPreSaleDetailTemp, stockPreSaleExample);
        }
        return stockPreSaleDetailList.size();
    }

    /**
     * @description 组装允许一个key多个参数的查询
     * @param paraMap
     *            参数
     * @return 参数Map
     */
    private Map<String, List<String>> assembleSelectListParam(Map<String, String> paraMap) {
        Map<String, List<String>> paraListMap = new ConcurrentHashMap<>();
        List<String> multipleList = new ArrayList<>();
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            List<String> list = new ArrayList<>();
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isBlank(value)) {
                continue;
            }
            if (value.contains(",")) {
                multipleList.add(key);
                String[] values = value.split(",");
                for (String data : values) {
                    list.add(data);
                }
            } else {
                list.add(value);
            }
            paraListMap.put(key, list);
        }
        if (multipleList.size() > 0) {
            paraListMap.put(Constants.MULTIPLE_FLAG, multipleList);
        }
        return paraListMap;
    }
}
