package com.metersbonwe.stock.utils;

import java.math.BigDecimal;
import java.util.Map;

@SuppressWarnings("rawtypes") public class MapUtils {

    public static String getStringVal(Map map, String key) {
        return getStringVal(map, key, false);
    }

    public static String getStringVal(Map map, String key, boolean isNull) {
        if (!isNull && map.get(key) == null) {
            throw new RuntimeException("MAP中key:" + key + "的值为空");
        }
        if (map.get(key) == null) {
            return "";
        }
        return map.get(key).toString();
    }

    public static int getNumberForBigDecimal(Map map, String key, boolean isNull) {
        if (isNull && map.get(key) == null) {
            return -1;
        }
        if (map.get(key) == null) {
            throw new RuntimeException("MAP中key:" + key + "为空");
        }
        BigDecimal temp = (BigDecimal) map.get(key);
        long num = Math.round(Math.floor(temp.doubleValue()));
        int numint = (int) num;
        return numint;
    }

    public static int getNumberForBigDecimal(Map map, String key) {
        return getNumberForBigDecimal(map, key, true);
    }

    public static int getIntegerForString(Map map, String key, boolean isNull) {
        if (isNull && map.get(key) == null) {
            return -1;
        }
        if (map.get(key) == null) {
            throw new RuntimeException("MAP中key:" + key + "为空");
        }
        return Integer.parseInt(map.get(key).toString());
    }

    public static int getIntegerForString(Map map, String key) {
        return getIntegerForString(map, key, true);

    }

    private MapUtils() {}
}
