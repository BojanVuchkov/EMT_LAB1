package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
