package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    Connection con = null;

    public static void main(String[] args) {

        //Create new application
        App Test = new App();

        //Connect to database
        if(args.length < 1){
            Test.connect("localhost:33060", 30000);
        }else{
            Test.connect(args[0], Integer.parseInt(args[1]));
        }

        // CITIES BY POPULATION
        //ArrayList<City> cities = Test.citiesByPopulation();

        // CITIES IN A CONTINENT
        //ArrayList<City> cities = Test.getAllCitiesInAContinent("Europe");

        //Display cities by district
        //ArrayList<City> cities = Test.citiesByDistrict("Balkh");

        //Display cities in a Region
        //ArrayList<City> cities = Test.getAllCitiesInARegion("Caribbean");

        //Display cities in a Country
        //ArrayList<City> cities = Test.getAllCitiesInACountry("France");

        //Display top N populated cities
        //ArrayList<City> cities = Test.NPopulatedCities(4);

        //Display top N populated cities in a continent
        //ArrayList<City> cities = Test.getNCitiesInAContinent(3,"Europe");

        //Display top N populated cities in a region
        //ArrayList<City> cities = Test.getNCitiesInARegion(4, "Caribbean");

        //Display top N populated cities in a district
        //ArrayList<City> cities = Test.NPopulatedCitiesInADistrict(6, "California");


        //Display top N populated cities in a country
        //ArrayList<City> cities = Test.getNCitiesInACountry();

        //Print the cities
        Test.printCities(cities);


        //Disconnect from database
        Test.disconnect();
        }


        //Connect to the database
        public void connect(String location, int delay)
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
                    //Changing to '0' allows for fast connection with localhost:33060 [Originally 30000]
                    Thread.sleep(30000);

                    // Connect to database
                    // "localhost:33060" Makes a fast connection to the database. [Originally db:3306]
                    con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
                    System.out.println("Disconnecting from database");
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

        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-40s %-15s %-20s %-8s", "Name", "Country Code", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities) {
            if (city == null)
            {
                continue;
            }
            String city_string =
                    String.format("%-40s %-15s %-20s %-8s",
                            city.Name, city.CountryCode, city.District, city.Population);
            System.out.println(city_string);
        }
    }





    //Sort cities by population
    public ArrayList<City> citiesByPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + " FROM city "
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
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



    //Get cities in district and sort by population
    public ArrayList<City> citiesByDistrict(String district) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + " FROM city "
                            + " WHERE District='"+district+"' "
                            + " ORDER BY Population DESC";

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


    public ArrayList<City> getAllCitiesInAContinent(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.continent = '" + continent + "' "
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }



    //Get top N populated cities in the world
    public ArrayList<City> NPopulatedCities(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + " FROM city "
                            + " ORDER BY Population DESC "
                            + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
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

    public ArrayList<City> getAllCitiesInARegion(String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.Region = '"+region+"' "
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    public ArrayList<City> getAllCitiesInACountry(String country) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.Name = '"+country+"' "
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> getNCitiesInAContinent(int n, String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.continent = '"+continent+"' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "+n+" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }



    public ArrayList<City> getNCitiesInARegion(int n, String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.Region = '"+region+"' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "+n+" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    public ArrayList<City> getNCitiesInACountry(int n, String country) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.Name = '"+country+"' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "+n+" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.CountryCode = rset.getString("city.CountryCode");
                city.District = rset.getString("city.District");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Get top N populated cities in a district
    public ArrayList<City> NPopulatedCitiesInADistrict(int n, String district) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + " FROM city "
                            + " WHERE District='"+district+"' "
                            + " ORDER BY Population DESC"
                            + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
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
