package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.City;
import com.github.group3coursework.Entities.Continent;
import java.sql.Connection;

/**
 * This is a handler that the main will call
 * This is used to determine which population query the user would like to view
 * This will be used for github issues 32 - 37
 */
public class PopulationHandler {

    /**
     * TODO implement other population types
     * Used to select the population type
     * and name of the city/country/region/etc
     * @param populationType is the country/city/region/etc
     * @param con is connection to the database
     */
    public void populationSelector(String populationType, Connection con) {
        switch (populationType) {
            case "City":
                PopulationOfCity populationOfCity = new PopulationOfCity();
                City city = populationOfCity.generateCity(con, "Edinburgh");
                populationOfCity.displayCity(city);
                break;
            case "District":
                // TODO implement feature for district
                break;
            case "Country":
                // TODO implement feature for country
                break;
            case "Region":
                PopulationOfRegion populationOfRegion = new PopulationOfRegion();
                long regionPopulation = populationOfRegion.generateRegion(con, "Abu Dhabi");
                populationOfRegion.displayRegion(regionPopulation);
                break;
            case "World":
                PopulationOfWorld populationOfWorld = new PopulationOfWorld();
                long worldPopulation = populationOfWorld.generateWorld(con);
                populationOfWorld.displayWorld(worldPopulation);
                break;
            case "Continent":
                PopulationOfContinent populationOfContinent = new PopulationOfContinent();
                Continent continentPopulation = populationOfContinent.generatePopulation(con, "Oceania");
                populationOfContinent.displayContinent(continentPopulation);
                break;
            default:
        }
    }
}
