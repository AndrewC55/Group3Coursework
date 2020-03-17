package com.github.group3coursework.Population;

import com.github.group3coursework.Entities.District;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPopulationOfDistrict {
    static PopulationOfDistrict populationOfDistrict;

    @BeforeAll
    static void init() {
        populationOfDistrict = new PopulationOfDistrict();
    }

    @Test
    void testGenerateWorldWhenConnectionIsNull() {
        District districtPopulation = populationOfDistrict.generatePopulation(null, "Kabol");
        assertEquals(null, districtPopulation);
    }

    @Test
    void testDisplayWorldWhenPopulationIsValid() {
        District district = new District();
        district.setName("Kabol");
        district.setPopulation(1);
        populationOfDistrict.displayDistrict(district);
    }

    @Test
    void testDisplayWorldWhenPopulationIsNotValid() {
        District district = new District();
        populationOfDistrict.displayDistrict(district);
    }
}
