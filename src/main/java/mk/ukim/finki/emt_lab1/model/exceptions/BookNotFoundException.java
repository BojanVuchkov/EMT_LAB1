package mk.ukim.finki.emt_lab1.model.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super(String.format("Book with id %d does not exist.", bookId));
    }
}
