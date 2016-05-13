package com.metersbonwe.stock.test.dal.define;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.metersbonwe.stock.dal.define.sync.mapper.BfOrgShopGroupDefineMapper;
import com.metersbonwe.stock.test.TestBase;

public class BfOrgShopGroupDefineMapperTest extends TestBase {
    
    @Resource BfOrgShopGroupDefineMapper bfOrgShopGroupDefineMapper;
    @Test
    public void testShopGroup() {
        List<String> channel_codes = Lists.newArrayList("A00064S101");
        List item = bfOrgShopGroupDefineMapper.selectShopGroup(channel_codes);
        System.out.println(item);
    }
    

}
