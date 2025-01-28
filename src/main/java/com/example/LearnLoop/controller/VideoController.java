package com.example.LearnLoop.controller;

import com.example.LearnLoop.model.Video;
import com.example.LearnLoop.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/upload")
    public Video uploadVideo(
            @RequestParam("title") String title,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) {
        return videoService.uploadVideo(title, price, description, file);
    }
}