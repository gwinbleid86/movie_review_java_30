package kg.attractor.movie_review.exception;

import java.util.NoSuchElementException;

public class CustomerNotFoundException extends NoSuchElementException {
    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
