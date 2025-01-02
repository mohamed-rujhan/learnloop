package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.pmodel.Student;
import com.example.LearnLoop.prepository.StudentRepository;
import com.example.LearnLoop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElse(null);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(String studentId, Student student) {
        if (studentRepository.existsById(studentId)) {
            student.setStudentId(studentId);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }
}

