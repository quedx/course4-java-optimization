package com.quedx.course4.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

   /**
    * Get current date
    * 
    * @return
    */
   public static String currentDate() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Calendar cal = Calendar.getInstance();
      return dateFormat.format(cal.getTime());
   }
   
   
   // Main
   public static void main(String[] args) {
      System.out.println(DateUtil.currentDate());
   }
}
