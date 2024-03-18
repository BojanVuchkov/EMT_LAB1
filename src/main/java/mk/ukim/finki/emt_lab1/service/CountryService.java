package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.model.Book;
import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    void deleteById(Long id);

    Optional<Country> edit(Long id, String name, String continent);

}
