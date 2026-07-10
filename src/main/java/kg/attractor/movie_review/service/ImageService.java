package kg.attractor.movie_review.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ResponseEntity<?> download(String filename);

    String upload(MultipartFile file);
}
