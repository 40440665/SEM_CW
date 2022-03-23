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
        //Create new application
        app = new App();

        //Connect to database
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testCitiesByPopulation()
    {
        ArrayList<City> cities = app.citiesByPopulation();
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }

    @Test
    void testGetAllCitiesInAContinent()
    {
        ArrayList<City> cities = app.getAllCitiesInAContinent("North America");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }

    @Test
    void testCitiesByDistrict()
    {
        ArrayList<City> cities = app.citiesByDistrict("California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        //assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }

    @Test
    void testNPopulatedCitiesInADistrict()
    {
        ArrayList<City> cities = app.NPopulatedCitiesInADistrict(1,"California");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        //assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }
}