package com.metersbonwe.stock.biz.log.resolver;

import static java.util.Locale.ENGLISH;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.metersbonwe.stock.biz.log.LogSystemConfig;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

public abstract class AbstractArgsResolver implements ArgsResolver {

    protected String getIp() {
        return null;
    }

    protected String getServiceName(PointcutBean pointcutBean) {
        return getLogSystemConfig().getServiceName(pointcutBean);
    }

    protected String getChannelCode(Object argsObj) {
        try {
            Method channlMethod = getReadMethod(getChannelCodeName(argsObj.getClass()), argsObj.getClass());
            return getProperValue(channlMethod, argsObj);
        } catch (IntrospectionException e) {
        }
        return "";
    }

    protected String getWarehId(Object argsObj) {
        try {
            Method warehIdMethod = getReadMethod(getWarehName(argsObj.getClass()), argsObj.getClass());
            return getProperValue(warehIdMethod, argsObj);
        } catch (IntrospectionException e) {
        }
        return "";
    }

    protected String getProdId(Object argsObj) {
        try {
            Method prodIdMethod = getReadMethod(getProdName(argsObj.getClass()), argsObj.getClass());
            return getProperValue(prodIdMethod, argsObj);
        } catch (IntrospectionException e) {
        }
        return "";
    }

    public Method getReadMethod(String propertyName, Class<?> clazz) throws IntrospectionException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, clazz, "get" + capitalize(propertyName), null);
        return propertyDescriptor.getReadMethod();
    }

    protected String getProperValue(Method channlMethod, Object argsObj) {
        try {
            return (String) channlMethod.invoke(argsObj, new Object[] {});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected String getChannelCodeName(Class<?> clazz) {
        return "channelCode";
    }

    protected String getWarehName(Class<?> clazz) {
        return "warehId";
    }

    protected String getProdName(Class<?> clazz) {
        return "prodId";
    }

    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
    }

    protected abstract LogSystemConfig getLogSystemConfig();
}
