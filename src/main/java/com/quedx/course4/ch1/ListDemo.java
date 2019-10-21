package com.quedx.course4.ch1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.quedx.course4.common.Util;

public class ListDemo {

   String listName;
   List<Integer> list;

   ListDemo(String listName, List<Integer> intList) {
      this.listName = listName;
      this.list = intList;
   }

   /**
    * Adds element to specified list
    * 
    * @param destList
    * @param numElements
    */
   public void addElements(Integer elementCount) {

      if (list == null) {
         throw new RuntimeException("List is null");
      }

      for (int i = 0; i < elementCount; ++i) {
         this.list.add(i);
      }
   }

   /**
    * Get elements
    */
   public void getElements() {
      for (int i = 0; i < list.size(); ++i) {
         this.list.get(i);
      }
   }

   /**
    * Iterate elements
    * 
    * @param elementCount
    */
   public void iterateElements() {
      Iterator<Integer> itr = list.iterator();

      while (itr.hasNext()) {
         itr.next();

      }
   }

   /**
    * verifyAddElements
    */
   public static void verify() {
      int elements = 100000;
      long duration;
      List<String> executionTimeList = new ArrayList();

      ListDemo arrayListDemo = new ListDemo("ArrayList", new ArrayList<Integer>());
      ListDemo arrayListFixedDemo = new ListDemo("ArrayList Fixed", new ArrayList<Integer>(elements));
      ListDemo linkedListDemo = new ListDemo("LinkedList", new LinkedList<Integer>());
      ListDemo copyOnWriteArrayListDemo = new ListDemo("CopyOnWriteArrayList", new CopyOnWriteArrayList<Integer>());

      // --------------------------------------------
      String methodName = "addElements";
      duration = Util.getExecutionTime(arrayListDemo, methodName, elements);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(arrayListFixedDemo, methodName, elements);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList fixed", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(linkedListDemo, methodName, elements);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "LinkedList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(copyOnWriteArrayListDemo, methodName, elements);
      executionTimeList
            .add(String.format("%15s %25s  %10.6f", methodName, "CopyOnWriteArrayList", Util.nanoToMs(duration)));

      // --------------------------------------------
      methodName = "getElements";
      duration = Util.getExecutionTime(arrayListDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(arrayListFixedDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList fixed", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(linkedListDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "LinkedList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(copyOnWriteArrayListDemo, methodName);
      executionTimeList
            .add(String.format("%15s %25s  %10.6f", methodName, "CopyOnWriteArrayList", Util.nanoToMs(duration)));

      // --------------------------------------------
      methodName = "iterateElements";
      duration = Util.getExecutionTime(arrayListDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(arrayListFixedDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "ArrayList fixed", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(linkedListDemo, methodName);
      executionTimeList.add(String.format("%15s %25s  %10.6f", methodName, "LinkedList", Util.nanoToMs(duration)));

      duration = Util.getExecutionTime(copyOnWriteArrayListDemo, methodName);
      executionTimeList
            .add(String.format("%15s %25s  %10.6f", methodName, "CopyOnWriteArrayList", Util.nanoToMs(duration)));

      for (String s : executionTimeList) {
         Util.getLogger().info(s);
      }

   }

   /**
    * Main
    * 
    * @param args
    */
   public static void main(String[] args) {
      ListDemo.verify();

   }

}
