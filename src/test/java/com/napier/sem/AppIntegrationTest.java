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



    ///////////////////////////// CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!
    @Test
    void testCitiesByPopulation()
    {
        ArrayList<City> cities = app.citiesByPopulation();
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }



    ///////////////////////////// CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!
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




    ///////////////////////////// CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!

    @Test
    void testCitiesInARegion()
    {
        ArrayList<City> cities = app.getAllCitiesInARegion("Caribbean");
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
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


    ///////////////////////////// CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!

    @Test
    void testNPopulatedCities()
    {
        ArrayList<City> cities = app.NPopulatedCities(4);
        assertEquals(cities.get(0).Name, "Los Angeles");
        assertEquals(cities.get(0).CountryCode, "USA");
        //assertEquals(cities.get(0).District , "California");
        assertEquals(cities.get(0).Population , 3694820);
    }


    ///////////////////////////// MAYBE???????????? CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!


    @Test
    void testNPopulatedCitiesInAContinent()
    {
        ArrayList<City> cities = app.getNCitiesInAContinent(3,"Europe");
        assertEquals(cities.get(0).Name, "Moscow");
        assertEquals(cities.get(0).CountryCode, "RUS");
        assertEquals(cities.get(0).District , "Moscow (City)");
        assertEquals(cities.get(0).Population , 8389200);
    }




    ///////////////////////////// CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!


    @Test
    void testNPopulatedCitiesInARegion()
    {
        ArrayList<City> cities = app.getNCitiesInARegion(4, "Caribbean");
        assertEquals(cities.get(0).Name, "Moscow");
        assertEquals(cities.get(0).CountryCode, "RUS");
        assertEquals(cities.get(0).District , "Moscow (City)");
        assertEquals(cities.get(0).Population , 8389200);
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



    ///////////////////////////// MAYBE???????????? CHANGE THESE TEST VALUES!!!!!!!!!!!!!!!!!!


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