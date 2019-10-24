package com.quedx.course4.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import com.quedx.course4.common.Util;

public class Increment_Automic_Demo {

   private static final int MAX_THREAD_COUNT = 100;
   WebsiteActivity counter;
   ExecutorService executorService;

   Increment_Automic_Demo() {
      counter = new WebsiteActivity(1000_000);
      executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
   }

   /**
    * Creates MAX_THREAD_COUNT threads.
    * 
    * @param times
    * @throws Exception
    */
   public void doProcess() throws Exception {

      List<Future<String>> futureList = new ArrayList(MAX_THREAD_COUNT);
      for (int i = 0; i < MAX_THREAD_COUNT; ++i) {
         Future<String> f = executorService.submit(counter);
         futureList.add(f);
      }

      // Get the return status of each thread
      futureList.stream().forEach(f -> {
         try {
            f.get();

         } catch (Exception e) {
            e.printStackTrace();
         }
      });

      executorService.shutdown();

      // Wait for all threads to finish
      while (!executorService.isTerminated()) {

      }

      Util.getLogger().info("final count value : " + counter.getCount());
   }

   // Main
   public static void main(String[] args) throws InterruptedException {

      Increment_Automic_Demo obj = new Increment_Automic_Demo();
      String methodName = "doProcess";
      Long duration = Util.getExecutionTime(obj, methodName);

      Util.getLogger(obj.getClass()).info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));
   }
}

/**
 * Performs increment operation <maxLimit> times
 *
 */
class WebsiteActivity implements Callable<String> {
   private AtomicInteger count = new AtomicInteger();
   private int maxLimit;

   WebsiteActivity(int maxLimit) {
      this.maxLimit = maxLimit;
   }

   public int getCount() {
      return this.count.get();
   }

   @Override
   public String call() throws Exception {
      for (int i = 0; i < this.maxLimit; ++i) {
         count.getAndIncrement();
      }
      return null;
   }

}
