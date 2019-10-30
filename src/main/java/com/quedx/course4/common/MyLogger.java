package com.quedx.course4.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

   private Logger getLogger(Class classArg) {
      return LoggerFactory.getLogger(classArg);
   }

   public void info(Object x, String format, Object... args) {
      getLogger(x.getClass()).info(format, args);

   }

}
