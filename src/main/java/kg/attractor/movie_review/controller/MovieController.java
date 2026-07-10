package kg.attractor.movie_review.controller;

import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.movie_review.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {

    @GetMapping
    public List<MovieDto> getMovies() {
        return List.of(MovieDto.builder()
                .title("Harry Potter")
                .director("Some director")
                .releaseYear(2000)
                .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Integer id) {
        return new ResponseEntity<>(
                MovieDto.builder()
                        .title("Harry Potter")
                        .director("Some director")
                        .releaseYear(2000)
                        .build(),
                HttpStatus.OK);
    }

    @PostMapping
    public HttpStatus createMovie(MovieDto dto, HttpServletRequest request) {
        System.out.println(dto.toString());
        System.out.println(request.getRequestURI());
        return HttpStatus.OK;
    }
}
