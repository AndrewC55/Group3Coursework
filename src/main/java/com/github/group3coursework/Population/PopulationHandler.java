package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.City;
import com.github.group3coursework.Entities.Continent;
import com.github.group3coursework.Entities.Country;
import com.github.group3coursework.Entities.District;
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
                PopulationOfDistrict populationOfDistrict = new PopulationOfDistrict();
                District district = populationOfDistrict.generatePopulation(con, "Utrecht");
                populationOfDistrict.displayDistrict(district);
                break;
            case "Country":
                PopulationOfCountry populationOfCountry = new PopulationOfCountry();
                Country country = populationOfCountry.generatePopulation(con, "Cyprus");
                populationOfCountry.displayCountry(country);
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
                break;
        }
    }
}
