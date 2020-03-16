package com.github.group3coursework.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PopulationOfRegion {
    /**
     * @param con is the connection to the database
     * @return long
     */
    long generateRegion(Connection con, String countryDistrict) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) as regionPopulation "
                    + "FROM city "
                    + "WHERE city.District = '" + countryDistrict + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            rset.next();

            return rset.getLong("regionPopulation");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate region population");
            return 0;
        }
    }

    /**
     * Displays the region population
     * @param regionPopulation is the regionPopulation retrieved by the SQL query
     */
    void displayRegion(Long regionPopulation) {
        System.out.println("Region Population");
        if (regionPopulation == null) {
            System.out.println("No Region population");
        }else{
            System.out.println(regionPopulation + " People");
        }
    }
}
