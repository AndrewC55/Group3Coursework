package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.Continent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class PopulationOfContinent {

    /**
     * Generates the continent with it's population
     * @param con is the connection to the database
     * @return Continent
     */
    Continent generatePopulation(Connection con, String continentName) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Continent, SUM(country.Population) as Population "
                    + "FROM country "
                    + "WHERE country.Continent = '" + continentName + "'";

            ResultSet rset = stmt.executeQuery(strSelect);

            Continent continent = new Continent();

            while (rset.next()) {
                continent.setName(rset.getString("country.Continent"));
                continent.setPopulation(rset.getInt("Population"));
            }
            return continent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("failed to generate Continent Population Report");
            return null;
        }
    }

    /**
     * Displays the population of a given continent
     * @param continent is the desired continent retrieved by the SQL query
     */
    void displayContinent(Continent continent) {
        System.out.println(String.format("%-10s %-10s", "Name", "Population"));
        String continentString = String.format("%-10s %-10s", continent.getName(), continent.getPopulation());
        System.out.println(continentString);
    }
}
