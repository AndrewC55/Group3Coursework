package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestCountryReport {
    static CountryReport countryReport;

    @BeforeAll
    static void init() {
        countryReport = new CountryReport();
    }

    @Test
    void testFailToGenerateReportWhenNoConnectionIsGiven() {
        ArrayList<Country> cityList = countryReport.generateReport(null );
        assertNull(cityList);
    }

    @Test
    void testPassGenerateReportWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            ArrayList<Country> countryList = countryReport.generateReport(con);
            assertNotEquals(null, countryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayReportWhenNull() {
        countryReport.displayReport(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<Country> countryList = new ArrayList<>();
        countryReport.displayReport(countryList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(null);
        countryReport.displayReport(countryList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<Country> countryList = new ArrayList<>();
        Country country = new Country();
        country.setName("Scotland");
        country.setCapitalCity("Edinburgh");
        country.setContinent("Europe");
        country.setRegion("British Islands");
        country.setPopulation(450180);
        countryList.add(country);
        countryReport.displayReport(countryList);
    }
}
