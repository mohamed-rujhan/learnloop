package com.example.LearnLoop.service;

import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FirebaseStorageService {

    public String uploadFile(MultipartFile file) throws IOException {
        
        var bucket = StorageClient.getInstance().bucket();
        
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();

        bucket.create(fileName, file.getInputStream(), file.getContentType());

        return "https://storage.googleapis.com/" + bucket.getName() + "/" + fileName;
    }
}
