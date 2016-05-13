package com.metersbonwe.stock.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
/**
 * xx_xx 格式转换成 驼峰规则  upcaseFlag  第一个驼峰的第一个字母是否大写
 * @author Feng
 *
 */
public class CamelUtil {
    public static String beCamel(String column,Boolean upcaseFlag) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (column == null || column.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!column.contains("_")) {
            if (upcaseFlag) {
                // 不含下划线，仅将首字母大写
                return column.substring(0, 1).toUpperCase() + column.substring(1).toLowerCase();
            }else {
                // 不含下划线，全部小写
                return column.toLowerCase();
            }
        } else {
            // 用下划线将原始字符串分割
            String[] columns = column.split("_");
            for (String columnSplit : columns) {
                // 跳过原始字符串中开头、结尾的下换线或双重下划线
                if (columnSplit.isEmpty()) {
                    continue;
                }
                // 处理真正的驼峰片段
                if (result.length() == 0) {
                    if (upcaseFlag && columnSplit.length() <= 1) {
                        result.append(columnSplit = columnSplit.toUpperCase());
                    }else if(upcaseFlag && columnSplit.length() > 1){
                        result.append(columnSplit = columnSplit.substring(0,1).toUpperCase()+columnSplit.substring(1).toLowerCase());
                    }else {
                        // 第一个驼峰片段，全部字母都小写
                        result.append(columnSplit.toLowerCase());
                    }
                } else {
                    // 其他的驼峰片段，首字母大写
                    result.append(columnSplit.substring(0, 1).toUpperCase()).append(columnSplit.substring(1).toLowerCase());
                }
            }
            return result.toString();
        }
    }
    
    public static String beCamel(String column) {
       return beCamel(column,false);
    }
    
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("C:/Users/Feng/Desktop/oracle-.txt"));
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < lines.size(); i++) {
            String str = lines.get(i);
            buffer.append("<table tableName=\"").append(str.trim()).append("\" ").append("domainObjectName=\"").append(CamelUtil.beCamel(str,true)).append("\"/>\n");
        }
        System.err.println(buffer.toString());
    }
}
