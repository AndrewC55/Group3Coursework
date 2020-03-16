package com.github.group3coursework.Population;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testDisplayRegionWhenPopulationIsValid() {
        populationOfRegion.displayRegion(1);
    }

    @Test
    void testDisplayRegionWhenPopulationIsNotValid() {
        populationOfRegion.displayRegion(0);
    }
}
