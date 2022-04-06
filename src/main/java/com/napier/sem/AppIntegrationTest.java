package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }
    /**
     * Tests the citiesByPopulation method
     *
     * The method should return the details of the city Mumbai
     */
    @Test
    void testCitiesByPopulation()
    {
        ArrayList<City> cities = app.citiesByPopulation();
        assertEquals(cities.get(0).Name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).CountryCode, "IND");
        assertEquals(cities.get(0).District , "Maharashtra");
        assertEquals(cities.get(0).Population , 10500000);
    }

    /**
     * Tests the citiesByContinent method
     *
     * The method should return the details of the city Ciudad de México
     */
    @Test
    void testCitiesByContinent()
    {
        ArrayList<City> cities = app.citiesByContinent("North America");
        assertEquals(cities.get(0).Name, "Ciudad de México");
        assertEquals(cities.get(0).CountryCode, "MEX");
        assertEquals(cities.get(0).District , "Distrito Federal");
        assertEquals(cities.get(0).Population , 8591309);
    }

    /**
     * Tests the citiesByDistrict method
     *
     * The method should return the details of the city Los Angeles
     */
    @Test
    void testCitiesByDistrict()
    {
        ArrayList<City> cities = app.citiesByDistrict("California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }

    /**
     * Tests the citiesByRegion method
     *
     * The method should return the details of the city La Habana
     */
    @Test
    void testCitiesByRegion()
    {
        ArrayList<City> cities = app.citiesByRegion("Caribbean");
        assertEquals(cities.get(0).Name, "La Habana");
        assertEquals(cities.get(0).CountryCode, "CUB");
        assertEquals(cities.get(0).District , "La Habana");
        assertEquals(cities.get(0).Population , 2256000);
    }

    /**
     * Tests the citiesByCountry method
     *
     * The method should return the details of the city Paris
     */
    @Test
    void testCitiesByCountry()
    {
        ArrayList<City> cities = app.citiesByCountry("France");
        assertEquals(cities.get(0).Name, "Paris");
        assertEquals(cities.get(0).CountryCode, "FRA");
        assertEquals(cities.get(0).District , "Île-de-France");
        assertEquals(cities.get(0).Population , 2125246);
    }

    /**
     * Tests the nPopulatedCities method
     *
     * The method should return the details of the city Mumbai
     */
    @Test
    void testNPopulatedCities()
    {
        ArrayList<City> cities = app.nPopulatedCities(4);
        assertEquals(cities.get(0).Name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).CountryCode, "IND");
        assertEquals(cities.get(0).District , "Maharashtra");
        assertEquals(cities.get(0).Population , 10500000);
    }

    /**
     * Tests the nPopulatedCitiesInAContinent method
     *
     * The method should return the details of the city Moscow
     */
    @Test
    void testNPopulatedCitiesInAContinent()
    {
        ArrayList<City> cities = app.nPopulatedCitiesInAContinent(3,"Europe");
        assertEquals(cities.get(0).Name, "Moscow");
        assertEquals(cities.get(0).CountryCode, "RUS");
        assertEquals(cities.get(0).District , "Moscow (City)");
        assertEquals(cities.get(0).Population , 8389200);
    }

    /**
     * Tests the nPopulatedCitiesInARegion method
     *
     * The method should return the details of the city La Habana
     */
    @Test
    void testNPopulatedCitiesInARegion()
    {
        ArrayList<City> cities = app.nPopulatedCitiesInARegion(4, "Caribbean");
        assertEquals(cities.get(0).Name, "La Habana");
        assertEquals(cities.get(0).CountryCode, "CUB");
        assertEquals(cities.get(0).District , "La Habana");
        assertEquals(cities.get(0).Population , 2256000);
    }

    /**
     * Tests the nPopulatedCitiesInADistrict method
     *
     * The method should return the details of the city Los Angeles
     */
    @Test
    void testNPopulatedCitiesInADistrict()
    {
        ArrayList<City> cities = app.nPopulatedCitiesInADistrict(6, "California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).Population , 3694820);
    }

    /**
     * Tests the nPopulatedCitiesInACountry method
     *
     * The method should return the details of the city Paris
     */
    @Test
    void testNPopulatedCitiesInACountry()
    {
        ArrayList<City> cities = app.nPopulatedCitiesInACountry(3, "France");
        assertEquals(cities.get(0).Name, "Paris");
        assertEquals(cities.get(0).CountryCode, "FRA");
        assertEquals(cities.get(0).District , "Île-de-France");
        assertEquals(cities.get(0).Population , 2125246);
    }

    // Country Tests

    /**
    * Tests the countriesByPopulation  method
    *
    * The method should return the details of the country China
    */
    @Test
    void testCountriesByPopulation()
    {
        ArrayList<Country> countries = app.countriesByPopulation();
        assertEquals(countries.get(0).Code, "CHN");
        assertEquals(countries.get(0).Name, "China");
        assertEquals(countries.get(0).Continent, "Asia");
        assertEquals(countries.get(0).Region , "Eastern Asia");
        assertEquals(countries.get(0).Population , 1277558000);
        assertEquals(countries.get(0).Capital, "1891");
    }

    /**
     * Tests the countriesByContinent method
     *
     * The method should return the details of the country Russian
     */
    @Test
    void testCountriesByContinent()
    {
        ArrayList<Country> countries = app.countriesByContinent("Europe");
        assertEquals(countries.get(0).Code, "RUS");
        assertEquals(countries.get(0).Name, "Russian Federation");
        assertEquals(countries.get(0).Continent, "Europe");
        assertEquals(countries.get(0).Region , "Eastern Europe");
        assertEquals(countries.get(0).Population , 146934000);
        assertEquals(countries.get(0).Capital, "3580");
    }

    /**
     * Tests the countriesByRegion method
     *
     * The method should return the details of the country Cuba
     */
    @Test
    void testCountriesByRegion()
    {
        ArrayList<Country> countries = app.countriesByRegion("Caribbean");
        assertEquals(countries.get(0).Code, "CUB");
        assertEquals(countries.get(0).Name, "Cuba");
        assertEquals(countries.get(0).Continent, "North America");
        assertEquals(countries.get(0).Region , "Caribbean");
        assertEquals(countries.get(0).Population , 11201000);
        assertEquals(countries.get(0).Capital, "2413");
    }

    /**
     * Tests the nPopulatedCountries method
     *
     * The method should return the details of the country China
     */
    @Test
    void testNPopulatedCountries()
    {
        ArrayList<Country> countries = app.nPopulatedCountries(4);
        assertEquals(countries.get(0).Code, "CHN");
        assertEquals(countries.get(0).Name, "China");
        assertEquals(countries.get(0).Continent, "Asia");
        assertEquals(countries.get(0).Region , "Eastern Asia");
        assertEquals(countries.get(0).Population , 1277558000);
        assertEquals(countries.get(0).Capital, "1891");
    }

    /**
     * Tests the nPopulatedCountriesInAContinent method
     *
     * The method should return the details of the country Russia
     */
    @Test
    void testNPopulatedCountriesInAContinent()
    {
        ArrayList<Country> countries = app.nPopulatedCountriesInAContinent(3, "Europe");
        assertEquals(countries.get(0).Code, "RUS");
        assertEquals(countries.get(0).Name, "Russian Federation");
        assertEquals(countries.get(0).Continent, "Europe");
        assertEquals(countries.get(0).Region , "Eastern Europe");
        assertEquals(countries.get(0).Population , 146934000);
        assertEquals(countries.get(0).Capital, "3580");
    }

    /**
     * Tests the nPopulatedCountriesInARegion method
     *
     * The method should return the details of the country Cuba
     */
    @Test
    void testNPopulatedCountriesInARegion()
    {
        ArrayList<Country> countries = app.nPopulatedCountriesInARegion(4, "Caribbean");
        assertEquals(countries.get(0).Code, "CUB");
        assertEquals(countries.get(0).Name, "Cuba");
        assertEquals(countries.get(0).Continent, "North America");
        assertEquals(countries.get(0).Region , "Caribbean");
        assertEquals(countries.get(0).Population , 11201000);
        assertEquals(countries.get(0).Capital, "2413");
    }
}