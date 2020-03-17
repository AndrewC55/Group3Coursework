package com.github.group3coursework.Entities;

/**
 * Represent's a Continent
 */
public class Continent {

    /**
     * Continent's name
     */
    private String name;

    /**
     * Continent's countries
     */
    private String[] countries;

    /**
     * Continent's population
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
     * Setter function for name
     * @param name is the name of the continent
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter function for countries
     * @return String[] countries
     */
    public String[] getCountries() {
        return countries;
    }

    /**
     * Setter function for countries
     * @param countries is the countries that are in the continent
     */
    public void setCountries(String[] countries) {
        this.countries = countries;
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
     * @param population is the population of the continent
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
