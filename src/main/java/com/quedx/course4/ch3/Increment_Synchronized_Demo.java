package com.quedx.course4.ch3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.quedx.course4.common.Util;

public class Increment_Synchronized_Demo {

   private static final int MAX_THREAD_COUNT = 100;
   WebsiteAcitivity2 counter;
   ExecutorService executorService;

   Increment_Synchronized_Demo() {
      counter = new WebsiteAcitivity2(1000_000);
      executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
   }

   /**
    * Creates MAX_THREAD_COUNT threads.
    * 
    * @param times
    * @throws Exception
    */
   public void doProcess() throws Exception {

      for (int i = 0; i < MAX_THREAD_COUNT; ++i) {
         executorService.execute(counter);
      }

      executorService.shutdown();

      // Wait for all threads to finish
      while (!executorService.isTerminated()) {

      }

      Util.getLogger().info("final count value : " + counter.getCount());
   }

   // Main
   public static void main(String[] args) throws InterruptedException {

      Increment_Synchronized_Demo obj = new Increment_Synchronized_Demo();
      String methodName = "doProcess";
      Long duration = Util.getExecutionTime(obj, methodName);

      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));
   }
}

/**
 * Performs increment operation <maxLimit> times
 *
 */
class WebsiteAcitivity2 implements Runnable {
   private Integer count = 0;
   private int maxLimit;

   WebsiteAcitivity2(int maxLimit) {
      this.maxLimit = maxLimit;
   }

   public int getCount() {
      return this.count;
   }

   public synchronized void increment() {
      this.count += 1;
   }

   @Override
   public void run() {
      for (int i = 0; i < this.maxLimit; ++i) {
         increment();
      }

   }

}
