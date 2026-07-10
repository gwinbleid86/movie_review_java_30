package kg.attractor.movie_review.controller;

import kg.attractor.movie_review.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("download")
    public ResponseEntity<?> download(@RequestParam(name = "filename") String filename) {
        return imageService.download(filename);
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) {
        return imageService.upload(file);
    }
}
