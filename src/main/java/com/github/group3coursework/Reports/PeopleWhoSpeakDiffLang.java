package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class PeopleWhoSpeakDiffLang {

    /**
     * Generates the number of people who speak different languages
     * @param con is the connection to the database
     * @return ArrayList
     */
    Language generateReport(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect = "SELECT "
                             + " "
                             + "FROM countrylanguage l, country c "
                             + "WHERE l.countryCode = c.Code ";

            ResultSet rset = stmt.executeQuery(strSelect);

            Language language = new Language();
            language.setChinese(rset.getInt(""));
            language.setEnglish(rset.getInt(""));
            language.setHindi(rset.getInt(""));
            language.setSpanish(rset.getInt(""));
            language.setArabic(rset.getInt(""));

            return language;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate Country Report");
            return null;
        }
    }

    /**
     * Displays the number of people who speak different Languages
     * @param language is an ArrayList that contains countries retrieved by the SQL query
     */
    void displayReport(Language language) {
        // Print country report headers
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s", "Chinese", "English", "Hindi", "Spanish", "Arabic"));
        String languageString = String.format("%-30s %-30s %-30s %-30s %-30s", language.getChinese(), language.getEnglish(), language.getHindi(), language.getSpanish(), language.getArabic());
        System.out.println(languageString);
    }
}
