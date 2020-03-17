package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PopulationOfCountry {

  Country generatePopulation(Connection con, String countryName) {
    try {
      Statement stmt = con.createStatement();

      String strSelect = "SELECT country.name, SUM(country.Population) as Population "
          + "FROM country "
          + "WHERE country.name = '" + countryName + "'";

      ResultSet rset = stmt.executeQuery(strSelect);

      Country country = new Country();

      while (rset.next()) {
        country.setName(rset.getString("country.Name"));
        country.setPopulation(rset.getInt("Population"));
      }
      return country;
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to generate Country Population Report");
      return null;
    }
  }

  void displayCountry(Country country) {
    System.out.println(String.format("%-25s %-25s", "Country", "Population"));
    if(country == null){
      System.out.println("There is no country.");
    }else{
      String countryString = String.format("%-25s %-25s", country.getName(), country.getPopulation());
      System.out.println(countryString);
    }
  }
}
