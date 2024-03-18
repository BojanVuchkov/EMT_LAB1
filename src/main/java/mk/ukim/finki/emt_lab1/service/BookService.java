package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.model.Book;
import mk.ukim.finki.emt_lab1.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> rent(Long id);
}
