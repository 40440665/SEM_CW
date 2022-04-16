package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {

    //Set connection variable to null
    Connection con = null;

    public static void main(String[] args) {

        //Create new application
        App Test = new App();

        //Connect to database
        if(args.length < 1){
            Test.connect("db:3306", 30000);
        }else{
            Test.connect(args[0], Integer.parseInt(args[1]));
        }

        //Displays cities ordered by population
        //ArrayList<City> cities = Test.citiesByPopulation();

        //Displays cities in a continent
        //ArrayList<City> cities = Test.citiesByContinent("Europe");

        //Display cities by district
        //ArrayList<City> cities = Test.citiesByDistrict("Balkh");

        //Display cities in a region
        //ArrayList<City> cities = Test.citiesByRegion("Caribbean");

        //Display cities in a country
        //ArrayList<City> cities = Test.citiesByCountry("France");

        //Display top N populated cities in the world
        //ArrayList<City> cities = Test.nPopulatedCities(4);

        //Display top N populated cities in a continent
        //ArrayList<City> cities = Test.nPopulatedCitiesInAContinent(3,"Europe");

        //Display top N populated cities in a region
        //ArrayList<City> cities = Test.nPopulatedCitiesInARegion(4, "Caribbean");

        //Display top N populated cities in a district
        //ArrayList<City> cities = Test.nPopulatedCitiesInADistrict(6, "California");

        //Display top N populated cities in a country
        //ArrayList<City> cities = Test.nPopulatedCitiesInACountry(3, "France");

        Population report = Test.countryPopulation("GBR");

        Test.printPopulation(report);


        //Print the cities
        //Test.printCities(cities);

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
     * Prints a list of cities
     *
     * @param cities The list of cities to print
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

            //Formatting the rows that will come under the header
            String city_string =
                    String.format("%-40s %-15s %-20s %-8s",
                            city.Name, city.CountryCode, city.District, city.Population);
            System.out.println(city_string);
        }
    }

    /**
     * Prints a population report
     *
     * @param report The list 
     */
    public void printPopulation(Population report) {
        // Print header
        System.out.println(String.format("%-40s %-15s %-20s %-8s %-8s %-8s", "Name", "Population", "Population Living in Cities", "Percentage of Population Living in Cities", "Population not Living in Cities", "Percentage of Population not Living in Cities"));

        //Formatting the rows that will come under the header
        String population_string =
            String.format("%-10s %-15s %-10s %-10s %-10s %-10s",
                report.Name, report.Population, report.PopulationInCities, report.PercentInCities, report.PopulationNotInCities, report.PercentNotInCities);
        System.out.println(population_string);
    }

    /**
     * Sorts all cities in the world by population
     */
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


    /**
     * Prints a list of cities in a district sorted by population
     * taking in
     * @param district which is the name of the desired district
     */
    public ArrayList<City> citiesByDistrict(String district) {
        try {

            //Check if district is null
            if (district == null)
            {
                System.out.println("district is null");
                return null;
            }
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

    /**
     * Prints a list of cities in a continent sorted by population
     * taking in
     * @param continent which is the name of the desired continent
     */
    public ArrayList<City> citiesByContinent(String continent) {
        try {
            //Check if continent is null
            if (continent == null)
            {
                System.out.println("continent is null");
                return null;
            }
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

    /**
     * Prints a top list of N cities in the world based on the input from the user.
     * taking in
     * @param n number of cities that we want to display
     */
    public ArrayList<City> nPopulatedCities(int n) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is 0");
                return null;
            }
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

    /**
     * Prints a list of cities in a region sorted by order
     * taking in
     * @param region which is the name of the desired region
     */
    public ArrayList<City> citiesByRegion(String region) {
        try {
            //Check if region is null
            if (region == null)
            {
                System.out.println("region is null");
                return null;
            }
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

    /**
     * Prints a list of cities in a country sorted by population
     * taking in
     * @param country which is the name of the desired country
     */
    public ArrayList<City> citiesByCountry(String country) {
        try {
            //Check if country is null
            if (country == null)
            {
                System.out.println("country is null");
                return null;
            }
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

    /**
     * Prints a top list of N cities in a continent sorted by population
     * taking in
     * @param n number of cities
     * @param continent the name of the desired continent
     */
    public ArrayList<City> nPopulatedCitiesInAContinent(int n, String continent) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is empty");
                return null;
            }

            //Check if continent is null
            if (continent == null)
            {
                System.out.println("Country is null");
                return null;
            }
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


    /**
     * Prints a top list of N cities in a region sorted by population
     * taking in
     * @param n number of cities
     * @param region the name of the desired region
     */
    public ArrayList<City> nPopulatedCitiesInARegion(int n, String region) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is empty");
                return null;
            }

            //Check if region is null
            if (region == null)
            {
                System.out.println("Region is null");
                return null;
            }
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

    /**
     * Prints a top list of N cities in a country sorted by population
     * taking in
     * @param n number of cities
     * @param country the name of the desired country
     */
    public ArrayList<City> nPopulatedCitiesInACountry(int n, String country) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is empty");
                return null;
            }

            //Check if country is null
            if (country == null)
            {
                System.out.println("Country is null");
                return null;
            }
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

    /**
     * Prints a top list of N cities in a district sorted by population
     * taking in
     * @param n number of cities
     * @param district the name of the desired district
     */
    //Get top N populated cities in a district
    public ArrayList<City> nPopulatedCitiesInADistrict(int n, String district) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is empty");
                return null;
            }

            //Check if district is null
            if (district == null)
            {
                System.out.println("district is null");
                return null;
            }
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


    public String worldPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  SUM(Population) AS Population "
                            + " FROM country ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            rset.next();
            long worldPop = rset.getLong(1);

            String worldPopString = "World population is " + worldPop;
            return worldPopString;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }  
    }

    public Population continentPopulation(String continent) {
        try {
            //Check if continent is null
            if (continent == null)
            {
                System.out.println("Continent is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS Population "
                            + " FROM country "
                            + " WHERE continent= '"+continent+"' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            Population report = new Population();
            report.Name = rset.getString("Name");
            report.Population = rset.getInt("Population");
            report.PopulationInCities = rset.getInt("Population Living in Cities");
            report.PercentInCities = rset.getDouble("Percentage of Population Living in Cities");
            report.PopulationNotInCities = rset.getInt("Population not Living in Cities");
            report.PercentNotInCities = rset.getDouble("Percentage of Population not Living in Cities");
            
            return report;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent details");
            return null;
        }  
    }

    public Population regionPopulation(String region) {
        try {
            //Check if region is null
            if (region == null)
            {
                System.out.println("Region is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS Population "
                            + "FROM country "
                            + " WHERE Region = '" + region + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            Population report = new Population();
            report.Name = rset.getString("Name");
            report.Population = rset.getInt("Population");
            report.PopulationInCities = rset.getInt("Population Living in Cities");
            report.PercentInCities = rset.getDouble("Percentage of Population Living in Cities");
            report.PopulationNotInCities = rset.getInt("Population not Living in Cities");
            report.PercentNotInCities = rset.getDouble("Percentage of Population not Living in Cities");
            
            return report;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region details");
            return null;
        }  
    }

    public Population countryPopulation(String country) {
        try {
            //Check if country is null
            if (country == null)
            {
                System.out.println("Country is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT Name, Population, "
                        + " (SELECT SUM(population) FROM city WHERE countryCode = '" + country + "') AS 'Population Living in Cities', "
                        + " ROUND(((SELECT SUM(population) FROM city WHERE CountryCode = '" + country + "') / Population)*100,1) AS 'Percentage of Population Living in Cities', "
                        + " (Population - (SELECT SUM(population) FROM city WHERE countryCode = '" + country + "')) AS 'Population not Living in Cities', "
                        + " ROUND(((Population - (SELECT SUM(population) FROM city WHERE countryCode = '" + country + "')) / Population)*100, 1) AS 'Percentage of Population not Living in Cities' "
                        + " FROM country WHERE Code = '" + country + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            Population report = new Population();
            rset.next();
            report.Name = rset.getString("Name");
            report.Population = rset.getInt("Population");
            report.PopulationInCities = rset.getInt("Population Living in Cities");
            report.PercentInCities = rset.getDouble("Percentage of Population Living in Cities");
            report.PopulationNotInCities = rset.getInt("Population not Living in Cities");
            report.PercentNotInCities = rset.getDouble("Percentage of Population not Living in Cities");
            
            return report;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }  
    }

    public String districtPopulation(String district) {
        try {
            //Check if district is null
            if (district == null)
            {
                System.out.println("District is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  SUM(population) AS Population "
                            + " FROM city "
                            + " WHERE District = '" + district + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            rset.next();
            long districtPop = rset.getLong(1);
            
            String districtPopString = district + "'s population is " + districtPop;
            return districtPopString;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }  
    }

    public String cityPopulation(String city) {
        try {
            //Check if city is null
            if (city == null)
            {
                System.out.println("City is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  SUM(population) AS population "
                            + "FROM city "
                            + " WHERE Name = '" + city + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            rset.next();
            long cityPop = rset.getLong(1);
            
            String cityPopString = city + "'s population is " + cityPop;
            return cityPopString;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }  
    }
}
