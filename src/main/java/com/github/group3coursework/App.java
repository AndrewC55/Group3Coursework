package com.github.group3coursework;

import com.github.group3coursework.Population.PopulationHandler;
import com.github.group3coursework.Reports.ReportHandler;
import com.github.group3coursework.UrbanPopulation.UrbanPopulationHandler;

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
        if(args.length < 1)
            a.connect("localhost:3306");
        else
            a.connect(args[0]);

        // asks the user which report they would like to view
        a.packageSelector("Urban Population");

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
    public void packageSelector(String packageName) {
        switch(packageName) {
            case "Report":
                ReportHandler reportHandler = new ReportHandler();
                reportHandler.reportSelector("Languages", con);
                break;
            case "Population":
                PopulationHandler populationHandler = new PopulationHandler();
                populationHandler.populationSelector("Region", con);
                break;
            case "Urban Population":
                UrbanPopulationHandler urbanPopulationHandler = new UrbanPopulationHandler();
                urbanPopulationHandler.urbanPopulationHandler("Continent", con);
                break;
            default:
                break;
        }
    }

    /**
     * Connect to the MySQL database.
     */
    Connection connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected");
                return con;
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
        return null;
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
