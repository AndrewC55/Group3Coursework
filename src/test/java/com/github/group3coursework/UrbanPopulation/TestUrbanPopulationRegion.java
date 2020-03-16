package com.github.group3coursework.UrbanPopulation;

import com.github.group3coursework.Entities.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestUrbanPopulationRegion {
    static UrbanPopulationRegion urbanPopulationRegion;

    @BeforeAll
    static void init() {
        urbanPopulationRegion = new UrbanPopulationRegion();
    }

    @Test
    void testGenerateUrbanPopulationContinentWhenConnectionIsNull() {
        ArrayList<Population> region = urbanPopulationRegion.generateUrbanPopulationRegion(null);
        assertNull(region);
    }

    @Test
    void testDisplayReportWhenNull() {
        urbanPopulationRegion.displayUrbanPopulationRegion(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<Population> regionList = new ArrayList<>();
        urbanPopulationRegion.displayUrbanPopulationRegion(regionList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<Population> regionList = new ArrayList<>();
        regionList.add(null);
        urbanPopulationRegion.displayUrbanPopulationRegion(regionList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<Population> regionList = new ArrayList<>();
        Population population = new Population();
        population.setName("Eastern Europe");
        population.setPopulationUrban(1);
        population.setPopulationRural(1);
        regionList.add(population);
        urbanPopulationRegion.displayUrbanPopulationRegion(regionList);
    }
}