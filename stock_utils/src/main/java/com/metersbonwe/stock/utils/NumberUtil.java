package com.metersbonwe.stock.utils;

import java.math.BigDecimal;

public class NumberUtil {

    /**
     * BigDecimal转Integer
     * @param bigDecimal
     */
    public static Integer bigDecimalToInteger(BigDecimal bigDecimal) {
        return bigDecimal.intValue();
    }

    /**
     * Integer转BigDecimal
     * @param integer
     */
    public static BigDecimal integerToBigDecimal(Integer integer) {
        return new BigDecimal(integer);
    }
}
