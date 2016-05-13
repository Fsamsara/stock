package com.metersbonwe.stock.biz.api.query;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ShopQueryStockService;
import com.metersbonwe.stock.facade.api.ShopQueryStockFacade;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStock;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockRes;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStock;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockRes;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryLocStockResultBean;
import com.metersbonwe.stock.pojo.ShopQueryStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryStockResultBean;

@Service public class ShopQueryStockFacadeImpl implements ShopQueryStockFacade {

    private static StockLog                 stockLog = StockLogFactory.getLogger(ShopQueryStockFacadeImpl.class);

    @Resource private ShopQueryStockService shopQueryStockServiceImpl;

    /**
     * TODO 门店查询货位库存 TODO 根据门店编码、货位编码集合【非必填】、商品编码集合查询货位库存
     * 
     * @see com.metersbonwe.stock.facade.api.ShopQueryStockFacade#shopQueryLocStock(com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockReq)
     */
    @Override
    public ShopQueryLocStockRes shopQueryLocStock(ShopQueryLocStockReq req) {
        ShopQueryLocStockRes shopQueryLocStockRes = new ShopQueryLocStockRes();
        shopQueryLocStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("shopQueryLocStock传入的参数无效");
            shopQueryLocStockRes.setMsg("传入的参数无效");
            return shopQueryLocStockRes;
        }
        stockLog.info("shopQueryLocStock传入的参数为:" + req.toString());
        if (req.getWarehId() == null || "".equals(req.getWarehId())) {
            stockLog.warn("shopQueryLocStock传入的仓库编码无效");
            shopQueryLocStockRes.setMsg("传入的仓库编码无效");
            shopQueryLocStockRes.setSucessed(false);
            return shopQueryLocStockRes;
        }
        if (null == req.getSkuList() || req.getSkuList().size() <= 0) {
            stockLog.warn("shopQueryLocStock传入的商品编码无效," + req.toString());
            shopQueryLocStockRes.setMsg("传入的商品编码无效");
            return shopQueryLocStockRes;
        }

        ShopQueryLocStockParamBean paramBean = new ShopQueryLocStockParamBean();
        paramBean.setWarehId(req.getWarehId());
        paramBean.setLocList(req.getLocList());
        paramBean.setSkuList(req.getSkuList());
        List<ShopQueryLocStockResultBean> shopQueryLocStockResultList = this.shopQueryStockServiceImpl.shopQueryLocStock(paramBean);
        if (shopQueryLocStockResultList == null || shopQueryLocStockResultList.size() <= 0) {
            stockLog.warn("shopQueryLocStock没有查询到数据," + req.toString());
            shopQueryLocStockRes.setMsg("没有查询到数据");
            return shopQueryLocStockRes;
        }
        List<ShopQueryLocStock> shopQueryLocStockList = new ArrayList<ShopQueryLocStock>();
        for (ShopQueryLocStockResultBean resultBean : shopQueryLocStockResultList) {
            ShopQueryLocStock shopQueryLocStock = new ShopQueryLocStock();
            shopQueryLocStock.setWarehId(resultBean.getWarehId());
            shopQueryLocStock.setLocId(resultBean.getLocId());
            shopQueryLocStock.setProdId(resultBean.getProdId());
            shopQueryLocStock.setStock(resultBean.getStock());

            shopQueryLocStockList.add(shopQueryLocStock);
        }
        shopQueryLocStockRes.setShopQueryLocStockList(shopQueryLocStockList);
        shopQueryLocStockRes.setSucessed(true);

        return shopQueryLocStockRes;
    }

    /**
     * TODO 门店查询库存 TODO 根据门店编码、商品编码集合查询货位库存
     * 
     * @see com.metersbonwe.stock.facade.api.ShopQueryStockFacade#shopQueryStock(com.metersbonwe.stock.facade.api.bean.ShopQueryStockReq)
     */
    @Override
    public ShopQueryStockRes shopQueryStock(ShopQueryStockReq req) {
        ShopQueryStockRes shopQueryStockRes = new ShopQueryStockRes();
        shopQueryStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("shopQueryStock传入的参数无效");
            shopQueryStockRes.setMsg("传入的参数无效");
            return shopQueryStockRes;
        }
        stockLog.info("shopQueryStock传入的参数为:" + req.toString());
        if (req.getWarehId() == null || "".equals(req.getWarehId())) {
            stockLog.warn("shopQueryStock传入的仓库编码无效");
            shopQueryStockRes.setMsg("传入的仓库编码无效");
            shopQueryStockRes.setSucessed(false);
            return shopQueryStockRes;
        }
        if (null == req.getSkuList() || req.getSkuList().size() <= 0) {
            stockLog.warn("shopQueryStock传入的商品编码无效," + req.toString());
            shopQueryStockRes.setMsg("传入的商品编码无效");
            return shopQueryStockRes;
        }

        ShopQueryStockParamBean paramBean = new ShopQueryStockParamBean();
        paramBean.setWarehId(req.getWarehId());
        paramBean.setSkuList(req.getSkuList());
        List<ShopQueryStockResultBean> shopQueryStockResultList = this.shopQueryStockServiceImpl.shopQueryStock(paramBean);
        if (shopQueryStockResultList == null || shopQueryStockResultList.size() <= 0) {
            stockLog.warn("shopQueryStock没有查询到数据," + req.toString());
            shopQueryStockRes.setMsg("没有查询到数据");
            return shopQueryStockRes;
        }
        List<ShopQueryStock> shopQueryStockList = new ArrayList<ShopQueryStock>();
        for (ShopQueryStockResultBean resultBean : shopQueryStockResultList) {
            ShopQueryStock shopQueryStock = new ShopQueryStock();
            shopQueryStock.setWarehId(resultBean.getWarehId());
            shopQueryStock.setProdId(resultBean.getProdId());
            shopQueryStock.setStock(resultBean.getStock());

            shopQueryStockList.add(shopQueryStock);
        }
        shopQueryStockRes.setShopQueryStockList(shopQueryStockList);
        shopQueryStockRes.setSucessed(true);

        return shopQueryStockRes;
    }

}
