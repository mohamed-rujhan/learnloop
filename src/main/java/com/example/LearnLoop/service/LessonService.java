package com.example.LearnLoop.service;

import java.util.List;

import com.example.LearnLoop.model.Lesson;

public interface LessonService {

    Lesson createLesson(Lesson lesson);

    List<Lesson> getAllLesson();

    Lesson getLessonById(String id);

    Lesson updateLesson(String id, Lesson lesson);

    void deleteLesson(String id);
}