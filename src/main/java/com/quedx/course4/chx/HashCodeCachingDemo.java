package com.quedx.course4.chx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.quedx.course4.common.Util;

public class HashCodeCachingDemo {

   HashMap<Vehicle, String> ownerShipRegistry;
   List<Vehicle> vehicleList;

   public Vehicle createHondaVechile() {
      return new Vehicle("Honda", "Accord", "V6");
   }

   public Vehicle createBWMVechile() {
      return new Vehicle("BMW", "Series 6", "V8");
   }

   public Vehicle createToyotaVechile() {
      return new Vehicle("Tyt", "Camry", "V6");
   }

   public void addVehicles(int count) {
      ownerShipRegistry = new HashMap();
      vehicleList = new ArrayList(count);

      for (int i = 0; i < count; ++i) {
         Vehicle v = createBWMVechile();
         ownerShipRegistry.put(v, Util.getRandomString("S", 4));
         vehicleList.add(v);
         v = createHondaVechile();
         ownerShipRegistry.put(v, Util.getRandomString("H", 4));
         vehicleList.add(v);
         v = createToyotaVechile();
         ownerShipRegistry.put(v, Util.getRandomString("T", 4));
         vehicleList.add(v);

      }

      Util.getLogger().info("ownerShipRegistry contains " + ownerShipRegistry.size());
      Util.getLogger().info("vinRegistryList contains " + vehicleList.size());
   }

   public void search() {
      for (Vehicle v : vehicleList) {
         ownerShipRegistry.get(v);
         if (v == null) {
            Util.getLogger().info("not found");
         }
      }
   }

   public static void main(String[] args) {
      HashCodeCachingDemo obj = new HashCodeCachingDemo();
      obj.addVehicles(1000000);

      Long duration = Util.getExecutionTime(obj, "search");

      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
   }

}
