package com.github.group3coursework.Reports;

import com.github.group3coursework.Entities.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class NumberOfPeopleWhoSpeakDifferentLanguages {

    /**
     * Generates the number of people who speak different languages
     * @param con is the connection to the database
     * @return Language
     */
    Language generateReport(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String getAllSelectedLanguages = "SELECT "
                    + "SUM(CASE WHEN countrylanguage.Language = 'Chinese' THEN country.Population / countrylanguage.Percentage ELSE 0 END) AS Chinese, "
                    + "SUM(CASE WHEN countrylanguage.Language = 'English' THEN country.Population / countrylanguage.Percentage ELSE 0 END) AS English, "
                    + "SUM(CASE WHEN countrylanguage.Language = 'Hindi' THEN country.Population / countrylanguage.Percentage ELSE 0 END) AS Hindi, "
                    + "SUM(CASE WHEN countrylanguage.Language = 'Spanish' THEN country.Population / countrylanguage.Percentage ELSE 0 END) AS Spanish, "
                    + "SUM(CASE WHEN countrylanguage.Language = 'Arabic' THEN country.Population / countrylanguage.Percentage ELSE 0 END) AS Arabic "
                    + "FROM countrylanguage, country "
                    + "WHERE countrylanguage.CountryCode = country.Code";

            ResultSet rset = stmt.executeQuery(getAllSelectedLanguages);
            rset.next();

            Language language = new Language();
            language.setChinese(rset.getInt("Chinese"));
            language.setEnglish(rset.getInt("English"));
            language.setHindi(rset.getInt("Hindi"));
            language.setSpanish(rset.getInt("Spanish"));
            language.setArabic(rset.getInt("Arabic"));

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
        if (language == null) {
            System.out.println("No languages");
            return;
        }

        // Print country report headers
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s", "Chinese", "English", "Hindi", "Spanish", "Arabic"));
        String languageString = String.format("%-30s %-30s %-30s %-30s %-30s", language.getChinese(), language.getEnglish(), language.getHindi(), language.getSpanish(), language.getArabic());
        System.out.println(languageString);
    }
}
