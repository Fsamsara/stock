package com.metersbonwe.stock.configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.CloneUtils;

public class CreateSqlTest {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        String path = "E:\\workspace\\stock\\stock_configuration\\src\\test\\resources\\";
        String stockWarehProd = "stock_wareh_prod";
        String tmpStockWarehProd = "tmp_stock_wareh_prod";
        String stockChannelSended = "stock_channel_sended";
        String stockChannelProd = "stock_channel_prod";
        String stockChannelProdSub = "stock_channel_prod_sub";
        File file;
        //        file = new File(path + stockWarehProd + ".sql");
        //        createWarehProdTableName(stockWarehProd, file);

        file = new File(path + tmpStockWarehProd + ".sql");
        createWarehProdTableName(tmpStockWarehProd, file);

        File file2 = new File(path + "channel_list.sql");

        //        file = new File(path + stockChannelSended + ".sql");
        //        createTableName(stockChannelSended, file, file2);

        //        file = new File(path + stockChannelProd + ".sql");
        //        createTableName(stockChannelProd, file, file2);

        //        file = new File(path + stockChannelProdSub + ".sql");
        //        createTableName(stockChannelProdSub, file, file2);

    }

    @SuppressWarnings("unchecked")
    public static void createTableName(String name, File file, File file2) throws IOException, CloneNotSupportedException {
        List<String> list = FileUtils.readLines(file);
        List<String> list1 = FileUtils.readLines(file2);
        StringBuffer buffer = new StringBuffer();
        for (String string : list1) {
            List<String> list2 = (List<String>) CloneUtils.clone(list);
            String string2 = list2.get(0);
            string2 = string2.replace(name, name + "_" + string);
            list2.add(0, "DROP TABLE " + name + "_" + string + ";");
            list2.set(1, string2);
            buffer.append(
                    list2.toString().replace(";, ", ";").replace("(,", "(").replace(", )", ")").replace(",,", ",").replace("[", "").replace("]", ""))
                    .append(";");
        }
        System.out.println(buffer.toString());
    }

    public static void createWarehProdTableName(String name, File file) throws IOException, CloneNotSupportedException {
        int begin = 0;
        List<String> list = FileUtils.readLines(file);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            int begin2 = begin++;
            @SuppressWarnings("unchecked")
            List<String> list2 = (List<String>) CloneUtils.clone(list);
            String string2 = list2.get(0);
            string2 = string2.replace(name, name + "_" + createNum(begin2));
            list2.set(0, string2);
            String string3 = list2.get(1);
            string3 = string3.replace(name, name + "_" + createNum(begin2));
            list2.set(1, string3);
            buffer.append(
                    list2.toString().replace(";, ", ";").replace("(,", "(").replace(", )", ")").replace(",,", ",").replace("[", "").replace("]", "")
                            .replace("utf8,", "utf8"))
                    .append(";");
        }
        System.out.println(buffer.toString());
    }

    public static String createNum(int a) {
        String ab;
        if (a < 10) {
            ab = "0".concat(a + "");
        } else {
            ab = a + "";
        }
        return ab;
    }
}
