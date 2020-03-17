package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class CountryReport {

    /**
     * Generates the Country Report
     * @param con is the connection to the database
     * @return ArrayList
     */
    ArrayList<Country> generateReport(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Name, country.Region, country.Population, city.Name, country.Continent "
                    + "FROM country, city "
                    + "WHERE country.Capital = city.ID "
                    + "ORDER BY country.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.setName(rset.getString("country.Name"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapitalCity(rset.getString("city.Name"));
                country.setContinent(rset.getString("country.Continent"));
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate Country Report");
            return null;
        }
    }

    /**
     * Displays the Country Report
     * @param countries is an ArrayList that contains countries retrieved by the SQL query
     */
    void displayReport(ArrayList<Country> countries) {
        if (countries == null) {
            System.out.println("No countries");
            return;
        }

        // Print country report headers
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s", "Name", "Region", "Population", "Capital City", "Continent"));

        // Loop through the countries ArrayList and format all entries
        for (Country country : countries) {
            if (country == null) {
                continue;
            }

            String countryString = String.format("%-30s %-30s %-30s %-30s %-30s", country.getName(), country.getRegion(), country.getPopulation(), country.getCapitalCity(), country.getContinent());
            System.out.println(countryString);
        }
    }
}
