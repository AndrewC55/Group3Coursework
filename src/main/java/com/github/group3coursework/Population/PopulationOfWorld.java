package com.github.group3coursework.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PopulationOfWorld {
    /**
     * @param con is the connection to the database
     * @return long
     */
    long generateWorld(Connection con, String cityName) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(country.Population) "
                    + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            rset.next();

            long worldPopulation = rset.getInt("country.Population");

            return worldPopulation;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate cities");
            return Long.parseLong(null);
        }
    }

    /**
     * Displays the world population
     * @param worldPopulation is the desired worldPopulation retrieved by the SQL query
     */
    void displayCity(long worldPopulation) {
        // Print Header
        System.out.println(String.format("%-10s", "World Population"));
        String cityString = String.format("%-10s", worldPopulation);
        System.out.println(cityString);
    }
}
