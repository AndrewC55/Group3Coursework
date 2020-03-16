package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestCityReport {

    static CityReport cityReport;

    @BeforeAll
    static void init() {
        cityReport = new CityReport();
    }

    @Test
    void testFailToGenerateReportWhenNoConnectionIsGiven() {
        ArrayList<City> cityList = cityReport.generateReport(null );
        assertNull(cityList);
    }

    @Test
    void testPassGenerateReportWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            ArrayList<City> cityList = cityReport.generateReport(con);
            assertNotEquals(null, cityList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayReportWhenNull() {
        cityReport.displayReport(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<City> cityList = new ArrayList<>();
        cityReport.displayReport(cityList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(null);
        cityReport.displayReport(cityList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<City> cityList = new ArrayList<>();
        City city = new City();
        city.setName("Edinburgh");
        city.setCountry("Scotland");
        city.setDistrict("GBR");
        city.setPopulation(450180);
        cityList.add(null);
        cityReport.displayReport(cityList);
    }
}
