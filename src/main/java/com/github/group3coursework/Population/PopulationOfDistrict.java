package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.District;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class PopulationOfDistrict {

  District generatePopulation(Connection con, String districtName) {
    try {
      Statement stmt = con.createStatement();

      String strSelect = "SELECT city.District, SUM(city.Population) as Population "
          + "FROM city "
          + "WHERE city.District = '" + districtName + "'";

      ResultSet rset = stmt.executeQuery(strSelect);

      District district = new District();

      while (rset.next()) {
        district.setName(rset.getString("city.District"));
        district.setPopulation(rset.getInt("Population"));
      }
      return district;
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("failed to generate District Population report");
      return null;
    }
  }

  void displayDistrict(District district) {
    System.out.println(String.format("%-25s %-25s", "District Name", "Population"));
    String districtString = String.format("%-25s %-25s", district.getName(), district.getPopulation());
    System.out.println(districtString);
  }
}
