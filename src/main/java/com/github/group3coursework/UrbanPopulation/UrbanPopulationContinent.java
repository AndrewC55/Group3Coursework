package com.github.group3coursework.UrbanPopulation;

import com.github.group3coursework.Entities.Population;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class UrbanPopulationContinent {
    /**
     * Generates the cities with their population Report
     * @param con is the connection to the database
     * @return City
     */
    ArrayList<Population> generateUrbanPopulationContinent(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.Continent AS continent, "
                    + "SUM(CASE WHEN country.Continent = continent THEN city.Population ELSE 0 END) AS Urban Population, "
                    + "(SUM(CASE WHEN country.Continent = continent THEN country.Population ELSE 0 END) - Urban Population)AS Rural Population, "
                    + "FROM city, country "
                    + "WHERE city.CountryCode = country.Code ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Population> populationList = new ArrayList<>();

            while (rset.next()) {
                Population population = new Population();
                population.setName(rset.getString(""));
                population.setPopulationUrban(rset.getLong("city.Name"));
                population.setPopulationRural(rset.getLong("city.Population"));
                populationList.add(population);
            }

            return populationList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate urban/rural population for continents");
            return null;
        }
    }

    /**
     * Displays the population of the urban/rural population of each continent
     * @param populationList is the list of urban/rural populations of each continent
     */
    void displayUrbanPopulationContinent(ArrayList<Population> populationList) {
        // Print Header
        System.out.println(String.format("%-35s %-35s %-35s", "Name", "Urban Population", "Rural Population"));

        // Loop through the continent ArrayList and format all entries
        for (Population population : populationList) {
            String continentString = String.format("%-10s %-10s %-35s", population.getName(), population.getPopulationUrban(), population.getPopulationRural());
            System.out.println(continentString);
        }
    }
}
