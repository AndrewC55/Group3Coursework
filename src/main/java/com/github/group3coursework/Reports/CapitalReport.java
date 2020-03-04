package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Capital;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class CapitalReport {

    /**
     * Generates the Capital Report
     * @param con is the connection to the database
     * @return ArrayList
     */
    ArrayList<Capital> generateReport(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Capital information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                Capital capital = new Capital();
                capital.setName(rset.getString("city.Name"));
                capital.setCountry(rset.getString("country.Name"));
                capital.setPopulation(rset.getInt("city.population"));
                capitals.add(capital);
            }
            return capitals;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate Capital Report");
            return null;
        }
    }

    /**
     * Displays the Capital Report
     *
     * @param capitals is an ArrayList that contains capitals retrieved by the SQL query
     */
    void displayReport(ArrayList<Capital> capitals) {
        // Print Header
        System.out.println(String.format("%-35s %-35s %-35s", "Name", "Country", "Population"));

        // Loop through the capitals ArrayList and format all entries
        for (Capital capital : capitals) {
            String capitalString = String
                    .format("%-35s %-35s %-35s", capital.getName(), capital.getCountry(), capital.getPopulation());
            System.out.println(capitalString);
        }
    }
}
