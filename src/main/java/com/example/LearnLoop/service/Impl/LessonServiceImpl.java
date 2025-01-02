package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.pmodel.Lesson;
import com.example.LearnLoop.prepository.LessonRepository;
import com.example.LearnLoop.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonById(String lessonId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        return lesson.orElse(null);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson updateLesson(String lessonId, Lesson lesson) {
        if (lessonRepository.existsById(lessonId)) {
            lesson.setLessonId(lessonId);
            return lessonRepository.save(lesson);
        }
        return null;
    }

    @Override
    public void deleteLesson(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}

