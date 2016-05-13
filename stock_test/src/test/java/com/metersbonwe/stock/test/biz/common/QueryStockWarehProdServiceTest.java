package com.metersbonwe.stock.test.biz.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.test.TestBase;

public class QueryStockWarehProdServiceTest extends TestBase {
    
    @Resource
    private QueryStockWarehProdService queryStockWarehProdServiceImpl;
    
    @Test
    public void warehSkuStockProdTest() {
        warehSkuStock6ProdTest();
        warehSkuStock8ProdTest();
        warehSkuStock11ProdTest();
    }
    
    @Test
    public void warehsSkusStockTest() {
        warehSkuStocks6ProdTest();
        warehSkuStocks8ProdTest();
        warehSkuStocks11ProdTest();
    }
    
    private void warehSkuStock11ProdTest() {
        try {
            String warehId = "A03559S001";
            List<String> skuList = new ArrayList<String>();
            skuList.add("24822921130");
            skuList.add("24820730131");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehSkuStock(warehId, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("11位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    private void warehSkuStock8ProdTest() {
        try {
            String warehId = "A03559S001";
            List<String> skuList = new ArrayList<String>();
            skuList.add("24822921");
            skuList.add("24820730");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehSkuStock(warehId, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("8位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    private void warehSkuStock6ProdTest() {
        try {
            String warehId = "A03559S001";
            List<String> skuList = new ArrayList<String>();
            skuList.add("248229");
            skuList.add("248207");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehSkuStock(warehId, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("6位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private void warehSkuStocks11ProdTest() {
        try {
            List<String> warehList = new ArrayList<String>();
            warehList.add("A03559S001");
            warehList.add("A01493S001");
            warehList.add("A03794S006");
            List<String> skuList = new ArrayList<String>();
            skuList.add("24822921130");
            skuList.add("24820730131");
            skuList.add("25737141136");
            skuList.add("25737440136");
            skuList.add("28635292139");
            skuList.add("22299270144");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehsSkusStock(warehList, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("11位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    private void warehSkuStocks8ProdTest() {
        try {
            List<String> warehList = new ArrayList<String>();
            warehList.add("A03559S001");
            warehList.add("A01493S001");
            warehList.add("A03794S006");
            List<String> skuList = new ArrayList<String>();
            skuList.add("24822921");
            skuList.add("24820730");
            skuList.add("25737141");
            skuList.add("25737440");
            skuList.add("28635292");
            skuList.add("22299270");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehsSkusStock(warehList, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("11位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    private void warehSkuStocks6ProdTest() {
        try {
            List<String> warehList = new ArrayList<String>();
            warehList.add("A03559S001");
            warehList.add("A01493S001");
            warehList.add("A03794S006");
            List<String> skuList = new ArrayList<String>();
            skuList.add("248229");
            skuList.add("248207");
            skuList.add("257371");
            skuList.add("257374");
            skuList.add("286352");
            skuList.add("222992");
            List<StockWarehProd> stockWarehProdList = queryStockWarehProdServiceImpl.getWarehsSkusStock(warehList, skuList);
            if(stockWarehProdList!=null && stockWarehProdList.size()>0) {
                System.out.println("11位码查询:"+stockWarehProdList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
