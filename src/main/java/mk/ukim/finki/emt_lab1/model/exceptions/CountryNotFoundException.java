package mk.ukim.finki.emt_lab1.model.exceptions;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(Long countryId) {
        super(String.format("Country with id %d does not exist.", countryId));
    }
}