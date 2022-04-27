package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }


    // COUNTRY METHODS TESTS

    /**
     * Tests the countriesByPopulation method
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
        assertEquals(countries.get(0).Region, "Eastern Asia");
        assertEquals(countries.get(0).Population, 1277558000);
        assertEquals(countries.get(0).Capital, "1891");
    }

    /**
     * Tests the countriesByContinent method
     *
     * The method should return the details of the country Russia
     */
    @Test
    void testCountriesByContinent()
    {
        ArrayList<Country> countries = app.countriesByContinent("Europe");
        assertEquals(countries.get(0).Code, "RUS");
        assertEquals(countries.get(0).Name, "Russian Federation");
        assertEquals(countries.get(0).Continent, "Europe");
        assertEquals(countries.get(0).Region, "Eastern Europe");
        assertEquals(countries.get(0).Population, 146934000);
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
        assertEquals(countries.get(0).Region, "Caribbean");
        assertEquals(countries.get(0).Population, 11201000);
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
        assertEquals(countries.get(0).Region, "Eastern Asia");
        assertEquals(countries.get(0).Population, 1277558000);
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
        ArrayList<Country> countries = app.nPopulatedCountriesInAContinent(4, "Europe");
        assertEquals(countries.get(0).Code, "RUS");
        assertEquals(countries.get(0).Name, "Russian Federation");
        assertEquals(countries.get(0).Continent, "Europe");
        assertEquals(countries.get(0).Region, "Eastern Europe");
        assertEquals(countries.get(0).Population, 146934000);
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
        ArrayList<Country> countries = app.nPopulatedCountriesInARegion(3, "Caribbean");
        assertEquals(countries.get(0).Code, "CUB");
        assertEquals(countries.get(0).Name, "Cuba");
        assertEquals(countries.get(0).Continent, "North America");
        assertEquals(countries.get(0).Region, "Caribbean");
        assertEquals(countries.get(0).Population, 11201000);
        assertEquals(countries.get(0).Capital, "2413");
    }



    // CITY METHODS TESTS

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



    // CAPITAL CITY METHODS TESTS

    /**
     * Tests the capitalCitiesByPopulation method
     *
     * The method should return the details of the city Seoul
     */
    @Test
    void testCapitalCitiesByPopulation()
    {
        ArrayList<CapitalCity> capitalCities = app.capitalCitiesByPopulation();
        assertEquals(capitalCities.get(0).Name, "Seoul");
        assertEquals(capitalCities.get(0).Country, "South Korea");
        assertEquals(capitalCities.get(0).Population , 9981619);
    }

    /**
     * Tests the capitalCitiesByContinent method
     *
     * The method should return the details of the city Moscow
     */
    @Test
    void testCapitalCitiesByContinent()
    {
        ArrayList<CapitalCity> capitalCities = app.capitalCitiesByContinent("Europe");
        assertEquals(capitalCities.get(0).Name, "Moscow");
        assertEquals(capitalCities.get(0).Country, "Russian Federation");
        assertEquals(capitalCities.get(0).Population , 8389200);
    }

    /**
     * Tests the capitalCitiesByRegion method
     *
     * The method should return the details of the city La Habana
     */
    @Test
    void testCapitalCitiesByRegion()
    {
        ArrayList<CapitalCity> capitalCities = app.capitalCitiesByRegion("Caribbean");
        assertEquals(capitalCities.get(0).Name, "La Habana");
        assertEquals(capitalCities.get(0).Country, "Cuba");
        assertEquals(capitalCities.get(0).Population , 2256000);
    }


    /**
     * Tests the nPopulatedCapitalCities method
     *
     * The method should return the details of the city Seoul
     */
    @Test
    void testNPopulatedCapitalCities()
    {
        ArrayList<CapitalCity> capitalCities = app.nPopulatedCapitalCities(4);
        assertEquals(capitalCities.get(0).Name, "Seoul");
        assertEquals(capitalCities.get(0).Country, "South Korea");
        assertEquals(capitalCities.get(0).Population , 9981619);
    }

    /**
     * Tests the nPopulatedCapitalCitiesInAContinent method
     *
     * The method should return the details of the city Russia
     */
    @Test
    void testNPopulatedCapitalCitiesInAContinent()
    {
        ArrayList<CapitalCity> capitalCities = app.nPopulatedCapitalCitiesInAContinent(3, "Europe");
        assertEquals(capitalCities.get(0).Name, "Moscow");
        assertEquals(capitalCities.get(0).Country, "Russian Federation");
        assertEquals(capitalCities.get(0).Population , 8389200);
    }

    /**
     * Tests the nPopulatedCapitalCitiesInARegion method
     *
     * The method should return the details of the city La Habana
     */
    @Test
    void testNPopulatedCapitalCitiesInARegion()
    {
        ArrayList<CapitalCity> capitalCities = app.nPopulatedCapitalCitiesInARegion(4, "Caribbean");
        assertEquals(capitalCities.get(0).Name, "La Habana");
        assertEquals(capitalCities.get(0).Country, "Cuba");
        assertEquals(capitalCities.get(0).Population , 2256000);
    }



    // POPULATION METHODS TESTS

    /**
     * Tests the worldPopulation method
     *
     * The method should return the population of the world
     */
    @Test
    void testWorldPopulation()
    {
        String worldPop = app.worldPopulation();
        assertEquals(worldPop, "World population is 6078749450");
    }

    /**
     * Tests the continentPopulation method
     *
     * The method should return the population details of the continent Europe
     */
    @Test
    void testContinentPopulation()
    {
        Population report = app.continentPopulation("Europe");
        assertEquals(report.Name, "Europe");
        assertEquals(report.Population, 730074600);
        assertEquals(report.PopulationInCities, 241942813);
        assertEquals(report.PercentInCities , 33.1);
        assertEquals(report.PopulationNotInCities, 488131787);
        assertEquals(report.PercentNotInCities, 66.9);
    }

    /**
     * Tests the regionPopulation method
     *
     * The method should return the population details of the region Caribbean
     */
    @Test
    void testRegionPopulation()
    {
        Population report = app.regionPopulation("Caribbean");
        assertEquals(report.Name, "Caribbean");
        assertEquals(report.Population, 38140000);
        assertEquals(report.PopulationInCities, 11067550);
        assertEquals(report.PercentInCities, 29.0);
        assertEquals(report.PopulationNotInCities, 27072450);
        assertEquals(report.PercentNotInCities, 71.0);
    }

    /**
     * Tests the countryPopulation method
     *
     * The method should return the population details of the country France
     */
    @Test
    void testCountryPopulation()
    {
        Population report = app.countryPopulation("FRA");
        assertEquals(report.Name, "France");
        assertEquals(report.Population, 59225700);
        assertEquals(report.PopulationInCities, 9244494);
        assertEquals(report.PercentInCities , 15.6);
        assertEquals(report.PopulationNotInCities, 49981206);
        assertEquals(report.PercentNotInCities, 84.4);
    }

    /**
     * Tests the districtPopulation method
     *
     * The method should return the population of the district Zuid-Holland
     */
    @Test
    void testDistrictPopulation()
    {
        String districtPop = app.districtPopulation("Zuid-Holland");
        assertEquals(districtPop, "Zuid-Holland's population is 1476710");
    }

    /**
     * Tests the districtPopulation method
     *
     * The method should return the population of the city Paris
     */
    @Test
    void testCityPopulation()
    {
        String cityPop = app.cityPopulation("Paris");
        assertEquals(cityPop, "Paris's population is 2125246");
    }

    // LANGUAGE REPORT TEST

    /**
     * Tests the languageReport method
     *
     * The method should return the population details of the language Chinese
     */
    @Test
    void testLanguageReport()
    {
        ArrayList<Language> languageReport = app.languageReport();
        assertEquals(languageReport.get(0).Language, "Chinese");
        assertEquals(languageReport.get(0).Speakers, 1191843539);
        assertEquals(languageReport.get(0).PercentageOfWorldPopulation , 19.61);
    }

}