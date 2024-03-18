package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.model.Author;
import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt_lab1.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt_lab1.repository.AuthorRepository;
import mk.ukim.finki.emt_lab1.repository.CountryRepository;
import mk.ukim.finki.emt_lab1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        return Optional.of(authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author=findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }
}
