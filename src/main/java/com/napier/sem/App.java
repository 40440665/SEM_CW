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



        // COUNTRY METHODS

        //Displays countries ordered by population
        //ArrayList<Country> countries = Test.countriesByPopulation();

        //Displays countries in a continent
        //ArrayList<Country> countries = Test.countriesByContinent("Europe");

        //Display countries in a region
        //ArrayList<Country> countries = Test.countriesByRegion("Caribbean");

        //Display top N populated countries in the world
        //ArrayList<Country> countries = Test.nPopulatedCountries(4);

        //Display top N populated countries in a continent
        //ArrayList<Country> countries = Test.nPopulatedCountriesInAContinent(3,"Europe");

        //Display top N populated countries in a region
        //ArrayList<Country> countries = Test.nPopulatedCountriesInARegion(4, "Caribbean");



        /// CITY METHODS

        //Displays cities ordered by population
        //ArrayList<City> cities = Test.citiesByPopulation();

        //Displays cities in a continent
        //ArrayList<City> cities = Test.citiesByContinent("Europe");

        //Display cities in a region
        //ArrayList<City> cities = Test.citiesByRegion("Caribbean");

        //Display cities in a country
        //ArrayList<City> cities = Test.citiesByCountry("France");

        //Display cities by district
        //ArrayList<City> cities = Test.citiesByDistrict("Balkh");

        //Display top N populated cities in the world
        //ArrayList<City> cities = Test.nPopulatedCities(4);

        //Display top N populated cities in a continent
        //ArrayList<City> cities = Test.nPopulatedCitiesInAContinent(3,"Europe");

        //Display top N populated cities in a region
        //ArrayList<City> cities = Test.nPopulatedCitiesInARegion(4, "Caribbean");

        //Display top N populated cities in a country
        //ArrayList<City> cities = Test.nPopulatedCitiesInACountry(3, "France");

        //Display top N populated cities in a district
        //ArrayList<City> cities = Test.nPopulatedCitiesInADistrict(6, "California");



        // CAPITAL CITY METHODS

        //Displays capital cities ordered by population
        ArrayList<CapitalCity> capitalCities = Test.capitalCitiesByPopulation();

        //Displays capital cities in a continent
        //ArrayList<CapitalCity> capitalCities = Test.capitalCitiesByContinent("Europe");

        //Display capital cities in a region
        //ArrayList<CapitalCity> capitalCities = Test.capitalCitiesByRegion("Caribbean");

        //Display top N populated capital cities in the world
        //ArrayList<CapitalCity> capitalCities = Test.nPopulatedCapitalCities(4);

        //Display top N populated capital cities in a continent
        //ArrayList<CapitalCity> capitalCities = Test.nPopulatedCapitalCitiesInAContinent(3,"Europe");

        //Display top N populated capital cities in a region
        //ArrayList<CapitalCity> capitalCities = Test.nPopulatedCapitalCitiesInARegion(4, "Caribbean");



        // POPULATION METHODS

        //Display the world population
        //String worldPop = Test.worldPopulation();
        //System.out.println(worldPop);

        //Display the population statistics of a continent
        //Population populationReport = Test.continentPopulation("Europe");

        //Display the population statistics of a region
        //Population populationReport = Test.regionPopulation("Caribbean");

        //Display the population statistics of a country
        //Population populationReport = Test.countryPopulation("France");

        //Display the population statistics of a district
        //String districtPop = Test.districtPopulation("California");
        //System.out.println(districtPop);

        //Display the population statistics of a city
        //String cityPop = Test.cityPopulation("Paris");
        //System.out.println(cityPop);



        // LANGUAGE REPORT

        //ArrayList<Language> languageReport = Test.languageReport();



        // INVOKE PRINT METHODS

        //Print the countries
        //Test.printCountries(countries);

        //Print the cities
        //Test.printCities(cities);

        //Print the population reports
        //Test.printPopulation(populationReport);

        //Print the language report
        //Test.printLanguages(languageReport);

        //Print the capital cities
        Test.printCapitalCities(capitalCities);

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
        Connection con = null;
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
     * Prints a list of capital cities
     *
     * @param capitalCities The list of capital cities to print
     */
    public void printCapitalCities(ArrayList<CapitalCity> capitalCities) {

        // Check capital cities is not null
        if (capitalCities == null)
        {
            System.out.println("No capital cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-10s %-15s %-8s", "Name", "Country", "Population"));

        // Loop over all capital cities in the list
        for (CapitalCity capitalCity : capitalCities) {
            if (capitalCity == null)
            {
                continue;
            }

            //Formatting the rows that will come under the header
            String capital_city_string =
                    String.format("%-10s %-15s %-8s",
                            capitalCity.Name, capitalCity.Country, capitalCity.Population);
            System.out.println(capital_city_string);
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
     * Prints a languages report
     *
     * @param languageReports The list
     */
    public void printLanguages(ArrayList<Language> languageReports) {
        // Print header
        System.out.println(String.format("%-10s %-10s %-10s", "Language", "Speakers", "Percentage of World Population"));

        // Loop over all cities in the list
        for (Language languageReport : languageReports) {
            if (languageReport == null)
            {
                continue;
            }

            //Formatting the rows that will come under the header
            String languages_string =
                    String.format("%-10s %-10s %-10s",
                            languageReport.Language, languageReport.Speakers, languageReport.PercentageOfWorldPopulation);
            System.out.println(languages_string);
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
                    "SELECT Continent AS Name, SUM(Population) AS Population, "
                        + " (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = '" + continent+ "') AS 'Population Living in Cities', "
                        + " ROUND(((SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = '" + continent+ "') / (SUM(country.Population)))*100,1) AS 'Percentage of Population Living in Cities', "
                        + " (SUM(country.Population) - (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = '" + continent+ "')) AS 'Population not Living in cities', "
                        + " ROUND((((SUM(country.Population)) - (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Continent = '" + continent+ "')) / SUM(country.Population))*100, 1) AS 'Percentage of Population not Living in Cities' "
                        + "FROM country WHERE Continent = '" + continent+ "' ";

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
                    "SELECT country.Region AS Name, SUM(country.Population) AS Population, "
                        + " (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Region = '" + region + "') AS 'Population Living in Cities', "
                        + " ROUND(((SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Region = '" + region + "') / (SUM(country.Population)))*100,1) AS 'Percentage of Population Living in Cities', "
                        + " (SUM(country.Population) - (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND Region = '" + region + "')) AS 'Population not Living in cities', "
                        + " ROUND((((SUM(country.Population)) - (SELECT SUM(city.Population) FROM city, country WHERE city.CountryCode = country.Code AND country.Region = '" + region + "')) / SUM(country.Population))*100, 1) AS 'Percentage of Population not Living in Cities' "
                        + " FROM country WHERE Region = '" + region + "' ";

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

    public ArrayList<Language> languageReport() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT Language, "
                        + " ROUND(SUM((Population/100) * Percentage)) AS Speakers, "
                        + " ROUND(((SUM((Population/100) * Percentage)) / (SELECT SUM(Population) FROM country)) * 100, 2) AS 'Percentage of World Population' "
                        + " FROM countrylanguage, country "
                        + " WHERE countrylanguage.CountryCode = country.Code "
                        + " GROUP BY Language "
                        + " ORDER BY ROUND(SUM((Population/100) * Percentage)) DESC "
                        + " LIMIT 5 ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            ArrayList<Language> languageReports = new ArrayList<Language>();

            while (rset.next()) {
                Language languageReport = new Language();
                languageReport.Language = rset.getString("Language");
                languageReport.Speakers = rset.getInt("Speakers");
                languageReport.PercentageOfWorldPopulation = rset.getDouble("Percentage of World Population");
                languageReports.add(languageReport);
            }
            return languageReports;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }

   /**
     * Prints a list of capital cities sorted by population
     */
    public ArrayList<CapitalCity> capitalCitiesByPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " ORDER BY Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }


    /**
     * Prints a list capital cities in a continent sorted by population
     * taking in
     * @param continent the name of the desired continent
     */
    public ArrayList<CapitalCity> capitalCitiesByContinent(String continent) {
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
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " AND country.Continent = '" + continent + "' "
                        + " ORDER BY Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }



        /**
     * Prints a list capital cities in a region sorted by population
     * taking in
     * @param region the name of the desired region
     */
    public ArrayList<CapitalCity> capitalCitiesByRegion(String region) {
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
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " AND country.Region = '" + region + "' "
                        + " ORDER BY Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }








    /**
     * Prints a top list of N capital cities sorted by population
     * taking in
     * @param n number of capital cities
     */
    public ArrayList<CapitalCity> nPopulatedCapitalCities(int n) {
        try {
            //Check if n is 0
            if (n == 0)
            {
                System.out.println("n is empty");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " ORDER BY Population DESC "
                        + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }


    /**
     * Prints a top list of N capital cities in a continent sorted by population
     * taking in
     * @param n number of capital cities
     * @param continent the name of the desired continent
     */
    public ArrayList<CapitalCity> nPopulatedCapitalCitiesInAContinent(int n, String continent) {
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
                System.out.println("continent is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " AND country.Continent = '" + continent + "' "
                        + " ORDER BY Population DESC "
                        + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }


    /**
     * Prints a top list of N capital cities in a region sorted by population
     * taking in
     * @param n number of capital cities
     * @param region the name of the desired region
     */
    public ArrayList<CapitalCity> nPopulatedCapitalCitiesInARegion(int n, String region) {
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
                System.out.println("region is null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.Population "
                        + " FROM city, country "
                        + " WHERE city.CountryCode = country.code "
                        + " AND city.ID IN (SELECT capital FROM country) "
                        + " AND country.Region = '" + region + "' "
                        + " ORDER BY Population DESC "
                        + " LIMIT "+n+"";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
            while (rset.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.Name = rset.getString("Name");
                capitalCity.Country = rset.getString("Country");
                capitalCity.Population = rset.getInt("Population");
                capitalCities.add(capitalCity);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
            return null;
        }
    }
}
