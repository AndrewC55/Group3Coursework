package com.github.group3coursework.Population;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class TestPopulationOfWorld {
    static PopulationOfWorld populationOfWorld;

    @BeforeAll
    static void init() {
        populationOfWorld = new PopulationOfWorld();
    }

    @Test
    void testGenerateWorldWhenConnectionIsNull() {
        long worldPopulation = populationOfWorld.generateWorld(null);
        assertEquals(0, worldPopulation);
    }

    @Test
    void testGenerateWorldWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            long worldPopulation = populationOfWorld.generateWorld(con);
            assertNotEquals(null, worldPopulation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayWorldWhenPopulationIsValid() {
        populationOfWorld.displayWorld(1);
    }

    @Test
    void testDisplayWorldWhenPopulationIsNotValid() {
        populationOfWorld.displayWorld(0);
    }
}
