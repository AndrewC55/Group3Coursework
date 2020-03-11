package com.github.group3coursework;

import com.github.group3coursework.Population.PopulationHandler;
import com.github.group3coursework.Reports.ReportHandler;
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
        a.packageSelector("Population");

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * This is used to determine which package of sql queries the user would like to view
     * @param packageName string value used to input the package
     */
    private void packageSelector(String packageName) {
        switch(packageName) {
            case "Report":
                ReportHandler reportHandler = new ReportHandler();
                reportHandler.reportSelector("Languages", con);
                break;
            case "Population":
                PopulationHandler populationHandler = new PopulationHandler();
                populationHandler.populationSelector("Region", con);
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
}
