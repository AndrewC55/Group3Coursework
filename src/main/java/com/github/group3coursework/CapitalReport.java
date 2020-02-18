package com.github.group3coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CapitalReport {

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
        capital.name = rset.getString("city.Name");
        capital.country = rset.getString("country.Name");
        capital.population = rset.getInt("city.population");
        capitals.add(capital);
      }
      return capitals;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to generate Capital Report");
      return null;
    }
  }

  void displayReport(ArrayList<Capital> capitals) {
    // Print Header
    System.out.println(String.format("%-35s %-35s %-35s", "Name", "Country", "Population"));

    // Loop through the capitals ArrayList and format all entries
    for (Capital capital : capitals) {
      String capitalString = String
          .format("%-35s %-35s %-35s", capital.name, capital.country, capital.population);
      System.out.println(capitalString);
    }
  }
}
