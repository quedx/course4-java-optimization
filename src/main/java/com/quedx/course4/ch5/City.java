package com.quedx.course4.ch5;

public class City {

   String name;
   String country;
   int population;
   double averageSalary;
   int averageAge;
   String climate;
   int globalRank;
   public String getName() {
      return name;
   }
   public String getCountry() {
      return country;
   }
   public int getPopulation() {
      return population;
   }
   public double getAverageSalary() {
      return averageSalary;
   }
   public int getAverageAge() {
      return averageAge;
   }
   public String getClimate() {
      return climate;
   }
   public int getGlobalRank() {
      return globalRank;
   }
   public City(String name, String country, int population, double averageSalary, int averageAge, String climate,
         int globalRank) {
      super();
      this.name = name;
      this.country = country;
      this.population = population;
      this.averageSalary = averageSalary;
      this.averageAge = averageAge;
      this.climate = climate;
      this.globalRank = globalRank;
   }
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("City [name=");
      builder.append(name);
      builder.append(", country=");
      builder.append(country);
      builder.append(", population=");
      builder.append(population);
      builder.append(", averageSalary=");
      builder.append(averageSalary);
      builder.append(", averageAge=");
      builder.append(averageAge);
      builder.append(", climate=");
      builder.append(climate);
      builder.append(", globalRank=");
      builder.append(globalRank);
      builder.append("]");
      return builder.toString();
   }

   

}
