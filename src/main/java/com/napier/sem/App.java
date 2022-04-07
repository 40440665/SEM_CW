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
            //Slow Connection
            Test.connect("db:3306", 30000);
            //Fast Connection
            //Test.connect("localhost:33060", 0);
        }else{
            Test.connect(args[0], Integer.parseInt(args[1]));
        }

        /// CITY METHODS

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


        // COUNTRY METHODS

        //Displays countries ordered by population
        //ArrayList<Country> countries = Test.countriesByPopulation();

        //Displays countries in a continent
        ArrayList<Country> countries = Test.countriesByContinent("Europe");

        //Display countries in a region
        //ArrayList<Country> countries = Test.countriesByRegion("Caribbean");

        //Display top N populated countries in the world
        //ArrayList<Country> countries = Test.nPopulatedCountries(4);

        //Display top N populated countries in a continent
        //ArrayList<Country> countries = Test.nPopulatedCountriesInAContinent(3,"Europe");

        //Display top N populated countries in a region
        //ArrayList<Country> countries = Test.nPopulatedCountriesInARegion(4, "Caribbean");

        // INVOKE PRINT METHODS

        //Print the cities
        //Test.printCities(cities);

        //Print the countries
        Test.printCountries(countries);

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
                Thread.sleep(delay);

                // Connect to database
                // "localhost:33060" Makes a fast connection to the database. [Originally db:3306]
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(delay);
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
        System.out.println(String.format("%-40s %-15s %-20s %-8s", "Name", "CountryCode", "District", "Population"));

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
     * Prints a list of cities
     *
     * @param countries The list of cities to print
     */
    public void printCountries(ArrayList<Country> countries) {

        // Check countries is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }

        // Print header
        System.out.println(String.format("%-5s %-45s %-15s %-30s %-15s %-8s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list
        for (Country country : countries) {
            if (country == null)
            {
                continue;
            }

            //Formatting the rows that will come under the header
            String country_string =
                    String.format("%-5s %-45s %-15s %-30s %-15s %-8s",
                            country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital);
            System.out.println(country_string);
        }
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

    /**
     * Sorts all countries in the world by population
    */
    public ArrayList<Country> countriesByPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
            return null;
        }
    }

    /**
     * Prints a list of countries in a continent sorted by population
     * taking in
     * @param continent which is the name of the desired continent
     */
    public ArrayList<Country> countriesByContinent(String continent) {
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " WHERE Continent = '" + continent + "' "
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
            return null;
        }
    }

    /**
     * Prints a list of countries in a region sorted by population
     * taking in
     * @param region which is the name of the desired region
     */
    public ArrayList<Country> countriesByRegion(String region) {
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " WHERE Region = '" + region + "' "
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
            return null;
        }
    }

 
       /**
     * Prints a top list of N countries in the world based on the input from the user.
     * taking in
     * @param n number of countries that we want to display
     */
    public ArrayList<Country> nPopulatedCountries(int n) {
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " ORDER BY Population DESC "
                            + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
            return null;
        }
    }
    
    /**
     * Prints a top list of N countries in a continent sorted by population
     * taking in
     * @param n number of countries
     * @param continent the name of the desired continent
     */
    public ArrayList<Country> nPopulatedCountriesInAContinent(int n, String continent) {
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
                System.out.println("Continent is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " WHERE Continent = '"+continent+"' "
                            + " ORDER BY Population DESC "
                            + " LIMIT "+n+" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }

    /**
     * Prints a top list of N countries in a region sorted by population
     * taking in
     * @param n number of countries
     * @param region the name of the desired region
     */
    public ArrayList<Country> nPopulatedCountriesInARegion(int n, String region) {
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + " FROM country "
                            + " WHERE Region = '"+region+"' "
                            + " ORDER BY Population DESC "
                            + " LIMIT "+n+" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }    
}
