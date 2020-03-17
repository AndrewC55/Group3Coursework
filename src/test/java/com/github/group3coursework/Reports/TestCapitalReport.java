package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Capital;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestCapitalReport {
    static CapitalReport capitalReport;

    @BeforeAll
    static void init() {
        capitalReport = new CapitalReport();
    }

    @Test
    void testFailToGenerateReportWhenNoConnectionIsGiven() {
        ArrayList<Capital> capitalList = capitalReport.generateReport(null );
        assertNull(capitalList);
    }

    @Test
    void testDisplayReportWhenNull() {
        capitalReport.displayReport(null);
    }

    @Test
    void testDisplayReportWhenEmpty() {
        ArrayList<Capital> capitalList = new ArrayList<>();
        capitalReport.displayReport(capitalList);
    }

    @Test
    void testDisplayReportWhenListContainsNull() {
        ArrayList<Capital> capitalList = new ArrayList<>();
        capitalList.add(null);
        capitalReport.displayReport(capitalList);
    }

    @Test
    void testDisplayReportWhenListIsValid() {
        ArrayList<Capital> capitalList = new ArrayList<>();
        Capital capital = new Capital();
        capital.setName("Edinburgh");
        capital.setCountry("Scotland");
        capital.setPopulation(450180);
        capitalList.add(capital);
        capitalReport.displayReport(capitalList);
    }
}
