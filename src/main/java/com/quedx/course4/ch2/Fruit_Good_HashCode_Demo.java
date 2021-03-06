package com.quedx.course4.ch2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.quedx.course4.common.Util;

public class Fruit_Good_HashCode_Demo {
   HashSet<Fruit3> fruitSet = new HashSet();

   // add elements to fruitSet
   public void addElements(Integer elementCount) {
      for (int i = 0; i < elementCount; ++i) {
         fruitSet.add(new Fruit3(String.format("%s-%d", "fruit", i)));
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
      fruitSet.clear();
   }

   public static void verify() {
      Fruit_Good_HashCode_Demo demo = new Fruit_Good_HashCode_Demo();
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
      Fruit_Good_HashCode_Demo.verify();
   }
}

class Fruit3 {
   private final String name;

   public String getName() {
      return name;
   }

   public Fruit3(String name) {
      super();
      this.name = name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Fruit3 other = (Fruit3) obj;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

}