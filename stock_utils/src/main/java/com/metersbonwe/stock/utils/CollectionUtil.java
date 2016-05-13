package com.metersbonwe.stock.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {

    /**
     * 获取指定范围的list值
     * @param list
     * @param start
     * @param size
     * @return
     */
    public static <T> List<T> getList(List<T> list, int start, int size) {

        int count = list.size();

        List<T> result = new ArrayList<T>();

        if (start + size <= count) {
            for (int i = start; i < start + size; i++) {
                result.add(list.get(i));
            }
        } else {
            for (int i = start; i < count; i++) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    /**
     * 获取指定开始位置的list
     * @param list
     * @param start
     * @return
     */
    public static <T> List<T> getList(List<T> list, int start) {
        int count = list.size();

        List<T> result = new ArrayList<T>();

        if (start <= count) {
            for (int i = start; i < count; i++) {
                result.add(list.get(i));
            }
        }

        return result;
    }
    /**
     * 通用对象深度clone
     * @param src
     * FENG
     */
    public static Object clone(Object src) throws IOException, ClassNotFoundException {
        if (src == null)
            return src;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(src);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");

        List<String> aslist = getList(list, 5, 5);

        System.out.println("aslist=" + aslist);
    }
    
    public static boolean isEmpty(List<?> item) {
        return item == null || item.isEmpty() || item.get(0) == null;
    }
}
