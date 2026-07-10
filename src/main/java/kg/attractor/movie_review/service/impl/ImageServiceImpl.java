package kg.attractor.movie_review.service.impl;

import kg.attractor.movie_review.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public ResponseEntity<?> download(String filename) {
        try {
            byte[] file = Files.readAllBytes(Paths.get("data/images/" + filename));

            Resource resource = new ByteArrayResource(file);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }
    }

    @Override
    public String upload(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String resultFilename = uuid + "_" + file.getOriginalFilename();

        try {
            Path pathDir = Paths.get("data/images");
            Files.createDirectories(pathDir);

            Path filePath = Paths.get(pathDir + "/" + resultFilename);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            try (OutputStream out = Files.newOutputStream(filePath)) {
                out.write(file.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultFilename;
    }
}
