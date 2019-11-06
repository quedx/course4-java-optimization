package com.quedx.course4.ch5;

import java.util.HashMap;

public class CityMock {
   
   HashMap<String, City> cityMap = new HashMap();

   /*
   public static void createKnownCities() {
      City city = new City("NYC", "USA", 20_000000, 70000, 38, "sub-tropical", 1);
      city = new City("MUM", "IND", 18_000000, 1000, 50, "tropical", 9);
      city = new City("TOK", "JPN", 14_000000, 3000, 80, "tropical", 2);
   }
   */

   /**
    * Create mock city
    * 
    * @return City
    */
   public City getCity(String cityName) {
      
      City city = cityMap.getOrDefault(cityName, null);
      if (city == null) {
         int i = (int) (Math.random() * 1000);
         city = new City(cityName, String.format("Country-%d", i).toString(),
               (int) (Math.random() * 1_000_000), 
               (double) (Math.random() * 10_000), 
               (int) (Math.random() * 100), 
               "tundra",
               (int) (Math.random() * 1000));
         
         cityMap.put(cityName, city);
      }
      
      /*
      
      // introduce sleep to mock network delay
      try {
         Thread.sleep(1);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      */
      return city;

   }

}
