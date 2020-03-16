package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.Continent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPopulationOfContinent {
    static PopulationOfContinent populationOfContinent;

    @BeforeAll
    static void init() {
        populationOfContinent = new PopulationOfContinent();
    }

    @Test
    void testGenerateWorldWhenConnectionIsNull() {
        Continent continentPopulation = populationOfContinent.generatePopulation(null, "Europe");
        assertEquals(null, continentPopulation);
    }

    @Test
    void testDisplayWorldWhenPopulationIsValid() {
        Continent continent = new Continent();
        continent.setName("Edinburgh");
        continent.setPopulation(1);
        populationOfContinent.displayContinent(continent);
    }

    @Test
    void testDisplayWorldWhenPopulationIsNotValid() {
        Continent continent = new Continent();
        populationOfContinent.displayContinent(continent);
    }
}
