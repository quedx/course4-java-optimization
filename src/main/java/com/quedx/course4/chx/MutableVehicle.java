package com.quedx.course4.chx;

import java.util.UUID;

public class MutableVehicle {
   private String make;
   private String model;
   private String vin;
   private String engine;

   public MutableVehicle(String make, String model, String engine) {
      super();
      this.make = make;
      this.model = model;

      this.vin = UUID.randomUUID().toString();
      this.engine = engine;
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

   public void setMake(String make) {
      this.make = make;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public void setVin(String vin) {
      this.vin = vin;
   }

   public void setEngine(String engine) {
      this.engine = engine;
   }

   public MutableVehicle changeEngine(String newEngine) {
      return new MutableVehicle(this.make, this.model, newEngine);
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
      final int prime = 31;
      int result = 1;
      result = prime * result + ((engine == null) ? 0 : engine.hashCode());
      result = prime * result + ((make == null) ? 0 : make.hashCode());
      result = prime * result + ((model == null) ? 0 : model.hashCode());
      result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
      MutableVehicle other = (MutableVehicle) obj;
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