package com.metersbonwe.stock.test.zry;

import java.sql.SQLException;

import com.metersbonwe.stock.test.JDBC;

public class IndexUtil {

    static String[] channels = new String[] { "HQ01S233", "HQ01S234", "HQ01S224", "A00031S006", "A00031S005", "HQ08S001", "HQ01S220", "HQ01S227",
            "HQ08S004", "HQ01S111", "A02588S019", "HQ01S112", "HQ01S113", "HQ01S114", "HQ01S115", "HQ01S116", "HQ01S117", "HQ01S118", "HQ01S119",
            "HQ01S120", "HQ01S121", "HQ01S122", "HQ01S123", "HQ01S132", "HQ01S135", "HQ01S141", "HQ01S143", "HQ01S160", "HQ01S162", "HQ01S164",
            "HQ01S165", "HQ01S166", "HQ01S167", "HQ01S168", "HQ01S169", "HQ01S171", "HQ01S172", "HQ01S173", "HQ01S174", "HQ01S176", "HQ01S179",
            "HQ01S217", "HQ01S999" };

    public static void main(String[] args) throws SQLException {
        //        仓库sku唯一索引();
        //        渠道表商品唯一索引();

        //        aaa();

//        for (int i = 0; i < channels.length; i++) {
//            String channel_code = channels[i];
//
//            String sql = "alter table stock_channel_sended_" + channel_code.toLowerCase() + " add index idx_prod_id(prod_id)";
//
//            System.out.println(sql);
//
//            try {
//                JDBC.execSqlU(sql);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
        
        
//        for (int i = 0; i < 30; i++) {
//            String sql = "alter table tmp_stock_wareh_prod_free_" + getHash(i) + " add column used_ma varchar(2) default '0'";
//            try {
//                JDBC.execSqlU(sql);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
        for (int i = 0; i < 30; i++) {
            String sql = "alter table tmp_stock_wareh_prod_free_" + getHash(i) + " add index idx_used_ma(used_ma) ";
            try {
                System.out.println(sql);
                JDBC.execSqlU(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected static void aaa() throws SQLException {
        for (int i = 0; i < 23; i++) {
            String sql = "insert into stock_wareh_table_mapping select wareh_id,count(1),0 from tmp_stock_wareh_prod_free_" + getHash(i)
                    + " group by wareh_id";

            System.out.println(sql);
            JDBC.execSqlU(sql);
        }
    }

    @SuppressWarnings("unused")
    private static void 渠道表商品唯一索引() throws SQLException {
        for (int i = 0; i < channels.length; i++) {
            //            String sql = "alter table stock_channel_prod_" + channels[i].toLowerCase() + " add unique  index idx_prod (prod_id);";
            //            String sql1 = "alter table stock_channel_prod_sub_" + channels[i].toLowerCase() + " add unique  index idx_prod (prod_id);";
            String dropsql = "alter table stock_channel_prod_" + channels[i].toLowerCase() + " drop   index prod_id ;";

            try {
                System.out.println(dropsql);
                JDBC.execSqlU(dropsql);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //            try {
            //                System.out.println(sql1);
            //                JDBC.execSqlU(sql1);
            //            } catch (Exception e) {
            //                e.printStackTrace();
            //            }
        }
    }

    @SuppressWarnings("unused")
    private static void 仓库sku唯一索引() throws SQLException {
        for (int i = 0; i < 30; i++) {
            String dropsql = "alter table stock_wareh_prod_" + getHash(i) + " drop   index idx_wareh_prod ;";

            //            String tun = "truncate table stock_wareh_prod_" + getHash(i);

            String sql = "alter table stock_wareh_prod_" + getHash(i) + " add unique  index idx_wareh_prod (wareh_id,prod_id);";

            //            System.out.println(tun);
            //            JDBC.execSqlU(tun);
            System.out.println(sql);
            JDBC.execSqlU(sql);
        }
    }

    public static String getHash(int i) {
        String temp = "" + i;
        return temp.length() == 1 ? "0" + temp : temp;
    }

}
