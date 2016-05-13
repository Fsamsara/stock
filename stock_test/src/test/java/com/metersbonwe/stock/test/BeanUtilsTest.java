package com.metersbonwe.stock.test;

import org.apache.commons.beanutils.ConvertUtils;

import com.metersbonwe.stock.utils.DateTimeConverter;

public class BeanUtilsTest {
    static {
        ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
    }

    public static void main(String[] args) {}
}
