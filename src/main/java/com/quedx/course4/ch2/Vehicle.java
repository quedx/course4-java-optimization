package com.quedx.course4.ch2;

import java.util.UUID;

public class Vehicle {
   private final String make;
   private final String model;
   private final String vin;
   private final String engine;
   private int hashCode_;

   public Vehicle(String make, String model, String engine) {
      super();
      this.make = make;
      this.model = model;
      
      this.vin = UUID.randomUUID().toString();
      this.engine = engine;
      this.hashCode_ = -1;
   }

   public String getMake() {
      return make;
   }

   public String getModel() {
      return model;
   }

   public String getVin() {
      return vin;
   }

   public String getEngine() {
      return engine;
   }

   public Vehicle changeEngine(String newEngine) {
      return new Vehicle(this.make, this.model, newEngine);
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Vehicle [make=");
      builder.append(make);
      builder.append(", model=");
      builder.append(model);
      builder.append(", vin=");
      builder.append(vin);
      builder.append(", engine=");
      builder.append(engine);
      builder.append("]");
      return builder.toString();
   }

   @Override
   public int hashCode() {
      if (this.hashCode_ != -1)
         return this.hashCode_;
      
      final int prime = 31;
      int result = 1;
      result = prime * result + ((engine == null) ? 0 : engine.hashCode());
      result = prime * result + ((make == null) ? 0 : make.hashCode());
      result = prime * result + ((model == null) ? 0 : model.hashCode());
      result = prime * result + ((vin == null) ? 0 : vin.hashCode());
      
      this.hashCode_ = result;
      
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
      Vehicle other = (Vehicle) obj;
      if (engine == null) {
         if (other.engine != null)
            return false;
      } else if (!engine.equals(other.engine))
         return false;
      if (make == null) {
         if (other.make != null)
            return false;
      } else if (!make.equals(other.make))
         return false;
      if (model == null) {
         if (other.model != null)
            return false;
      } else if (!model.equals(other.model))
         return false;
      if (vin == null) {
         if (other.vin != null)
            return false;
      } else if (!vin.equals(other.vin))
         return false;
      return true;
   }



   
   
}