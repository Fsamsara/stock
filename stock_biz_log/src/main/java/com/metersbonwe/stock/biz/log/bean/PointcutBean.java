package com.metersbonwe.stock.biz.log.bean;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.metersbonwe.stock.biz.log.LogService;

public class PointcutBean {

    private Class<?> clazz;

    private String   methodName;

    private Object[] args;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public PointcutBean(Class<?> clazz, String methodName) {
        super();
        this.clazz = clazz;
        this.methodName = methodName;
    }

    public PointcutBean(Class<?> clazz, String methodName, Object[] args) {
        super();
        this.clazz = clazz;
        this.methodName = methodName;
        this.args = args;
    }

    public Method getMethod() {
        int i = 0;
        if (getArgs() != null) {
            i = getArgs().length;
        }
        Class<?>[] argsClazz = new Class<?>[i];
        for (int j = 0; j < i; j++) {
            argsClazz[j] = getArgs()[j].getClass();
        }
        Method method = null;
        try {
            method = getClazz().getMethod(getMethodName(), argsClazz);
        } catch (Exception e) {
            Method[] methods = getClazz().getMethods();
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getName().equals(getMethodName())) {
                    method = methods[j];
                    break;
                }
            }
        }
        return method;
    }

    public LogService getLogService() {
        Method method = getMethod();
        if (method == null) {
            return null;
        }
        return method.getAnnotation(LogService.class);
    }

    public PointcutBean() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
        result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PointcutBean other = (PointcutBean) obj;
        if (clazz == null) {
            if (other.clazz != null)
                return false;
        } else if (!clazz.equals(other.clazz))
            return false;
        if (methodName == null) {
            if (other.methodName != null)
                return false;
        } else if (!methodName.equals(other.methodName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PointcutBean [clazz=" + clazz + ", methodName=" + methodName + ", args=" + Arrays.toString(args) + "]";
    }

}
