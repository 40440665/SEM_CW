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



    @Test
    void testCitiesByPopulation()
    {
        ArrayList<City> cities = app.citiesByPopulation();
        assertEquals(cities.get(0).Name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).CountryCode, "IND");
        assertEquals(cities.get(0).District , "Maharashtra");
        assertEquals(cities.get(0).Population , 10500000);
    }



    @Test
    void testGetAllCitiesInAContinent()
    {
        ArrayList<City> cities = app.getAllCitiesInAContinent("North America");
        assertEquals(cities.get(0).Name, "Ciudad de México");
        assertEquals(cities.get(0).CountryCode, "MEX");
        assertEquals(cities.get(0).District , "Distrito Federal");
        assertEquals(cities.get(0).Population , 8591309);
    }

    @Test
    void testCitiesByDistrict()
    {
        ArrayList<City> cities = app.citiesByDistrict("California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }





    @Test
    void testCitiesInARegion()
    {
        ArrayList<City> cities = app.getAllCitiesInARegion("Caribbean");
        assertEquals(cities.get(0).Name, "La Habana");
        assertEquals(cities.get(0).CountryCode, "CUB");
        assertEquals(cities.get(0).District , "La Habana");
        assertEquals(cities.get(0).Population , 2256000);
    }

    @Test
    void testCitiesInACountry()
    {
        ArrayList<City> cities = app.getAllCitiesInACountry("France");
        assertEquals(cities.get(0).Name, "Paris");
        assertEquals(cities.get(0).CountryCode, "FRA");
        assertEquals(cities.get(0).District , "Île-de-France");
        assertEquals(cities.get(0).Population , 2125246);
    }



    @Test
    void testNPopulatedCities()
    {
        ArrayList<City> cities = app.NPopulatedCities(4);
        assertEquals(cities.get(0).Name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).CountryCode, "IND");
        assertEquals(cities.get(0).District , "Maharashtra");
        assertEquals(cities.get(0).Population , 10500000);
    }




    @Test
    void testNPopulatedCitiesInAContinent()
    {
        ArrayList<City> cities = app.getNCitiesInAContinent(3,"Europe");
        assertEquals(cities.get(0).Name, "Moscow");
        assertEquals(cities.get(0).CountryCode, "RUS");
        assertEquals(cities.get(0).District , "Moscow (City)");
        assertEquals(cities.get(0).Population , 8389200);
    }






    @Test
    void testNPopulatedCitiesInARegion()
    {
        ArrayList<City> cities = app.getNCitiesInARegion(4, "Caribbean");
        assertEquals(cities.get(0).Name, "La Habana");
        assertEquals(cities.get(0).CountryCode, "CUB");
        assertEquals(cities.get(0).District , "La Habana");
        assertEquals(cities.get(0).Population , 2256000);
    }

    @Test
    void testNPopulatedCitiesInADistrict()
    {
        ArrayList<City> cities = app.NPopulatedCitiesInADistrict(6, "California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        //assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }




    @Test
    void testNPopulatedCitiesInACountry()
    {
        ArrayList<City> cities = app.getNCitiesInACountry(3, "France");
        assertEquals(cities.get(0).Name, "Paris");
        assertEquals(cities.get(0).CountryCode, "FRA");
        assertEquals(cities.get(0).District , "Île-de-France");
        assertEquals(cities.get(0).Population , 2125246);
    }
}