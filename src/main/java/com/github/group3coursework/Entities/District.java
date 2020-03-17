package com.github.group3coursework.Entities;

/**
 * Represent's a district
 */
public class District {

    /**
     * District's name
     */
    private String name;

    /**
     * District's city
     */
    private String city;

    /**
     * District's country
     */
    private String country;

    /**
     * District's population
     */
    private int population;

    /**
     * Getter function for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter function for city
     * @return String city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter function for country
     * @return String country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter function for population
     * @return int population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Setter function for name
     * @param name is the name of the district
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter function for city
     * @param city is the city of the district
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Setter function for country
     * @param country is the country of the district
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Setter function for population
     * @param population is the population of the district
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
