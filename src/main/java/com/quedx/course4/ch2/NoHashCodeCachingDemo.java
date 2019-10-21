package com.quedx.course4.ch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.quedx.course4.common.Util;

public class NoHashCodeCachingDemo {

   HashMap<MutableVehicle, String> ownerShipRegistry;
   List<MutableVehicle> vehicleList;

   public MutableVehicle createHondaVechile() {
      return new MutableVehicle("Honda", "Accord", "V6");
   }

   public MutableVehicle createBWMVechile() {
      return new MutableVehicle("BMW", "Series 6", "V8");
   }

   public MutableVehicle createToyotaVechile() {
      return new MutableVehicle("Tyt", "Camry", "V6");
   }

   public void addMutableVehicles(int count) {
      ownerShipRegistry = new HashMap();
      vehicleList = new ArrayList(count);

      for (int i = 0; i < count; ++i) {
         MutableVehicle v = createBWMVechile();
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
      for (MutableVehicle v : vehicleList) {
         ownerShipRegistry.get(v);
         if (v == null) {
            Util.getLogger().info("not found");
         }
      }
   }

   public static void main(String[] args) {
      NoHashCodeCachingDemo obj = new NoHashCodeCachingDemo();
      obj.addMutableVehicles(1000000);

      Long duration = Util.getExecutionTime(obj, "search");

      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
      Util.getLogger().info("search() execution time : " + Util.nanoToMs(duration));
   }

}
