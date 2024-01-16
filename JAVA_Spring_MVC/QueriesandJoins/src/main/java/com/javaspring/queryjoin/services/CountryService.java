package com.javaspring.queryjoin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.queryjoin.models.City;
import com.javaspring.queryjoin.models.Country;
import com.javaspring.queryjoin.models.Language;
import com.javaspring.queryjoin.repositories.CityRepository;
import com.javaspring.queryjoin.repositories.CountryRepository;
import com.javaspring.queryjoin.repositories.LanguageRepository;

@Service
public class CountryService {

  @Autowired
  private LanguageRepository langRepo;

  @Autowired
  private CountryRepository countryRepo;

  @Autowired
  private CityRepository cityRepo;

  public List<Country> findAllCountries() {
    return countryRepo.findAll();
  }

  public List<City> findAllCities() {
    return cityRepo.findAll();
  }

  public List<Language> findAllLanguages() {
    return langRepo.findAll();
  }

  // find all the countries that speak slovene
  public List<Object[]> findCountriesSpeakingSlovene() {
    return countryRepo.findAllCountries();
  }

  // find all number of cities

  public List<Object[]> findNumberOfCitiesPerCountry() {
    return countryRepo.findNumberOfCities();
  }

  // find all languages
  public List<Object[]> findPopulationInMexico() {
    return countryRepo.findPopulationOfCitiesInMixico();
  }

  public List<Object[]> findLanguages() {
    return countryRepo.allLanguagesByCountry();
  }

  public List<Object[]> findCountriesBySurfaceArea() {
    return countryRepo.allCountriesBySurfaceArea();
  }

  public List<Object[]> findCountriesByGovermentForm() {
    return countryRepo.allCountriesByGeovermentForm();
  }

  public List<Object[]> findCitiesInArgantina() {
    return countryRepo.allCitiesInArgantina();
  }

  public List<Object[]> numberRegion() {
    return countryRepo.allCountriesByRegion();
  }

}