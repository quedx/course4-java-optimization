package com.quedx.course4.ch4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quedx.course4.common.Util;

public class StringDemo3 {

   Logger logger = LoggerFactory.getLogger(StringDemo3.class);

   public String createDummyOrder() {
      return "order # 1234";
   }

   public String createDummyError() {
      return "some error";
   }

   public void submitOrder(String orderDetails) {
      // TODO Auto-generated method stub

   }

   // NON-LAZY
   public void processOrder_nonLazy() {
      boolean orderSubmitted = false;

      // build order
      String orderDetails = createDummyOrder();
      String errorMessage = createDummyError();
      logger.debug("Order details " + orderDetails);

      // submit order
      submitOrder(orderDetails);

      if (!orderSubmitted) {
         logger.info("Error creating order " + orderDetails + " " + errorMessage);
      }
   }

   // LAZY
   public void processOrder_lazy() {
      boolean orderSubmitted = false;

      // build order
      String orderDetails = createDummyOrder();
      String errorMessage = createDummyError();
      if (logger.isDebugEnabled()) {
         logger.debug("Order details " + orderDetails);
      }

      // submit order
      submitOrder(orderDetails);

      if (!orderSubmitted) {
         logger.info("Error creating order " + orderDetails + " " + errorMessage);
      }
   }

   // Main
   public static void main(String[] args) {

      StringDemo3 obj = new StringDemo3();
      String methodName = "processOrder_lazy";
      Long duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "processOrder_nonLazy";
      duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

   }
}
