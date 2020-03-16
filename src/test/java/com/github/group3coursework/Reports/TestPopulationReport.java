package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TestPopulationReport {
    static PopulationReport populationReport;

    @BeforeAll
    static void init() {
        populationReport = new PopulationReport();
    }

    // TODO implement tests for the generateReport when it is finished

    @Test
    void testDisplayReportWhenNull() {
        populationReport.displayReport(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<Population> populationList = new ArrayList<>();
        populationReport.displayReport(populationList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<Population> populationList = new ArrayList<>();
        populationList.add(null);
        populationReport.displayReport(populationList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<Population> populationList = new ArrayList<>();
        Population population = new Population();
        population.setName("Scotland");
        population.setPopulationRural(1);
        population.setPopulationUrban(1);
        population.setTotalPopulation(1);
        population.setArea("BLAH");
        populationList.add(population);
        populationReport.displayReport(populationList);
    }
}
