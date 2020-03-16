package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.Continent;
import com.github.group3coursework.Entities.Country;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

class PopulationOfContinent {

  Continent generatePopulation(Connection con, String continentName) {
    try {
      Statement stmt = con.createStatement();

      String strSelect = "SELECT country.Continent, SUM(country.Population) as Population "
          + "FROM country "
          + "WHERE country.Continent = '" + continentName + "'";

      ResultSet rset = stmt.executeQuery(strSelect);

      Continent continent = new Continent();

      while (rset.next()) {
        continent.setName(rset.getString("country.Continent"));
        continent.setPopulation(rset.getInt("Population"));
      }
      return continent;
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("failed to generate Country Report");
      return null;
    }
  }

  void displayContinent(Continent continent) {
    System.out.println(String.format("%-10s %-10s", "Name", "Population"));
    String continentString = String.format("%-10s %-10s", continent.getName(), continent.getPopulation());
    System.out.println(continentString);
  }
}
