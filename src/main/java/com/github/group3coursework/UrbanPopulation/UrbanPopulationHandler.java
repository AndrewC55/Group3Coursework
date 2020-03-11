package com.github.group3coursework.UrbanPopulation;

import com.github.group3coursework.Entities.Population;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * This is a handler that the main will call
 * This is used to determine which urban population query the user would like to view
 * This will be used for github issues 29 - 31
 */
public class UrbanPopulationHandler {

    /**
     * TODO implement other urban population types
     * Used to select the urban population type
     * @param populationType is the country/city/region/etc
     * @param con is connection to the database
     */
    public void urbanPopulationHandler(String populationType, Connection con) {
        switch (populationType) {
            case "Country":
                // TODO add urbanPopulation issue for country
                break;
            case "Region":
                // TODO add urbanPoulation issue for Region
                break;
            case "Continent":
                UrbanPopulationContinent urbanPopulationContinent = new UrbanPopulationContinent();
                ArrayList<Population> urbanPopulationContinentList = urbanPopulationContinent.generateUrbanPopulationContinent(con);
                urbanPopulationContinent.displayUrbanPopulationContinent(urbanPopulationContinentList);
                break;
            default:
                break;
        }
    }
}
