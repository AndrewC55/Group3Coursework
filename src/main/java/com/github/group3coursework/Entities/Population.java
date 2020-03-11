package com.github.group3coursework.Entities;

public class Population {

    /**
     * Name of the continent/region/country
     */
    private String name;

    /**
     * Area of population
     */
    private String area;

    /**
     * Area's population
     */
    private long totalPopulation;

    /**
     * Urban Population
     */
    private long populationUrban;

    /**
     * Rural Population
     */
    private long populationRural;

    /**
     * Getter function for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter function for name
     * @param name is the name of the region/country/continent
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter function for area
     * @return String area
     */
    public String getArea() {
        return area;
    }

    /**
     * Setter function for area
     * @param area is the area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Getter function for total population
     * @return long totalPopulation
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * Setter function for total population
     * @param totalPopulation is the total population
     */
    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    /**
     * Getter function for urban population
     * @return long populationUrban
     */
    public long getPopulationUrban() {
        return populationUrban;
    }

    /**
     * Setter function for urban population
     * @param populationUrban is the urban population
     */
    public void setPopulationUrban(long populationUrban) {
        this.populationUrban = populationUrban;
    }

    /**
     * Getter function for rural population
     * @return long populationRural
     */
    public long getPopulationRural() {
        return populationRural;
    }

    /**
     * Setter function for rural population
     * @param populationRural is the rural population
     */
    public void setPopulationRural(long populationRural) {
        this.populationRural = populationRural;
    }
}
