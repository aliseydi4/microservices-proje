package com.turkcell.carservice.business.service;

import com.cloudinary.Cloudinary;
import com.turkcell.carservice.dataAccess.ImageRepository;
import com.turkcell.carservice.entities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Service
public class ImageManager {
    private final Cloudinary cloudinaryConfig;
    private final ImageRepository imageRepository;

    public ImageManager(Cloudinary cloudinaryConfig, ImageRepository imageRepository) {
        this.cloudinaryConfig = cloudinaryConfig;
        this.imageRepository = imageRepository;
    }

    public String uploadAndSave(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map<?, ?> uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, Collections.emptyMap());
            String imageUrl = uploadResult.get("url").toString();

            Image image = new Image();
            image.setUrl(new URL(imageUrl));

            imageRepository.save(image);

            return imageUrl;
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
