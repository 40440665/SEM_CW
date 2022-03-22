package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

public class AppTest {
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
}
