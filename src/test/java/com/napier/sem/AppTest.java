package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.TestInstance;

public class AppTest
{
    static App app;

    @BeforeAll static void init()
    {
        app = new App();
    }

    @Test
    void printCitiesNull()
    {
        app.printCities(null);
    }

    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.ID = 3580;
        city.Name = "Moscow";
        city.CountryCode = "RUS";
        city.District = "Moscow (City)";
        city.Population = 207100;
        cities.add(city);
        app.printCities(cities);
    }

    @Test
    void nPopulatedCitiesInCountryNis0()
    {
        app.getNCitiesInACountry(0, "France");
    }
    @Test
    void nPopulatedCitiesInCountryNull()
    {
        app.getNCitiesInACountry(1,null);
    }


    @Test
    void citiesByDistrictNull()
    {
        app.citiesByDistrict(null);
    }

    @Test
    void getAllCitiesInAContinentNull()
    {
        app.getAllCitiesInAContinent(null);
    }

    @Test
    void NPopulatedCitiesIs0()
    {
        app.NPopulatedCities(0);
    }

    @Test
    void getAllCitiesInARegionNull()
    {
        app.getAllCitiesInARegion(null);
    }

    @Test
    void getAllCitiesInACountryNull()
    {
        app.getAllCitiesInACountry(null);
    }

    @Test
    void getNCitiesInAContinentNIs0()
    {
        app.getNCitiesInAContinent(0, "Europe");
    }

    @Test
    void getNCitiesInAContinentNull()
    {
        app.getNCitiesInAContinent(1, null);
    }

    @Test
    void getNCitiesInARegionNIs0()
    {
        app.getNCitiesInARegion(0, "Caribbean");
    }

    @Test
    void getNCitiesInARegionNull()
    {
        app.getNCitiesInARegion(1, null);
    }

    @Test
    void NPopulatedCitiesInADistrictNIs0()
    {
        app.NPopulatedCitiesInADistrict(0, "Balkh");
    }

    @Test
    void NPopulatedCitiesInADistrictNull()
    {
        app.NPopulatedCitiesInADistrict(1, null);
    }

}
