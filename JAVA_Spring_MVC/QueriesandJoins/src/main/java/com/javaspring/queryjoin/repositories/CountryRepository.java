package com.javaspring.queryjoin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.queryjoin.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAll();

    /*
     * Task 1 :
     * What query would you run to get all the countries that speak Slovene? Your
     * query should return the name of the country,
     * language, and language percentage
     * . Your query should arrange the result by language percentage in descending
     * order.
     */

    @Query(value = "SELECT countries.name, languages.language , languages.percentage FROM countries " +
            "INNER JOIN languages  ON " +
            "countries.code = languages.country_code "
            + "WHERE language='Slovene' "
            + "ORDER BY percentage DESC ", nativeQuery = true)
    List<Object[]> findAllCountries();

    /*
     * Task 2 :
     * What query would you run to display the total number of cities for each
     * country? Your query should
     * return the name of the country and the total number of cities.
     * Your query should arrange the result by the number of cities in descending
     * order.
     */

    @Query(value = "SELECT countries.name, COUNT(cities.id) AS city_count " +
            "FROM countries " +
            "LEFT JOIN cities ON countries.Code = cities.country_code " +
            "GROUP BY countries.name " +
            "ORDER BY city_count DESC", nativeQuery = true)
    List<Object[]> findNumberOfCities();

    /*
     * Task 3 :
     * What query would you run to get all the cities in Mexico with a population of
     * greater than 500,000?
     * Your query should arrange the result by population in descending order.
     */

    @Query(value = "SELECT  cities.name , cities.population from countries " +
            "left join cities on countries.Code = cities.country_code " +
            " where countries.name ='Mexico' and cities.population > 500000" +
            " order by cities.population desc ", nativeQuery = true)
    List<Object[]> findPopulationOfCitiesInMixico();

    /*
     * Task 4 :
     * What query would you run to get all languages in each country with a
     * percentage greater than 89%?
     * Your query should arrange the result by percentage in descending order.
     */

    @Query(value = "SELECT countries.name, languages.language, languages.percentage " +
            "FROM countries " +
            "LEFT JOIN languages ON countries.code = languages.country_code " +
            "WHERE languages.percentage > 0.89 " +
            "ORDER BY languages.percentage DESC", nativeQuery = true)
    List<Object[]> allLanguagesByCountry();

    /*
     * Task 5 :
     * What query would you run to get all the countries with Surface Area below 501
     * and Population greater than 100,000?
     */

    @Query(value = "select countries.name, countries.surface_area , countries.population  from countries " +
            "where countries.surface_area  < 501 and countries.population > 100000", nativeQuery = true)
    List<Object[]> allCountriesBySurfaceArea();

    /*
     * Task 6 :
     * What query would you run to get countries with only Constitutional Monarchy
     * with a surface area of more than 200 and
     * a life expectancy greater than 75 years?
     */

    @Query(value = "select countries.name, countries.government_form , countries.capital, countries.life_expectancy from countries " +
            "where countries.government_form ='Constitutional Monarchy' AND countries.capital >200 AND  countries.life_expectancy > 75", nativeQuery = true)
    List<Object[]> allCountriesByGeovermentForm();

    /*
     * Task 7 :
     * What query would you run to get all the cities of Argentina inside the Buenos
     * Aires district and have the population greater than 500, 000?
     * The query should return the Country Name, City Name, District, and
     * Population.
     */
    @Query(value = "select cities.name, countries.name, cities.district ,cities.population from countries " +
            "left join cities on countries.code =cities.country_code " +
            "where countries.name='Argentina' and cities.district='Buenos Aires' AND cities.population > 500000 ", nativeQuery = true)
    List<Object[]> allCitiesInArgantina();

    /*
     * Task 8 :
     * What query would you run to summarize the number of countries in each region?
     * The query should display the name of the region and the number of countries.
     * Also, the query should arrange the result by the number of countries in
     * descending order.
     */
    
    @Query(value = "SELECT region, COUNT(*) AS country_count from countries " +
            "GROUP BY region " +
            "ORDER BY country_count DESC", nativeQuery = true)
    List<Object[]> allCountriesByRegion();

}
