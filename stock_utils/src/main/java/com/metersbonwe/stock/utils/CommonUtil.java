package com.metersbonwe.stock.utils;

import oracle.sql.Datum;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @description 通用工具类
 * @date 2016/03/17
 * @version V1.0
 * @author huangbiao
 */

public class CommonUtil {
    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    public static void transMap2Bean(Map<String, Object> map, Object obj) {

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = processProperty(property.getName());
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    if (value instanceof Datum) {
                        value = ((Datum) value).timestampValue();
                    }
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }

        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
    }

    //将驼峰规则的变量名转化成带下划线的key（数据库里面的字段名），如： warehId --> wareh_Id
    private static String processProperty(String proName) {
        StringBuffer sb = new StringBuffer();
        if (proName != null) {
            for (int i = 0; i < proName.length(); i++) {
                char c = proName.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append('_').append(c);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    /**
     * 判断输入对象是否为空
     * 
     * @param obj
     *            输入对象
     * @return 空， <code>true</code> ；否则， <code>false</code>
     */
    public static boolean isNull(Object obj) {
        if (obj == null || "".equals(obj))
            return true;
        if (obj instanceof String) {
            if ("".equals(obj.toString().trim()))
                return true;
            else if ("null".equals(obj.toString().toLowerCase().trim()))
                return true;
        }
        return false;
    }

    /**
     * 截去空字符串
     */
    public static String trimNull(Object obj) {
        if (obj == null || obj.toString().equalsIgnoreCase("null"))
            return "";
        else if (obj instanceof String) {
            return ((String) obj).trim();
        } else
            return obj.toString();
    }

    /**
     * 判断输入字符串是否为整型字符串
     * 
     * @param strInput
     *            整型字符串
     * @return 是整型， <code>true</code> ；否则， <code>false</code> add by yanger2002-11-19
     */
    public static boolean isInt(String strInput) {
        try {
            Integer.parseInt(strInput);
            return true;
        } catch (Exception e) {
            return (false);
        }
    }

    /**
     * 数字字符串转换为整型数
     * 
     * @param str
     *            数字字符串
     * @return 整型数
     */
    public static int toInt(String str) {
        if (str == null || "".equals(str.trim()))
            return 0;
        int tmp = 0;
        try {
            tmp = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0; // (-1);
        }
        return tmp;
    }

    public static int toInt(Object obj) {
        if (obj == null)
            return 0;
        else if (obj instanceof Integer)
            return ((Integer) obj).intValue();
        else if (obj instanceof BigDecimal)
            return ((BigDecimal) obj).intValue();
        int tmp = 0;
        try {
            tmp = Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0; // (-1);
        }
        return tmp;
    }

    /**
     * 判断输入字符串是否为浮点字符串
     * 
     * @param strInput
     *            浮点字符串
     * @return 是浮点型， <code>true</code> ；否则， <code>false</code>
     */
    public boolean isFloat(String strInput) {
        try {
            Double.parseDouble(strInput);
            return true;
        } catch (Exception e) {
            return (false);
        }
    }

    /**
     * 判断是否为浮点数，包括double和float
     * 
     * @param str
     *            传入的字符串
     * @return 是浮点数返回true,否则返回false
     */
    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断输入的字符串是否符合Email样式.
     * 
     * @param str
     *            传入的字符串
     * @return 是Email样式返回true,否则返回false
     */
    public static boolean isEmail(String str) {
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断输入的字符串是否为纯汉字
     * 
     * @param str
     *            传入的字符窜
     * @return 如果是纯汉字返回true,否则返回false
     */
    public static boolean isChinese(String str) {
        Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
        return pattern.matcher(str).matches();
    }

    /**
     * 全角字符转半角字符
     * 
     * @param QJStr
     * @return String
     */
    public static final String QJToBJChange(String QJStr) {
        char[] chr = QJStr.toCharArray();
        String str = "";
        for (int i = 0; i < chr.length; i++) {
            chr[i] = (char) (chr[i] - 65248);
            str += chr[i];
        }
        return str;
    }

    /**
     * @description 按指定大小拆分List成List集合
     * @param resList
     *            原始List
     * @param count
     *            单元list大小
     * @param <T>
     *            泛型
     * @return 拆分后的List集合
     */
    public static <T> List<List<T>> splitList(List<T> resList, int count) {
        if (resList == null || count < 1)
            return null;
        List<List<T>> ret = new ArrayList<List<T>>();
        int size = resList.size();
        if (size <= count) {
            ret.add(resList);
        } else {
            int pre = size / count;
            int last = size % count;
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<T>();
                for (int j = 0; j < count; j++) {
                    itemList.add(resList.get(i * count + j));
                }
                ret.add(itemList);
            }
            if (last > 0) {
                List<T> itemList = new ArrayList<T>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }

    /**
     * 打印时间差
     * @param begin 开始时间
     * @param end 结束时间
     */
    public static String timeInterval(Date begin, Date end){
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long between = 0;
        try {
            //java.util.Date begin = dfs.parse("2009-07-10 10:22:21.214");
            //java.util.Date end = dfs.parse("2009-07-20 11:24:49.145");
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);
        return day + "天" + hour + "小时" + min + "分" + s + "秒" + ms + "毫秒";
    }

}
