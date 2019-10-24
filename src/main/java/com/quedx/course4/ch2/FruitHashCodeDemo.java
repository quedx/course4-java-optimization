package com.quedx.course4.ch2;

import java.util.HashSet;

public class FruitHashCodeDemo {
   public static void main(String[] args) {
      HashSet fruitSet = new HashSet(8);

      fruitSet.add(new Fruit("plum"));
      fruitSet.add(new Fruit("apple"));
      fruitSet.add(new Fruit("fig"));
      fruitSet.add(new Fruit("berry"));
      fruitSet.add(new Fruit("kiwi"));

      boolean b = fruitSet.contains(new Fruit("figg"));
      System.out.println(b);

   }
}

class Fruit {
   private final String name;
   private int hashCode_ = -1;

   public String getName() {
      return name;
   }

   public Fruit(String name) {
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
      this.hashCode_ = prime * result + ((name == null) ? 0 : name.hashCode());
      System.out.println("Hashcode for " + this.name + " ---> " + this.hashCode_);
      System.out.println("Hashcode for " + this.name + " ---> " + (this.hashCode_ & (8 - 1)));
      return this.hashCode_;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Fruit other = (Fruit) obj;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

}