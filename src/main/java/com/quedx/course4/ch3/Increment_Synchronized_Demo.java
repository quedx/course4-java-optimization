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

      Increment_Synchronized_Demo obj = new Increment_Synchronized_Demo();
      String methodName = "doProcess";
      Long duration = Util.getExecutionTime(obj, methodName);

      Util.getLogger(obj.getClass()).info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));
   }
}

/**
 * Performs increment operation <maxLimit> times
 *
 */
class WebsiteAcitivity2 implements Callable<String> {
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
   public String call() throws Exception {
      for (int i = 0; i < this.maxLimit; ++i) {
         increment();
      }
      return null;
   }

}
