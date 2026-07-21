package kg.attractor.movie_review.service;

import kg.attractor.movie_review.exception.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult result);

    ErrorResponseBody makeResponse(Exception e);
}
