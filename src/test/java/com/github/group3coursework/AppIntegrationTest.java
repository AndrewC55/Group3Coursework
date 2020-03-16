package com.github.group3coursework;

import com.github.group3coursework.Entities.City;
import com.github.group3coursework.Reports.CityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    private static Connection con;

    @BeforeAll
    static void init()
    {
        app = new App();
        con = app.connect("localhost:33060");
    }

    @Test
    void testCityReport()
    {
        CityReport cityReport = new CityReport();
        ArrayList<City> cityList = cityReport.generateReport(con);
        assertEquals("A Coruña (La Coruña)", cityList.get(0).getName());
        assertEquals("Spain", cityList.get(0).getCountry());
        assertEquals("Galicia", cityList.get(0).getDistrict());
        assertEquals(243402, cityList.get(0).getPopulation());
    }
}