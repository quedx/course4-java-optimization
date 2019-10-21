package com.quedx.course4.common;

import java.lang.reflect.Method;

public class ReflectionUtil {

   /**
    * Invoke static method from specified class
    * 
    * @param srcClass
    * @param methodName
    * @throws Exception
    */
   public static void invokeStaticMethod(Class srcClass, String methodName) throws Exception {

      Class[] c = {};
      Method method = srcClass.getDeclaredMethod(methodName, c);
      Object[] noParams = {};
      method.invoke(null, noParams);
   }

   /**
    * Invoke method
    * 
    * @param obj
    * @param methodName
    * @param methodArgs
    * @throws Exception
    */
   public static void invokeNonStaticMethod(Object obj, String methodName, Object... methodArgs) throws Exception {

      Class[] classArgs = new Class[methodArgs.length];
      int i = 0;
      for (Object methodArg : methodArgs) {
         classArgs[i++] = methodArg.getClass();
      }
      Method method = obj.getClass().getMethod(methodName, classArgs);
      method.invoke(obj, methodArgs);
   }

   /**
    * Dummy method
    */
   public static void dummyStatic() {
      Util.getLogger(ReflectionUtil.class).info("dummyStatic() invoked");

   }

   /**
    * Dummy method
    */
   public static int dummyNonStatic(Integer x) {
      Util.getLogger(ReflectionUtil.class).info("dummyNonStatic() invoked");
      return 10;
   }

   /**
    * Main
    * 
    * @param args
    */
   public static void main(String[] args) {

      try {
         ReflectionUtil.invokeStaticMethod(ReflectionUtil.class, "dummyStatic");

         ReflectionUtil ru = new ReflectionUtil();
         ReflectionUtil.invokeNonStaticMethod(ru, "dummyNonStatic", 100);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}
