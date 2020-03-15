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
    Connection con = null;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testCityReport()
    {
        CityReport cityReport = new CityReport();
        ArrayList<City> cityList = cityReport.generateReport(con);
        assertEquals(cityList.get(0).getName(), "A Coruña (La Coruña)");
        assertEquals(cityList.get(0).getCountry(), "Spain");
        assertEquals(cityList.get(0).getDistrict(), "Galicia");
        assertEquals(cityList.get(0).getPopulation(), "243402");
    }
}