package com.quedx.course4.ch2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.quedx.course4.common.Util;

public class Fruit_HashCode_Cahced_Demo {
   HashSet<Fruit4> fruitSet = new HashSet();

   // add elements to fruitSet
   public void addElements(Integer elementCount) {
      for (int i = 0; i < elementCount; ++i) {
         fruitSet.add(new Fruit4(String.format("%s-%d", "fruit", i)));
      }
   }

   // add elements to fruitSet
   public void searchElements() {
      Util.getLogger().info("set contains : " + fruitSet.size() + " elements");
      fruitSet.stream().forEach( fruit -> {
         boolean b = fruitSet.contains(fruit);
      });
         
   }

   public void clear() {
      fruitSet = new HashSet();
   }

   public static void verify() {
      Fruit_HashCode_Cahced_Demo demo = new Fruit_HashCode_Cahced_Demo();
      List<String> resultList = new ArrayList(10);

      int elementCount;
      demo.clear();
      String methodName;
      Long duration;

      elementCount = 10_000;
      methodName = "addElements";
      duration = Util.getExecutionTime(demo, methodName, elementCount);
      resultList.add(String.format("%15s %d elements - %10.6f ms", methodName, elementCount, Util.nanoToMs(duration)));

      methodName = "searchElements";
      duration = Util.getExecutionTime(demo, methodName);
      resultList.add(String.format("%15s %d elements - %10.6f ms", methodName, elementCount, Util.nanoToMs(duration)));

      for (String s : resultList) {
         Util.getLogger().info(s);
      }

   }

   public static void main(String[] args) {
      Fruit_HashCode_Cahced_Demo.verify();
   }
}

class Fruit4 {
   private final String name;
   private int hashCode_ = -1;

   public String getName() {
      return name;
   }

   public Fruit4(String name) {
      super();
      this.name = name;
   }

   @Override
   public int hashCode() {
      if (hashCode_ != -1) {
         return hashCode_;
      }
      final int prime = 31;
      int result = 1;
      hashCode_ = prime * result + ((name == null) ? 0 : name.hashCode());
      return hashCode_;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Fruit4 other = (Fruit4) obj;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

}