package winho.springapi.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import winho.springapi.config.FileUploadUtil;
import winho.springapi.entity.FileUpload;
import winho.springapi.repository.FileUploadRepository;
import winho.springapi.service.FileUploadService;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        FileUpload fileUpload = fileUploadRepository.save(FileUpload.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(FileUploadUtil.compressImage(file.getBytes())).build());
        if (fileUpload != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public byte[] downloadImage(String fileName) {
        Optional<FileUpload> dbImageData = fileUploadRepository.findByName(fileName);
        byte[] images = FileUploadUtil.decompressImage(dbImageData.get().getImage());
        return images;
    }
}
