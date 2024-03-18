package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
