package com.turkcell.carservice.business.service;

import com.cloudinary.Cloudinary;
import com.turkcell.carservice.dataAccess.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@Service
public class ImageManager {
    private final Cloudinary cloudinaryConfig;
    private final ImageRepository imageRepository;

    public ImageManager(Cloudinary cloudinaryConfig, ImageRepository imageRepository) {
        this.cloudinaryConfig = cloudinaryConfig;
        this.imageRepository = imageRepository;
    }

    public String uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            var uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, Collections.emptyMap());
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Error uploading file", e);
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }
}
