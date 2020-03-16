package com.github.group3coursework.Population;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    void testDisplayWorldWhenPopulationIsValid() {
        populationOfWorld.displayWorld(1);
    }

    @Test
    void testDisplayWorldWhenPopulationIsNotValid() {
        populationOfWorld.displayWorld(0);
    }
}
