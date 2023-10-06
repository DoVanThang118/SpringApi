package winho.springapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileUploadService {

    String uploadImage(MultipartFile file) throws IOException;

    byte[] downloadImage(String fileName);
}
