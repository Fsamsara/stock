package com.metersbonwe.stock.utils;

import java.math.BigDecimal;

public class MathUtil {
	
   //默認除法運算精度
   private static final int DEF_DIV_SCALE = 10;

   /**
    * 提供精確的加法運算。
    * @param v1 被加數
    * @param v2 加數
    * @return 兩個參數的和
    */
   public static double add(double v1,double v2){
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.add(b2).doubleValue();
   }

   /**
    * 提供精確的減法運算。
    * @param v1 被減數
    * @param v2 減數
    * @return 兩個參數的差
    */
   public static double sub(double v1,double v2){
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.subtract(b2).doubleValue();
   }
   
   public static double sub(String v1,String v2){
       BigDecimal b1 = new BigDecimal(v1);
       BigDecimal b2 = new BigDecimal(v2);
       return b1.subtract(b2).doubleValue();
   }

   /**
    * 提供精確的乘法運算。
    * @param v1 被乘數
    * @param v2 乘數
    * @return 兩個參數的積
    */
   public static double mul(double v1,double v2){
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.multiply(b2).doubleValue();
   }

   /**
    * 提供（相對）精確的除法運算，當發生除不盡的情況時，精確到
    * 小數點以後10位元，以後的數字四捨五入。
    * @param v1 被除數
    * @param v2 除數
    * @return 兩個參數的商
    */
   public static double div(double v1,double v2){
       return div(v1,v2,DEF_DIV_SCALE);
   }

   /**
    * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指
    * 定精度，以後的數字四捨五入。
    * @param v1 被除數
    * @param v2 除數
    * @param scale 表示表示需要精確到小數點以後幾位。
    * @return 兩個參數的商
    */
   public static double div(double v1,double v2,int scale){
       if(scale<0){
           throw new IllegalArgumentException(
               "The scale must be a positive integer or zero");
       }
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
   }

   /**
    * 提供精確的小數位四捨五入處理。
    * @param v 需要四捨五入的數位
    * @param scale 小數點後保留幾位
    * @return 四捨五入後的結果
    */
   public static double round(double v,int scale){
       if(scale<0){
           throw new IllegalArgumentException(
               "The scale must be a positive integer or zero");
       }
       BigDecimal b = new BigDecimal(Double.toString(v));
       BigDecimal one = new BigDecimal("1");
       return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
   }
   
   public static double round(String v,int scale){
       if(null == v || "".equals(v))return Double.parseDouble("0");
	   if(scale<0){
           throw new IllegalArgumentException(
               "The scale must be a positive integer or zero");
       }
       BigDecimal b = new BigDecimal(v);
       BigDecimal one = new BigDecimal("1");
       return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
   }
   
   /**
    * 提供指数运算。
    * @param v
    * @param power 幂次数
    * @return
    */
   public static double power(double v,double power){
       
       return Math.pow(v,power);
   }
   
   /**
    * 取绝对值
    * @param v
    * @return
    */
   public static double absolute(double v)
   {
       if(v<0)
           return -v;
       return v;
   }

}
