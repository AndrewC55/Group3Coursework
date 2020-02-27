package com.github.group3coursework;

/**
 * Represents a city
 */
class City {

    /**
     * City's name
     */
    private String name;

    /**
     * City's country
     */
    private String country;

    /**
     * City's district
     */
    private String district;

    /**
     * City's population
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
     * @param name city's name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param country city's country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter function for district
     * @return String district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Setter function for district
     * @param district city's district
     */
    public void setDistrict(String district) {
        this.district = district;
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
     * @param population city's population
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
