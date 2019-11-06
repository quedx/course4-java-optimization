package com.quedx.course4.ch5;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.quedx.course4.common.Util;

public class GuavaCacheDemo {

   CityMock cityMock = new CityMock();
   LoadingCache<String, City> cache;

   // constructor
   public GuavaCacheDemo() {

      cache = CacheBuilder.newBuilder().build(createLoader());
   }

   // cache loader
   private CacheLoader<String, City> createLoader() {
      return new CacheLoader<String, City>() {

         @Override
         public City load(String key) throws Exception {
            return cityMock.getCity(key);
         }

      };
   }

   /**
    * Shows city details
    */
   public void getCityDetails() {

      for (int i = 0; i <= 1000; ++i) {

         String cityName = String.format("city-%d", (int) (Math.random() * 100));
         City city = cityMock.getCity(cityName);
         //Util.getLogger().info("City details : " + city);
      }

   }

   public void getCityDetails_cached() {

      for (int i = 0; i <= 1_000_000; ++i) {

         try {

            String cityName = String.format("city-%d", (int) (Math.random() * 100));
            City city = cache.get(cityName);
            //Util.getLogger().info("City details : " + city);
         } catch (ExecutionException e) {
            e.printStackTrace();
         }
      }

   }
   /**
    * Main
    * 
    * @param args
    */
   public static void main(String[] args) {
      GuavaCacheDemo obj = new GuavaCacheDemo();

      String methodName = "getCityDetails";
      Long duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "getCityDetails_cached";
      duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "getCityDetails";
      duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

      methodName = "getCityDetails_cached";
      duration = Util.getExecutionTime(obj, methodName);
      Util.getLogger(obj.getClass())
            .info(String.format("execution time for [%s] ==> %10.6f ms", methodName, Util.nanoToMs(duration)));

   }
}
