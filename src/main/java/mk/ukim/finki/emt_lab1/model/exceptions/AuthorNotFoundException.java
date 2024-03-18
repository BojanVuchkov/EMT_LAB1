package mk.ukim.finki.emt_lab1.model.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long authorId) {
        super(String.format("Author with id %d does not exist.", authorId));
    }
}