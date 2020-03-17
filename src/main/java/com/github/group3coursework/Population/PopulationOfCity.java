package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.City;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PopulationOfCity {
    /**
     * Generates the city with it's population
     * @param con is the connection to the database
     * @return City
     */
    City generateCity(Connection con, String cityName) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.Name, city.Population "
                             + "FROM city "
                             + "WHERE city.Name = '" + cityName + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            rset.next();

            City city = new City();
            city.setName(rset.getString("city.Name"));
            city.setPopulation(rset.getInt("city.Population"));

            return city;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate cities");
            return null;
        }
    }

    /**
     * Displays the population of a given city
     * @param city is the desired city retrieved by the SQL query
     */
    void displayCity(City city) {
        // Print Header
        System.out.println(String.format("%-10s %-10s", "Name", "Population"));
        String cityString = String.format("%-10s %-10s", city.getName(), city.getPopulation() + " People");
        System.out.println(cityString);
    }
}
