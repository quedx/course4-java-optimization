package com.quedx.course4.common;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

   public static final BigDecimal ONE_MM = BigDecimal.valueOf(1000000);

   /**
    * Get the logger for specified class
    * 
    * @param srcClass
    * @return
    */
   public static Logger getLogger(Class... srcClass) {

      return LoggerFactory.getLogger(srcClass.length == 0 ? Util.class : srcClass[0]);
   }

   /**
    * Create new instance (assume that there is default constructor)
    * 
    * @param srcClass
    * @return
    */
   public static Object newInstance(Class srcClass) {

      Object retObject = null;
      try {
         retObject = srcClass.newInstance();

      } catch (InstantiationException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return retObject;
   }

   /**
    * Get execution time
    * 
    * @param srcClass
    * @param methodName
    * @return
    */
   public static long getExecutionTime(Class srcClass, String methodName) {

      Instant start = Instant.now();

      // Invoke method to test
      try {
         ReflectionUtil.invokeStaticMethod(srcClass, methodName);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Instant end = Instant.now();

      return Duration.between(start, end).toNanos();
   }
   
   
   /**
    * Invoke method
    * 
    * @param obj
    * @param methodName
    * @param methodArgs
    * @return execution time in nano seconds
    */
   public static long getExecutionTime(Class srcClass, String methodName, Object... methodArgs) {

      Instant start = Instant.now();

      // Invoke method to test
      try {
         ReflectionUtil.invokeStaticMethod(srcClass, methodName, methodArgs);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Instant end = Instant.now();

      return Duration.between(start, end).toNanos();
   }


   
   /**
    * Invoke method
    * 
    * @param obj
    * @param methodName
    * @param methodArgs
    * @return execution time in nano seconds
    */
   public static long getExecutionTime(Object obj, String methodName, Object... methodArgs) {

      Instant start = Instant.now();

      // Invoke method to test
      try {
         ReflectionUtil.invokeNonStaticMethod(obj, methodName, methodArgs);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Instant end = Instant.now();

      return Duration.between(start, end).toNanos();
   }

   /**
    * Convert value to ms
    * 
    * @param value_
    * @return
    */
   public static BigDecimal nanoToMs(long value_) {
      BigDecimal value = new BigDecimal(value_);
      return value.divide(ONE_MM, 6, BigDecimal.ROUND_HALF_EVEN);

   }

   /**
    * Static dummy
    */
   public static void dummyStatic() {
      Util.getLogger().info("dummyStatic()");
      try {
         Thread.sleep(2345);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   /**
    * Geenerate random string
    * 
    * @param prefix
    * @param length
    * @return
    */
   public static String getRandomString(String prefix, int length) {
      if (length < prefix.length()) {
         return "";
      }
      
      long factor = (long) Math.pow(10, length - prefix.length());

      return String.format("%s%d", prefix, (long) (Math.random() * factor));

   }

   /**
    * dummy
    */
   public void dummy() {
      Util.getLogger().info("dummy()");
      try {
         Thread.sleep(1234);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   /**
    * Main
    */
   public static void main(String[] args) {
      /*
       * long duration = Util.getExecutionTime(Util.class, "dummyStatic");
       * Util.getLogger().info(" >>>>> took " + Util.nanoToMs(duration) + " ms");
       * 
       * Object[] methodParams = {}; duration = Util.getExecutionTime(new Util(),
       * "dummy", methodParams); Util.getLogger().info(" >>>>> took " +
       * Util.nanoToMs(duration) + " ms");
       */

      Util.getLogger().info(Util.getRandomString("Hello", 10));

   }

}
