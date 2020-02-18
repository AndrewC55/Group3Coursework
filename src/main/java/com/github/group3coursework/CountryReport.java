package com.github.group3coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class CountryReport {
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
        country.name = rset.getString("country.Name");
        country.region = rset.getString("country.Region");
        country.population = rset.getInt("country.Population");
        country.capitalCity = rset.getString("city.Name");
        country.continent = rset.getString("country.Continent");
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

  void displayReport(ArrayList<Country> countries) {
    // Print country report headers
    System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s", "Name", "Region", "Population", "Capital City", "Continent"));

    // Loop through the countries ArrayList and format all entries
    for (Country country : countries) {
      String countryString = String.format("%-30s %-30s %-30s %-30s %-30s", country.name, country.region, country.population, country.capitalCity, country.continent);
      System.out.println(countryString);
    }
  }
}