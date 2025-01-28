package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.model.Video;
import com.example.LearnLoop.repository.VideoRepository;
import com.example.LearnLoop.service.VideoService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Date;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    private static final String BUCKET_NAME = "power-cal.appspot.com";

    @Override
    public Video uploadVideo(String title, int price, String description, MultipartFile file) {
        try {
            // Upload to Firebase Storage
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String firebaseUrl = uploadToFirebase(file, fileName);

            // Save to MongoDB
            Video video = new Video();
            video.setTitle(title);
            video.setPrice(price);
            video.setDescription(description);
            video.setVideoUrl(firebaseUrl);
            //video.setUploadDate((java.sql.Date) new Date(System.currentTimeMillis()));
            return videoRepository.save(video);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload video", e);
        }
    }

    private String uploadToFirebase(MultipartFile file, String fileName) throws IOException {
        // Load Firebase credentials
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("src/main/resources/firebase/firebase-admins.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        // Upload file to Firebase Storage
        Bucket bucket = storage.get(BUCKET_NAME);
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());

        return blob.getMediaLink();
    }
}