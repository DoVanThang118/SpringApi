package winho.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import winho.springapi.service.FileUploadService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") List<MultipartFile> files) throws IOException {
//        String uploadImage = fileUploadService.uploadImage(files);
//        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
        List<String> fileUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                String fileUrl = fileUploadService.uploadImage(file);
                fileUrls.add(fileUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(fileUrls);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = fileUploadService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }
}
