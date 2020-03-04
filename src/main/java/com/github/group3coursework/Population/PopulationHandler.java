package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.City;
import java.sql.Connection;

/**
 * This is a handler that the main will call
 * This is used to determine which population query the user would like to view
 * This will be used for github issues 26 - 31
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
                // TODO implement feature for region
                break;
            case "Continent":
                // TODO implement feature for continent
                break;
            case "World":
                // TODO implement feature for world
                break;
            default:
                break;
        }
    }
}
