package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class TestPopulationOfCity {
    static PopulationOfCity populationOfCity;

    @BeforeAll
    static void init() {
        populationOfCity = new PopulationOfCity();
    }

    @Test
    void testGenerateWorldWhenConnectionIsNull() {
        City cityPopulation = populationOfCity.generateCity(null, "Edinburgh");
        assertEquals(null, cityPopulation);
    }

    @Test
    void testGenerateWorldWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            City cityPopulation = populationOfCity.generateCity(con, "Edinburgh");
            assertNotEquals(null, cityPopulation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayWorldWhenPopulationIsValid() {
        City city = new City();
        city.setName("Edinburgh");
        city.setPopulation(1);
        populationOfCity.displayCity(city);
    }

    @Test
    void testDisplayWorldWhenPopulationIsNotValid() {
        City city = new City();
        populationOfCity.displayCity(city);
    }
}
