package com.example.LearnLoop.service;

import com.example.LearnLoop.model.Video;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    Video uploadVideo(String title, int price, String description, MultipartFile videoFile, MultipartFile coverImage);
}