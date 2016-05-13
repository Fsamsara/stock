package com.metersbonwe.stock.utils.imexcel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.metersbonwe.stock.beans.imexcel.ExcelMappingBean;
import com.metersbonwe.stock.pojo.imexcel.Header;
import com.metersbonwe.stock.utils.DateTimeConverter;
import com.metersbonwe.stock.utils.ReflectUtil;

public class ImportExportDataUtil {

    private static final String _SPLIT = ",";

    private ImportExportDataUtil() {}

    /**
     * TODO 导入数据
     * 
     * @param data
     * @param t
     * @return
     */
    public static <T> List<T> getImportData(List<String> dataList, Class<T> clazz) {
        if (dataList == null || dataList.size() <= 0) {
            return null;
        }
        String[] headerLines = dataList.get(0).split(_SPLIT); //获取表头
        Map<String, ExcelMappingBean> map = getExcelMappingMap(clazz, true);
        List<ExcelMappingBean> mappingBeanList = new ArrayList<ExcelMappingBean>();
        for (int i = 0; i < headerLines.length; i++) {
            String header = headerLines[i];
            ExcelMappingBean mappingBean = map.get(header);
            if (mappingBean == null) {
                continue;
            }
            mappingBeanList.add(mappingBean);
        }
        if (mappingBeanList.size() != headerLines.length) {
            //格式不对
            return null;
        }

        List<T> list = new ArrayList<T>();
        try {
            for (int i = 1; i < dataList.size(); i++) {
                String[] values = dataList.get(i).split(_SPLIT);
                T obj = clazz.newInstance();
                for (int j = 0; j < values.length; j++) {
                    String value = values[j];
                    if (value == null || "null".equals(value)) {
                        continue;
                    }
                    ExcelMappingBean mappingBean = mappingBeanList.get(j);
                    String name = mappingBean.getFieldName();
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    String typeName = mappingBean.getFieldTypeName();
                    if (typeName.equals("int")) {
                        Method m = obj.getClass().getMethod("set" + name, int.class);
                        m.invoke(obj, Integer.parseInt(value));
                    } else if (typeName.equals("class java.lang.Integer")) {
                        Method m = obj.getClass().getMethod("set" + name, Integer.class);
                        m.invoke(obj, Integer.parseInt(value));
                    } else if (typeName.equals("long")) {
                        Method m = obj.getClass().getMethod("set" + name, long.class);
                        m.invoke(obj, Long.parseLong(value));
                    } else if (typeName.equals("class java.lang.Long")) {
                        Method m = obj.getClass().getMethod("set" + name, Long.class);
                        m.invoke(obj, Long.parseLong(value));
                    } else if (typeName.equals("boolean")) {
                        Method m = obj.getClass().getMethod("set" + name, boolean.class);
                        m.invoke(obj, Boolean.parseBoolean(value));
                    } else if (typeName.equals("class java.lang.Boolean")) {
                        Method m = obj.getClass().getMethod("set" + name, Boolean.class);
                        m.invoke(obj, Boolean.parseBoolean(value));
                    } else if (typeName.equals("class java.lang.String")) {
                        Method m = obj.getClass().getMethod("set" + name, String.class);
                        m.invoke(obj, value);
                    } else if (typeName.equals("class java.util.Date")) {
                        Method m = obj.getClass().getMethod("set" + name, Date.class);
                        Object object = DateTimeConverter.toDate(java.util.Date.class, value);
                        Date date = null;
                        if (object != null) {
                            date = (Date) object;
                        }
                        m.invoke(obj, date);
                    }
                }
                list.add(obj);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    /**
     * TODO 导出数据
     * 
     * @param list
     * @return
     */
    public static <T> String getExportData(List<T> list, Class<T> clazz) {
        Map<String, ExcelMappingBean> map = getExcelMappingMap(clazz, false);
        StringBuffer buffer = new StringBuffer();
        String headerString = getExportTempleter(clazz, map);
        buffer.append(headerString);
        buffer.append("\n");
        for (T t : list) {
            for (String header : map.keySet()) {
                ExcelMappingBean mappingBean = map.get(header);
                if (mappingBean == null) {
                    break;
                }
                String filedName = mappingBean.getFieldName();
                Object obja = ReflectUtil.getFieldValue(t, filedName);
                buffer.append(obja).append(",");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    /**
     * TODO 获取导出数据模板
     * 
     * @param clazz
     * @param map
     * @return
     */
    public static <T> String getExportTempleter(Class<T> clazz, Map<String, ExcelMappingBean> map) {
        if (map == null || map.size() <= 0) {
            map = getExcelMappingMap(clazz, false);
        }
        List<String> sList = new ArrayList<String>();
        for (String s : map.keySet()) {
            sList.add(s);
        }
        String headers = StringUtils.join(sList.toArray(), _SPLIT);
        return headers;
    }

    private static <T> Map<String, ExcelMappingBean> getExcelMappingMap(Class<T> clazz, boolean isImported) {
        Map<String, ExcelMappingBean> map = new LinkedHashMap<String, ExcelMappingBean>();
        List<ExcelMappingBean> list = new ArrayList<ExcelMappingBean>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class<?> cls = f.getType();
            if (cls == ImportExportDataUtil.class) {
                continue;
            }
            Header headerBean = f.getAnnotation(Header.class);
            if (headerBean == null) {
                continue;
            }
            int order = headerBean.order();
            String header = headerBean.value();
            String fieldName = f.getName();
            String fieldTypeName = f.getGenericType().toString();

            ExcelMappingBean bean = new ExcelMappingBean(order, header, fieldName, fieldTypeName);
            list.add(bean);
        }
        Collections.sort(list); //升序

        for (ExcelMappingBean headerBean : list) {
            String key = headerBean.getHeader();
            map.put(key, headerBean);
        }

        return map;
    }

}
