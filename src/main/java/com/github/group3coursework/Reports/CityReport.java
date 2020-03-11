package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.City;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class CityReport {

    /**
     * Generates the City Report
     * @param con is the connection to the database
     * @return ArrayList
     */
    ArrayList<City> generateReport(Connection con) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Name ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City Report");
            return null;
        }
    }

    /**
     * Displays the City Report
     * @param cities is an ArrayList that contains cities retrieved by the SQL query
     */
    void displayReport(ArrayList<City> cities) {
        // Print Header
        System.out.println(String.format("%-35s %-35s %-35s %-35s", "Name", "Country", "District", "Population"));

        // Loop through the cities ArrayList and format all entries
        for (City city : cities) {
            String cityString = String.format("%-35s %-35s %-35s %-35s", city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
            System.out.println(cityString);
        }
    }
}
