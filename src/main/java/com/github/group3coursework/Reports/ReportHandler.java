package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Capital;
import com.github.group3coursework.Entities.City;
import com.github.group3coursework.Entities.Country;
import com.github.group3coursework.Entities.Language;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * This is a handler that the main will call
 * This is used to determine which report the user would like to view
 */
public class ReportHandler {
    /**
     * TODO add all report names in switch statement and add provide the class name
     * All report names will go in here for
     */
    public void reportSelector(String report, Connection con)  {
        switch(report) {
            case "City":
                CityReport cityReport = new CityReport();
                ArrayList<City> cityList = cityReport.generateReport(con);
                cityReport.displayReport(cityList);
                break;
            case "Country":
                CountryReport countryReport = new CountryReport();
                ArrayList<Country> countryList = countryReport.generateReport(con);
                countryReport.displayReport(countryList);
                break;
            case "Capital":
                CapitalReport capitalReport = new CapitalReport();
                ArrayList<Capital> capitalList = capitalReport.generateReport(con);
                capitalReport.displayReport(capitalList);
                break;
            case "Population":
                System.out.println("not implemented yet");
                break;
            case "Languages":
                NumberOfPeopleWhoSpeakDifferentLanguages peopleWhoSpeakDiffLang = new NumberOfPeopleWhoSpeakDifferentLanguages();
                Language language = peopleWhoSpeakDiffLang.generateReport(con);
                peopleWhoSpeakDiffLang.displayReport(language);
            default:
                break;
        }
    }
}
