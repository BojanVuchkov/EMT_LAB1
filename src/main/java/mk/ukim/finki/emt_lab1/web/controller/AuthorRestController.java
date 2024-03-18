package mk.ukim.finki.emt_lab1.web.controller;

import mk.ukim.finki.emt_lab1.model.Author;
import mk.ukim.finki.emt_lab1.model.Book;
import mk.ukim.finki.emt_lab1.model.enumerations.Category;
import mk.ukim.finki.emt_lab1.service.AuthorService;
import mk.ukim.finki.emt_lab1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    private List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam Long countryId) {
        return this.authorService.save(name,surname,countryId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> save(@PathVariable Long id,
                                     @RequestParam String name,
                                     @RequestParam String surname,
                                     @RequestParam Long countryId) {
        return this.authorService.edit(id, name,surname,countryId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id) {
        this.authorService.deleteById(id);
        if (this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}

