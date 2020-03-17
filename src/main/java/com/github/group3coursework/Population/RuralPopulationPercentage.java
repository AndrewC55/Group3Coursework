package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.Country;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

class RuralPopulationPercentage {

  ArrayList<Country> generatePopulation(Connection con) {
    try {
      Statement stmt = con.createStatement();

      String strSelect = "SELECT country.Name, country.Population, SUM(city.Population), "
          + "(country.Population - SUM(city.Population)) as RuralPop, "
          + "ROUND((((country.population - sum(city.population)) / country.population)*100)) as Percentage "
          + "FROM country "
          + "JOIN city ON country.code = city.countryCode "
          + "GROUP BY country.code ";

      ResultSet rset = stmt.executeQuery(strSelect);

      ArrayList<Country> countries = new ArrayList<>();

      while (rset.next()) {
        Country country = new Country();
        country.setName(rset.getString("country.Name"));
        country.setPopulation(rset.getInt("country.Population"));
        country.setCityPopulation(rset.getInt("SUM(city.Population)"));
        country.setRuralPopulation(rset.getInt("RuralPop"));
        country.setRuralPercentage(rset.getInt("Percentage"));
        countries.add(country);
      }
      return countries;
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("failed to generate District Population report");
      return null;
    }
  }

  void displayRuralPopulation(ArrayList<Country> countries) {
    System.out.println(String.format("%-35s %-35s %-35s %-35s %-35s", "Country", "Total Population", "City Population", "Rural Population", "Percent living in rural areas"));
    for (Country country : countries) {
      String ruralPopString = String.format("%-35s %-35s %-35s %-35s %-35s", country.getName(), country.getPopulation(), country.getCityPopulation(), country.getRuralPopulation(), country.getRuralPercentage());
      System.out.println(ruralPopString);
    }
  }
}
