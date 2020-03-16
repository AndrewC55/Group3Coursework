package com.github.group3coursework.UrbanPopulation;

import com.github.group3coursework.Entities.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestUrbanPopulationContinent {
    static UrbanPopulationContinent urbanPopulationContinent;

    @BeforeAll
    static void init() {
        urbanPopulationContinent = new UrbanPopulationContinent();
    }

    @Test
    void testGenerateUrbanPopulationContinentWhenConnectionIsNull() {
        ArrayList<Population> continent = urbanPopulationContinent.generateUrbanPopulationContinent(null);
        assertNull(continent);
    }

    @Test
    void testDisplayReportWhenNull() {
        urbanPopulationContinent.displayUrbanPopulationContinent(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<Population> continentList = new ArrayList<>();
        urbanPopulationContinent.displayUrbanPopulationContinent(continentList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<Population> continentList = new ArrayList<>();
        continentList.add(null);
        urbanPopulationContinent.displayUrbanPopulationContinent(continentList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<Population> continent = new ArrayList<>();
        Population population = new Population();
        population.setName("Oceania");
        population.setPopulationUrban(1);
        population.setPopulationRural(1);
        continent.add(population);
        urbanPopulationContinent.displayUrbanPopulationContinent(continent);
    }
}
