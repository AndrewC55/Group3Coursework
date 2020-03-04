package com.github.group3coursework.Entities;

/**
 * Represent's a capital city
 */
public class Capital {

  /**
   * Capital's name
   */
  private String name;

  /**
   * Capital's population
   */
  private int population;

  /**
   * Capital's country
   */
  private String country;

  /**
   * Getter function for name
   * @return String name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter function for name
   * @param name capital's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter function for population
   * @return int population
   */
  public int getPopulation() {
    return population;
  }

  /**
   * Setter function for population
   * @param population capital's population
   */
  public void setPopulation(int population) {
    this.population = population;
  }

  /**
   * Getter function for country
   * @return String country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Setter function for country
   * @param country capital's country
   */
  public void setCountry(String country) {
    this.country = country;
  }
}
