package com.example.LearnLoop.controller;

import com.example.LearnLoop.model.Video;
import com.example.LearnLoop.service.VideoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173") 
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
            @RequestParam("videoFile") MultipartFile videoFile,
            @RequestParam("coverImage") MultipartFile coverImage) {
        return videoService.uploadVideo(title, price, description, videoFile, coverImage);
    }
    
    @GetMapping
public List<Video> getAllVideos() {
    return videoService.getAllVideos();
}

}