package com.github.group3coursework.Population;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestPopulationOfRegion {
    static PopulationOfRegion populationOfRegion;

    @BeforeAll
    static void init() {
        populationOfRegion = new PopulationOfRegion();
    }

    @Test
    void testGenerateRegionWhenConnectionIsNull() {
        long regionPopulation = populationOfRegion.generateRegion(null, "Kabol");
        assertEquals(0, regionPopulation);
    }

    @Test
    void testGenerateRegionWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            long regionPopulation = populationOfRegion.generateRegion(con, "Kabol");
            assertNotEquals(null, regionPopulation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayRegionWhenPopulationIsValid() {
        populationOfRegion.displayRegion(1);
    }

    @Test
    void testDisplayRegionWhenPopulationIsNotValid() {
        populationOfRegion.displayRegion(0);
    }
}
