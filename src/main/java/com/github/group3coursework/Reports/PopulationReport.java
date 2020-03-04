package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Population;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class PopulationReport {
    ArrayList<Population> generateReport(Connection con, String type) {
        ArrayList<Population> populationList = new ArrayList<>();

        switch (type) {
            case "continent":
                //Try Creating continent report.
                try {
                    // Create an SQL statement
                    Statement stmtTotal = con.createStatement();
                    Statement stmtCity = con.createStatement();


                    //SQL for Total populationList
                    String strSelectTotal = "SELECT country.continent, SUM(country.population) as TotalPop "
                            + "FROM country "
                            + "GROUP BY country.continent ";

                    //SQL for Urban populationList
                    String strSelectCity = "SELECT country.Continent, SUM(city.Population) as CityPop "
                            + "FROM city INNER JOIN country on country.Code = city.countryCode "
                            + "GROUP BY country.continent ";

                    //Execute SQL
                    ResultSet rsetTotal = stmtTotal.executeQuery(strSelectTotal);
                    ResultSet rsetCity = stmtCity.executeQuery(strSelectCity);


                    while (rsetTotal.next() && rsetCity.next()) {
                        Population population = new Population();
                        population.setArea(rsetTotal.getString("country.continent"));
                        population.setTotalPopulation(rsetTotal.getLong("TotalPop"));
                        population.setPopulationUrban(rsetCity.getLong("CityPop"));
                        population.setPopulationRural(population.getTotalPopulation() - population.getPopulationUrban());
                        populationList.add(population);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to generate Population Report");
                    return null;
                }
            case "country":
                break;
            case "region":
                break;
                default: System.out.println("This is a default message");
        }
        return populationList;
    }


    public void displayReport(ArrayList<Population> Population) {
        // Print country report headers
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "Area", "Total Population", "Total Population Living In Cities", "Total Population Not Living In Cities"));

        // Loop through the countries ArrayList and format all entries
        for (Population population : Population) {
            Double CitiesPercent = (double) ((population.getPopulationUrban() / population.getTotalPopulation()) * 100);
            Double RuralPercent = (double) ((population.getPopulationRural() / population.getTotalPopulation()) * 100);
            String populationList = String.format("%-30s %-30s %-30s %-30s", population.getArea(), population.getTotalPopulation(), population.getPopulationUrban() + " %" + CitiesPercent, population.getPopulationRural() + " %" + RuralPercent);
            System.out.println(populationList);
        }
    }
}

