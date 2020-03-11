package com.github.group3coursework.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PopulationOfWorld {
    /**
     * @param con is the connection to the database
     * @return long
     */
    long generateWorld(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) as countryPopulation "
                    + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            rset.next();

            return rset.getLong("countryPopulation");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate world population");
            return 0;
        }
    }

    /**
     * Displays the world population
     * @param worldPopulation is the worldPopulation retrieved by the SQL query
     */
    void displayWorld(long worldPopulation) {
        System.out.println("World Population");
        System.out.println(worldPopulation + " People");
    }
}
