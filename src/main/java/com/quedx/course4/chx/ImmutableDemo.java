package com.quedx.course4.chx;

import com.quedx.course4.common.Util;

public class ImmutableDemo {

   // Main
   public static void main(String[] args) {

      Vehicle v1 = new Vehicle("honda", "accord v7", "V4-automatic");
      Util.getLogger().info("v1 = " + v1);
      Vehicle v2 = v1.changeEngine("v7-manaul");
      Util.getLogger().info("v1 = " + v1);
      Util.getLogger().info("v2 = " + v2);
      
      
   }

}

