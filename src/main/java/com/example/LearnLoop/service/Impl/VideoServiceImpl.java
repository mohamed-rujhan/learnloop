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
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    private static final String BUCKET_NAME = "power-cal.appspot.com";

    @Override
    public Video uploadVideo(String title, int price, String description, MultipartFile videoFile, MultipartFile coverImage) {
        try {
            // Upload video to Firebase Storage
            String videoFileName = UUID.randomUUID().toString() + "_" + videoFile.getOriginalFilename();
            String videoUrl = uploadToFirebase(videoFile, videoFileName);

            // Upload cover image to Firebase Storage
            String coverImageFileName = UUID.randomUUID().toString() + "_" + coverImage.getOriginalFilename();
            String coverImageUrl = uploadToFirebase(coverImage, coverImageFileName);

            // Save to MongoDB
            Video video = new Video();
            video.setTitle(title);
            video.setPrice(price);
            video.setDescription(description);
            video.setVideoUrl(videoUrl);
            video.setCoverImageUrl(coverImageUrl); // Set cover image URL
            return videoRepository.save(video);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload video or cover image", e);
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