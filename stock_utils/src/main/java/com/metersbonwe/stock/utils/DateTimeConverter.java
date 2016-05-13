package com.metersbonwe.stock.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.beanutils.Converter;

public class DateTimeConverter implements Converter {

    private static final String DATETFORMAT_10 = "yyyy-MM-dd";

    private static final String DATETFORMAT_14 = "yyyy-M-d HH:mm";

    private static final String DATETFORMAT_16 = "yyyy-MM-dd HH:mm";

    private static final String DATETFORMAT_17 = "yyyy-M-d HH:mm:ss";

    private static final String DATETFORMAT_19 = "yyyy-MM-dd HH:mm:ss";

    private static final String DATETFORMAT_23 = "yyyy-MM-dd HH:mm:ss.SSS";

    @SuppressWarnings("unchecked")
    @Override
    public Object convert(@SuppressWarnings("rawtypes") Class type, Object value) {
        return toDate(type, value);
    }

    public static Object toDate(@SuppressWarnings("rawtypes") Class type, Object value) {
        if (value == null || "".equals(value))
            return null;
        if (value instanceof String) {
            String dateValue = value.toString().trim();
            int length = dateValue.length();
            if (type.equals(java.util.Date.class)) {
                try {
                    DateFormat formatter = null;
                    if (dateValue.contains("/")) {
                        dateValue = dateValue.replaceAll("/", "-");
                    }
                    if (length <= 10) {
                        formatter = new SimpleDateFormat(DATETFORMAT_10, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }

                    if (length <= 14) {
                        formatter = new SimpleDateFormat(DATETFORMAT_14, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }

                    if (length <= 16) {
                        formatter = new SimpleDateFormat(DATETFORMAT_16, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 17) {
                        formatter = new SimpleDateFormat(DATETFORMAT_17, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 19) {
                        formatter = new SimpleDateFormat(DATETFORMAT_19, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 23) {
                        formatter = new SimpleDateFormat(DATETFORMAT_23, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
