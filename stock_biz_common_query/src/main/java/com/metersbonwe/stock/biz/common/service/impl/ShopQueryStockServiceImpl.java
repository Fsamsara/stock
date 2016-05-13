package com.metersbonwe.stock.biz.common.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.biz.common.service.ShopQueryStockService;
import com.metersbonwe.stock.dal.auto.sync.mapper.ShopMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.BfPartnerShopDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.SfStkDtlDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.StkDtlDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.sync.Shop;
import com.metersbonwe.stock.po.sync.ShopExample;
import com.metersbonwe.stock.po.sync.ShopExample.Criteria;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StkDtl;
import com.metersbonwe.stock.po.sync.define.BfPartnerShopDefine;
import com.metersbonwe.stock.po.sync.define.SfStkDtlDefine;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryLocStockResultBean;
import com.metersbonwe.stock.pojo.ShopQueryStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryStockResultBean;

@Service public class ShopQueryStockServiceImpl implements ShopQueryStockService {

    private static StockLog                        stockLog = StockLogFactory.getLogger(ShopQueryStockServiceImpl.class);

    @Resource private ActivityWarehService         activityWarehServiceImpl;

    @Resource private QueryStockWarehProdService   queryStockWarehProdServiceImpl;

    @Autowired private StockShopRemailDefineMapper stockShopRemailDefineMapper;

    @Autowired private SfStkDtlDefineMapper        sfStkDtlDefineMapper;

    @Autowired private StkDtlDefineMapper          stkDtlDefineMapper;

    @Autowired private ShopMapper                  shopMapper;

    @Autowired private BfPartnerShopDefineMapper   bfPartnerShopDefineMapper;

    /**
     * TODO 查询新老ERP门店货位库存 TODO 查询新老ERP门店货位库存
     * 
     * @param isNewErp
     * @param map
     * @return
     */
    private List<ShopQueryLocStockResultBean> queryLocStock(boolean isNewErp, boolean isQueryLoced, Map<String, Object> map) {
        List<ShopQueryLocStockResultBean> shopQueryLocStockResultList = new ArrayList<ShopQueryLocStockResultBean>();
        //查询货位库存
        if (isNewErp) {
            List<SfStkDtlDefine> sfStkDtlDefineList = null;
            if (isQueryLoced) {
                sfStkDtlDefineList = this.sfStkDtlDefineMapper.selectSfStkDtlByOthers(map);
            } else {
                sfStkDtlDefineList = this.sfStkDtlDefineMapper.selectSfStkDtlByOthersAndNoLoc(map);
            }

            if (sfStkDtlDefineList != null && sfStkDtlDefineList.size() > 0) {
                for (SfStkDtlDefine stkDtl : sfStkDtlDefineList) {
                    ShopQueryLocStockResultBean bean = new ShopQueryLocStockResultBean();
                    bean.setWarehId(stkDtl.getWarehId());
                    bean.setLocId(stkDtl.getLocId());
                    bean.setProdId(stkDtl.getProdNum());
                    bean.setStock(stkDtl.getStkOnHand());

                    shopQueryLocStockResultList.add(bean);
                }
            }
        } else {
            List<StkDtl> stkDtlList = null;
            if (isQueryLoced) {
                stkDtlList = this.stkDtlDefineMapper.selectStkDtlByOthers(map);
            } else {
                stkDtlList = this.stkDtlDefineMapper.selectStkDtlByOthersAndNoLoc(map);
            }
            if (stkDtlList != null && stkDtlList.size() > 0) {
                for (StkDtl stkDtl : stkDtlList) {
                    ShopQueryLocStockResultBean bean = new ShopQueryLocStockResultBean();
                    bean.setWarehId(stkDtl.getWarehId());
                    bean.setLocId(stkDtl.getLocId());
                    bean.setProdId(stkDtl.getProdId());
                    bean.setStock(stkDtl.getStkOnHand());

                    shopQueryLocStockResultList.add(bean);
                }
            }
        }

        return shopQueryLocStockResultList;
    }

    /**
     * TODO 查询门店货位未日结 TODO 查询门店货位未日结
     * 
     * @param isQueryLoced
     * @param map
     * @return
     */
    private Map<String, StockShopRemail> queryShopLocRemail(Boolean isQueryLoced, Map<String, Object> map) {

        Map<String, StockShopRemail> stockShopRemailMap = new HashMap<String, StockShopRemail>();

        List<StockShopRemail> stockShopRemailList = null; //门店货位未日结集合

        if (isQueryLoced) { //货位有值,加货位条件
            //查询门店货位未日结(根据货位查询)
            stockShopRemailList = this.stockShopRemailDefineMapper.selectShopLocRemailByOthers(map);
        } else {
            //查询门店货位未日结(不根据货位查询)
            stockShopRemailList = this.stockShopRemailDefineMapper.selectShopLocRemailByOthersAndNoLoc(map);
        }

        if (stockShopRemailList != null && stockShopRemailList.size() > 0) {
            for (StockShopRemail remail : stockShopRemailList) {
                String key = remail.getWarehId() + ":" + remail.getLocId() + ":" + remail.getProdId();
                if (!stockShopRemailMap.containsKey(key)) {
                    stockShopRemailMap.put(key, remail);
                }
            }
        }

        return stockShopRemailMap;
    }

    private int IntegerToInt(Integer gInteger) {
        int v = 0;
        if (gInteger != null) {
            v = gInteger;
        }
        return v;
    }

    /**
     * TODO 根据门店编码获取代销仓编码
     * 
     * @param shopId
     *            门店编码
     * @return
     */
    private String getConsignWarehId(String shopId) {
        //获取代销仓编码
        String consign_WarehId = "";
        ShopExample example = new ShopExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andConsignTypeEqualTo("T");
        List<Shop> shopList = this.shopMapper.selectByExample(example);
        if (shopList != null && shopList.size() > 0) {
            Shop shop = shopList.get(0);
            if (shop != null) {
                consign_WarehId = shop.getConsignWarehid();
                consign_WarehId = consign_WarehId == null ? "" : consign_WarehId;
            }
        }
        return consign_WarehId;
    }

    /**
     * TODO 根据门店编码获取合伙人仓编码
     * 
     * @param shopId
     *            门店编码
     * @return
     */
    private String getAccountWarehId(String shopId) {
        String account_WarehId = "";
        List<BfPartnerShopDefine> partnerShopList = this.bfPartnerShopDefineMapper.selectBfPartnerShopByShopCode(shopId);
        if (partnerShopList != null && partnerShopList.size() > 0) {
            BfPartnerShopDefine partnerShop = partnerShopList.get(0);
            if (partnerShop != null) {
                account_WarehId = partnerShop.getAccountWarehCode();
                account_WarehId = account_WarehId == null ? "" : account_WarehId;
            }
        }
        return account_WarehId;
    }

    /**
     * TODO 门店查询货位库存
     * 
     * @see com.metersbonwe.stock.biz.common.service.ShopQueryStockService#shopQueryLocStock(com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean)
     */
    public List<ShopQueryLocStockResultBean> shopQueryLocStock(ShopQueryLocStockParamBean paramBean) {
        return shopQueryLocStock_Page(null, paramBean);
    }

    /**
     * TODO 门店按分页查询货位库存
     * 
     * @see com.metersbonwe.stock.biz.common.service.ShopQueryStockService#shopQueryLocStock_Page(com.metersbonwe.stock.pojo.Page,
     *      com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean)
     */
    public List<ShopQueryLocStockResultBean> shopQueryLocStock_Page(Page<?> page, ShopQueryLocStockParamBean paramBean) {
        String warehId = paramBean.getWarehId();
        StActivityWareh activityWareh = this.activityWarehServiceImpl.findActivityWareh(warehId);
        if (activityWareh == null) {
            stockLog.error("shopQueryLocStock根据门店编码" + warehId + "没有找到对应的记录");
            return null;
        }

        List<String> locList = paramBean.getLocList();
        List<String> skuList = paramBean.getSkuList();
        if (skuList == null || skuList.size() <= 0) {
            stockLog.error("shopQueryLocStock商品编码无效");
            return null;
        }

        String prodId = skuList.get(0);
        if (prodId == null || "".equals(prodId)) {
            stockLog.error("getWarehSkuStock:传入的第一个商品编码为空");
            return null;
        }
        int prodLen = prodId.length();

        //是否新ERP
        boolean isNewErp = this.activityWarehServiceImpl.isNewERP(activityWareh.getDataSource());
        //货位是否有值
        boolean isQueryLoced = locList != null && locList.size() > 0;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("warehId", warehId);
        map.put("prodLen", prodLen);
        map.put("skuList", skuList);
        if (isQueryLoced) { //有货位
            map.put("locList", locList);
        }

        //查询门店货位库存
        if (page != null) {
            PageThreadLocal.setThreadLocalPage(page);
        }
        List<ShopQueryLocStockResultBean> shopQueryLocStockResultList = this.queryLocStock(isNewErp, isQueryLoced, map);
        //查询门店货位未日结
        Map<String, StockShopRemail> stockShopRemailMap = queryShopLocRemail(isQueryLoced, map);

        //门店货位库存-门店货位未日结
        if (stockShopRemailMap != null && stockShopRemailMap.size() > 0) {
            for (ShopQueryLocStockResultBean bean : shopQueryLocStockResultList) {
                String key = bean.getWarehId() + ":" + bean.getLocId() + ":" + bean.getProdId();
                StockShopRemail remail = stockShopRemailMap.get(key);
                if (remail != null) {
                    BigDecimal stock = bean.getStock();
                    Integer remailStock = remail.getRemailStock();
                    stock = BigDecimal.valueOf(stock.longValue() - remailStock < 0 ? 0 : stock.longValue() - remailStock);
                    bean.setStock(stock);
                }
            }
        }

        return shopQueryLocStockResultList;
    }

    /**
     * TODO 门店查询库存
     * 
     * @see com.metersbonwe.stock.biz.common.service.ShopQueryStockService#shopQueryStock(com.metersbonwe.stock.pojo.ShopQueryStockParamBean)
     */
    public List<ShopQueryStockResultBean> shopQueryStock(ShopQueryStockParamBean paramBean) {
        return shopQueryStock_Page(null, paramBean);
    }

    /**
     * TODO 门店分页查询库存
     * 
     * @see com.metersbonwe.stock.biz.common.service.ShopQueryStockService#shopQueryStock_Page(com.metersbonwe.stock.pojo.Page,
     *      com.metersbonwe.stock.pojo.ShopQueryStockParamBean)
     */
    public List<ShopQueryStockResultBean> shopQueryStock_Page(Page<?> page, ShopQueryStockParamBean paramBean) {
        String warehId = paramBean.getWarehId(); //门店编码
        List<String> skuList = paramBean.getSkuList();
        if (warehId == null || "".equals(warehId)) {
            stockLog.error("shopQueryStock仓库编码无效");
            return null;
        }
        if (skuList == null || skuList.size() <= 0) {
            stockLog.error("shopQueryStock商品编码无效");
            return null;
        }

        List<String> warehList = new ArrayList<String>();
        warehList.add(warehId);

        //获取代销仓编码
        String consign_WarehId = getConsignWarehId(warehId);
        if ("".equals(consign_WarehId)) { //如果代销仓为空
            //获取合伙人仓
            String account_WarehId = getAccountWarehId(warehId);
            if (!("".equals(consign_WarehId))) {
                warehList.add(account_WarehId);
            }
        } else {
            warehList.add(consign_WarehId);
        }

        //获取仓+sku库存
        List<StockWarehProd> stockWarehProdList = this.queryStockWarehProdServiceImpl.getWarehsSkusStock_Page(page, warehList, skuList);
        if (stockWarehProdList == null || stockWarehProdList.size() <= 0) {
            stockLog.debug("shopQueryStock:从仓+sku没有获取到值");
            return null;
        }

        List<ShopQueryStockResultBean> shopQueryStockResultList = new ArrayList<ShopQueryStockResultBean>();
        for (StockWarehProd stockWarehProd : stockWarehProdList) {
            ShopQueryStockResultBean bean = new ShopQueryStockResultBean();
            bean.setWarehId(stockWarehProd.getWarehId());
            bean.setProdId(stockWarehProd.getProdId());
            //最终自由量共享(自由量-WMS正数锁定量-未日结-门店污损值-线上安全库存/线下安全库存)
            bean.setStock(BigDecimal.valueOf(IntegerToInt(stockWarehProd.getFinalFreeShareStock())));

            shopQueryStockResultList.add(bean);
        }

        return shopQueryStockResultList;
    }

}
