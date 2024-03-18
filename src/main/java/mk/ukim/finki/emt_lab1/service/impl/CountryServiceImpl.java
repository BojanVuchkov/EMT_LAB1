package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt_lab1.repository.CountryRepository;
import mk.ukim.finki.emt_lab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }
}
