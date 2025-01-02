package com.example.LearnLoop.pcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearnLoop.pmodel.Lesson;
import com.example.LearnLoop.pservice.LessonService;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson createdLesson = this.lessonService.createLesson(lesson);
        return ResponseEntity.ok(createdLesson);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable String lessonId) {
        Lesson lesson = this.lessonService.getLessonById(lessonId);
        return lesson != null ? ResponseEntity.ok(lesson) :
            ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAlllessons() {
        List<Lesson> lessons = this.lessonService.getAllLesson();
        return ResponseEntity.ok(lessons);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable String lessonId, @RequestBody Lesson lesson) {
        Lesson updatedLesson = this.lessonService.updateLesson(lessonId, lesson);
        return updatedLesson != null ? ResponseEntity.ok(updatedLesson) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{lessonId}"})
    public ResponseEntity<Void> deleteLesson(@PathVariable String lessonId) {
        this.lessonService.deleteLesson(lessonId);
        return ResponseEntity.noContent().build();
    }
}

