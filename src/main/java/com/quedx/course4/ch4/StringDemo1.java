package com.quedx.course4.ch4;

import com.quedx.course4.common.Util;

public class StringDemo1 {
   public static final int STRINGS_TO_BE_CREATED = 1_000_000;

   public static void createStringUsingNew() {
      for (int i = 0; i < STRINGS_TO_BE_CREATED; ++i) {
         String s1 = new String("test");
      }
   }

   public static void createStringWithoutNew() {
      for (int i = 0; i < STRINGS_TO_BE_CREATED; ++i) {
         String s1 = "test";
      }
   }

   // Main
   public static void main(String[] args) throws InterruptedException {

      StringDemo1 obj = new StringDemo1();
      String methodName = "createStringUsingNew";
      Long duration = Util.getExecutionTime(obj.getClass(), methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "createStringWithoutNew";
      duration = Util.getExecutionTime(obj.getClass(), methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

   }
}
