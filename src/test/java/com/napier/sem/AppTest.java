package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
        app.nPopulatedCitiesInACountry(0, "France");
    }
    @Test
    void nPopulatedCitiesInCountryNull()
    {
        app.nPopulatedCitiesInACountry(1,null);
    }


    @Test
    void citiesByDistrictNull()
    {
        app.citiesByDistrict(null);
    }

    @Test
    void citiesByContinentNull()
    {
        app.citiesByContinent(null);
    }

    @Test
    void nPopulatedCitiesIs0()
    {
        app.nPopulatedCities(0);
    }

    @Test
    void citiesByRegionNull()
    {
        app.citiesByRegion(null);
    }

    @Test
    void citiesByCountryNull()
    {
        app.citiesByCountry(null);
    }

    @Test
    void nPopulatedCitiesInAContinentNIs0()
    {
        app.nPopulatedCitiesInAContinent(0, "Europe");
    }

    @Test
    void nPopulatedCitiesInAContinentNull()
    {
        app.nPopulatedCitiesInAContinent(1, null);
    }

    @Test
    void nPopulatedCitiesInARegionNIs0()
    {
        app.nPopulatedCitiesInARegion(0, "Caribbean");
    }

    @Test
    void nPopulatedCitiesInARegionNull()
    {
        app.nPopulatedCitiesInARegion(1, null);
    }

    @Test
    void nPopulatedCitiesInADistrictNIs0()
    {
        app.nPopulatedCitiesInADistrict(0, "Balkh");
    }

    @Test
    void nPopulatedCitiesInADistrictNull()
    {
        app.nPopulatedCitiesInADistrict(1, null);
    }

}
