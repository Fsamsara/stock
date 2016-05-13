package com.metersbonwe.stock.biz.common.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.metersbonwe.stock.biz.common.service.WarehSkuCommonService;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.po.core.StockWarehProd;

@Service("changeFinalFreeShareStockService")
public class ChangeFinalFreeShareStockServiceImpl implements ChangeFinalFreeShareStockService {

    @Resource
    private MultiTableService multiTableService;
    
    @Resource
    private WarehSkuCommonService warehSkuCommonService;

    @Autowired
    private StockWarehProdDefineMapper stockWarehProdDefineMapper;

    @Override
    public int updateStockWarehProd(StockWarehProd stockWarehProd) throws Exception {
        
        int count = 0;
        
        if (StringUtils.isEmpty(stockWarehProd.getWarehId()) && StringUtils.isEmpty(stockWarehProd.getTableNum())) {
            return 0;
        }

        if(StringUtils.isEmpty(stockWarehProd.getTableNum())){
            stockWarehProd.setTableNum(multiTableService.getTableSuffixByWarehId(stockWarehProd.getWarehId()));
        }
        
        count = this.updateFinalFreeShareStock(stockWarehProd);
        
        //更新STOCK_WAREH_PROD失败,INSERT
        if (updateFail(stockWarehProd, count)) {
            count = warehSkuCommonService.insertWarehSkuWithout(stockWarehProd.getWarehId(), stockWarehProd.getProdId());
            if (count > 0) {
                count = updateFinalFreeShareStock(stockWarehProd);
            }
        }
        return count;
    }

    
    private boolean updateFail(StockWarehProd stockWarehProd, int count) {
        return count == 0 && !StringUtils.isEmpty(stockWarehProd.getProdId()) && !StringUtils.isEmpty(stockWarehProd.getWarehId());
    }
    
    /**
     * 更新MySql核心库STOCK_WAREH_PORD表最终自由量
     * @param stockWarehProd
     * @return
     */
    private int updateFinalFreeShareStock(StockWarehProd stockWarehProd) {
        
        int count = 0;
        
        count = stockWarehProdDefineMapper.updateFinalFreeShareStockGTZero(stockWarehProd);
        
        if (count == 0 || stockWarehProd.getWarehId() == null || stockWarehProd.getProdId() == null) {
            count = count + stockWarehProdDefineMapper.updateFinalFreeShareStockLSZero(stockWarehProd);
        }
        
        return count;
    }
    
}
