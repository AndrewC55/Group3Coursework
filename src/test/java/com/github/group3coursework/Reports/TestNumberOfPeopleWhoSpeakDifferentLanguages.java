package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestNumberOfPeopleWhoSpeakDifferentLanguages {
    static NumberOfPeopleWhoSpeakDifferentLanguages numberOfPeopleWhoSpeakDifferentLanguages;

    @BeforeAll
    static void init() {
        numberOfPeopleWhoSpeakDifferentLanguages = new NumberOfPeopleWhoSpeakDifferentLanguages();
    }

    @Test
    void testFailToGenerateReportWhenNoConnectionIsGiven() {
        Language language = numberOfPeopleWhoSpeakDifferentLanguages.generateReport(null);
        assertNull(language);
    }

    @Test
    void testPassGenerateReportWhenConnectionIsGiven() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
            Language language = numberOfPeopleWhoSpeakDifferentLanguages.generateReport(con);
            assertNotEquals(null, language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayReportWhenNull() {
        numberOfPeopleWhoSpeakDifferentLanguages.displayReport(null);
    }

    @Test
    void testDisplayReportWhenLanguageIsEmpty() {
        Language language = new Language();
        numberOfPeopleWhoSpeakDifferentLanguages.displayReport(language);
    }

    @Test
    void testDisplayReportWhenLanguageIsNull() {
        Language language = null;
        numberOfPeopleWhoSpeakDifferentLanguages.displayReport(language);
    }

    @Test
    void testDisplayReportWhenLanguageIsValid() {
        Language language = new Language();
        language.setChinese(1);
        language.setEnglish(1);
        language.setArabic(1);
        language.setHindi(1);
        language.setSpanish(1);
        numberOfPeopleWhoSpeakDifferentLanguages.displayReport(language);
    }
}
