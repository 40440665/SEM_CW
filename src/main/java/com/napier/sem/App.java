package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    Connection con = null;

    public static void main(String[] args) {
        //Create new application
        App Test = new App();

        //Connect to database
        Test.connect();

        //Assign all the records properly
        //ArrayList<City> cities = Test.getAllCities();

        ArrayList<City> cities = Test.citesByPopulation();

        //Print the cities
        Test.printCities(cities);


        //Disconnect from database
        Test.disconnect();
        }


        //Connect to the database
        public void connect()
        {
            try {
                // Load Database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            // Connection to the database
            int retries = 100;
            for (int i = 0; i < retries; ++i) {
                System.out.println("Connecting to database...");
                try {
                    // Wait a bit for db to start
                    Thread.sleep(30000);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                    System.out.println("Successfully connected");
                    // Wait a bit
                    Thread.sleep(10000);
                    // Exit for loop
                    break;
                } catch (SQLException sqle) {
                    System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                    System.out.println(sqle.getMessage());
                } catch (InterruptedException ie) {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }


        //Disconnect from the database
        public void disconnect()
        {
            if (con != null) {
                try {
                    // Close connection
                    con.close();
                    System.out.println("Dsiconnecting from database");
                } catch (Exception e) {
                    System.out.println("Error closing connection to database");
                }
            }
        }



        /**
     * Prints a list of cities.
     *
     * @param cities The list of cities to print.
     */
    public void printCities(ArrayList<City> cities) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Name", "Country Code", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities) {
            String city_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            city.Name, city.CountryCode, city.District, city.Population);
            System.out.println(city_string);
        }
    }






    public ArrayList<City> citesByPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city " + "ORDER BY Population ASC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                city.Population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }

}
