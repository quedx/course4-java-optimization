package com.quedx.course4.ch3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.quedx.course4.common.Util;

public class Increment_Atomic_Demo {

   private static final int MAX_THREAD_COUNT = 100;
   WebsiteActivity1 counter;
   ExecutorService executorService;

   Increment_Atomic_Demo() {
      counter = new WebsiteActivity1(1000_000);
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

      Increment_Atomic_Demo obj = new Increment_Atomic_Demo();
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
class WebsiteActivity1 implements Runnable {
   private AtomicInteger count = new AtomicInteger();
   private int maxLimit;

   WebsiteActivity1(int maxLimit) {
      this.maxLimit = maxLimit;
   }

   public int getCount() {
      return this.count.get();
   }

   @Override
   public void run() {
      for (int i = 0; i < this.maxLimit; ++i) {
         count.getAndIncrement();
      }
   }

}
