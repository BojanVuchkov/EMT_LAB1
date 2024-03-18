package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.model.Author;
import mk.ukim.finki.emt_lab1.model.Book;
import mk.ukim.finki.emt_lab1.model.enumerations.Category;
import mk.ukim.finki.emt_lab1.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt_lab1.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt_lab1.repository.AuthorRepository;
import mk.ukim.finki.emt_lab1.repository.BookRepository;
import mk.ukim.finki.emt_lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name, category, author, availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> rent(Long id) {
        Book book = findById(id).orElseThrow(()->new BookNotFoundException(id));
        if(book.getAvailableCopies()==0)
            return Optional.empty();
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        return Optional.of(book);
    }

}
