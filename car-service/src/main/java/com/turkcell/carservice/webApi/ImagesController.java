package com.turkcell.carservice.webApi;

import com.turkcell.carservice.business.service.ImageManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("images")
public class ImagesController {

    private final ImageManager imageManager;

    public ImagesController(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String url = imageManager.uploadAndSave(file);
        return "File uploaded successfully: File path :  " + url;
    }
}
