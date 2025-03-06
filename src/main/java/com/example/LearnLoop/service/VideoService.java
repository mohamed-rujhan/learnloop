package com.example.LearnLoop.service;

import com.example.LearnLoop.model.Video;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    Video uploadVideo(String title, int price, String description, MultipartFile videoFile, MultipartFile coverImage);

    List<Video> getAllVideos();

    Video getVideoById(String id);

}