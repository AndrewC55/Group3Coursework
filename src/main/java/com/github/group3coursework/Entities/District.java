package com.github.group3coursework.Entities;

public class District {
  private String name;
  private String city;
  private String country;
  private int population;

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public int getPopulation() {
    return population;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setPopulation(int population) {
    this.population = population;
  }
}
