package com.turkcell.carservice.dataAccess;

import com.cloudinary.Url;
import com.turkcell.carservice.entities.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image,String> {
    void save(Url imageUrl);
}
