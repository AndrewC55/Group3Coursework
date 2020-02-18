package com.github.group3coursework;

import java.util.ArrayList;
import java.sql.*;

/**
 * Main App for the program
 */
public class App {
    /**
     * TODO add user input for which report they would like to view
     * @param args arguments passed to the main
     */
    public static void main(String[] args) {
        System.out.println("Project builds to self contained JAR with Maven");
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // asks the user which report they would like to view
        a.reportSelector("Country");

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * TODO add all report names in switch statement and add provide the class name
     * All report names will go in here for
     */
    private void reportSelector(String report)  {
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
                System.out.println("not implemented yet");
                break;
            case "Population":
                System.out.println("not implemented yet");
                break;
            default:
                break;
        }
    }

    /**
     * Connect to the MySQL database.
     */
    private void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    private void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    private void getAmountOfCities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                "SELECT COUNT(*) as Amount "
                    + "FROM city ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                System.out.println(rset.getInt("Amount"));
            }
            else
                System.out.println("Nothing was found.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
        }
    }
}
