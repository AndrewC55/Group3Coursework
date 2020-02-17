package com.github.group3coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CountryReport {

  ArrayList<Country> generateReport(Connection con) {
    try {
      // Create an SQL statement
      Statement stmt = con.createStatement();

      String strSelect = "SELECT country.name as Country, country.region as Region,"
          + " country.population as Population,"
          + "country.capital as Capital, country.continent as Continent"
          + "FROM country "
          + "ORDER BY city.population";

      ResultSet rset = stmt.executeQuery(strSelect);

      ArrayList<Country> countries = new ArrayList<>();
      while (rset.next()) {
        Country country = new Country();
        country.countryName = rset.getString("country.name");
        country.continent = rset.getString("country.continent");
        country.region = rset.getString("country.region");
        country.population = rset.getInt("country.population");
        country.capitalCity = rset.getString("country.capital");
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

  void displayReport(ArrayList<Country> countries) {
    // Print Header
    System.out.println(String.format("%-10s %-10s %-10s %-10s", "Name", "Continent", "Region", "Population", "Capital City"));

    // Loop through the cities ArrayList and format all entries
    for (Country country : countries) {
      String countryString = String.format("%-10s %-10s %-10s %-10s", country.countryName, country.capitalCity, country.continent, country.population, country.region);
      System.out.println(countryString);
    }
  }
}
