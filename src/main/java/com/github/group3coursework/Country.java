package com.github.group3coursework;

/**
 * Represent's a country
 */
class Country {

  /**
   * Country's name
   */
  private String name;

  /**
   * Country's continent
   */
  private String continent;

  /**
   * Country's region
   */
  private String region;

  /**
   * Country's population
   */
  private int population;

  /**
   * Country's capital city
   */
  private String capitalCity;

  /**
   * Getter function for name
   * @return String name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter function for name
   * @param name country's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter function for continent
   * @return String continent
   */
  public String getContinent() {
    return continent;
  }

  /**
   * Setter function for continent
   * @param continent country's continent
   */
  public void setContinent(String continent) {
    this.continent = continent;
  }

  /**
   * Getter function for region
   * @return String region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Setter function for region
   * @param region country's region
   */
  public void setRegion(String region) {
    this.region = region;
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
   * @param population country's population
   */
  public void setPopulation(int population) {
    this.population = population;
  }

  /**
   * Getter function for capital city
   * @return String capitalCity
   */
  public String getCapitalCity() {
    return capitalCity;
  }

  /**
   * Setter function for capital city
   * @param capitalCity country's capital city
   */
  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }
}
