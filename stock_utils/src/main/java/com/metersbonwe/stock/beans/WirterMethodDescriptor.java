package com.metersbonwe.stock.beans;

import static java.util.Locale.ENGLISH;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 符合JAVABEAN规范的属性写入工具
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-13 下午5:57:32
 */
public final class WirterMethodDescriptor {

    private PropertyDescriptor propertyDescriptor;

    public WirterMethodDescriptor(String propertyName, Class<?> clazz) throws IntrospectionException {
        propertyDescriptor = new PropertyDescriptor(propertyName, clazz, null, "set" + capitalize(propertyName));
    }

    public Method getWriteMethod() {
        return propertyDescriptor.getWriteMethod();
    }

    public PropertyDescriptor getPropertyDescriptor() {
        return propertyDescriptor;
    }

    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
    }
}
