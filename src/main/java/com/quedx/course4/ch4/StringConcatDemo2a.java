package com.quedx.course4.ch4;

import com.quedx.course4.common.DateUtil;
import com.quedx.course4.common.Util;

public class StringConcatDemo2a {
   public static final int STRINGS_TO_BE_CREATED = 1_000_000;

   public static void concatUsingPlus(String symbol, Double price, String currentDate) {
      for (int i = 0; i < STRINGS_TO_BE_CREATED; ++i) {
         String s1 =  symbol + " price on " + currentDate + " is " + price;
      }
   }

   public static void concatUsingStringBuilder(String symbol, Double price, String currentDate) {
      StringBuilder sb = null;
      for (int i = 0; i < STRINGS_TO_BE_CREATED; ++i) {
         sb = new StringBuilder(200);
         sb.append(symbol).append(" price on ").append(currentDate).append(" is ").append(price);
         String s1 =  sb.toString();
      }
   }
   

   // Main
   public static void main(String[] args) throws InterruptedException {

      String methodName = "concatUsingPlus";
      Long duration = Util.getExecutionTime(StringConcatDemo2a.class, methodName, "IBM", 100.11d, DateUtil.currentDate() );
      Util.getLogger(StringConcatDemo2a.class)
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "concatUsingStringBuilder";
      duration = Util.getExecutionTime(StringConcatDemo2a.class, methodName, "IBM", 100.11d, DateUtil.currentDate() );
      Util.getLogger(StringConcatDemo2a.class)
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

   }
}
