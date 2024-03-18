package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
