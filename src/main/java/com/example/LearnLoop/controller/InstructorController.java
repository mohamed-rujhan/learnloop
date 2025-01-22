package com.example.LearnLoop.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import com.example.LearnLoop.model.Instructor;
import com.example.LearnLoop.service.FirebaseStorageService;
import com.example.LearnLoop.service.InstructorService;

@RestController
@RequestMapping({"/api/instructors"})
@CrossOrigin(origins = "http://localhost:5173")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    public InstructorController(){}

    @PostMapping
    public ResponseEntity <Instructor> createInstructor(@RequestBody Instructor instructor){
        Instructor createdInstructor =this.instructorService.createInstructor(instructor);
        return ResponseEntity.ok(createdInstructor);
    }

    @GetMapping({"/{instructorId}"})
    public ResponseEntity<Instructor> getInstructorById(@PathVariable String instructorId) 
    {
    Instructor instructor = this.instructorService.getInstructorById(instructorId);
    return instructor != null ? ResponseEntity.ok(instructor) :
    ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() //get all instructors
    {
    List<Instructor> instructor = this.instructorService.getAllInstructors();
    return ResponseEntity.ok(instructor);
    }

    @PutMapping({"/{instructorId}"})
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String instructorId,@RequestBody Instructor instructor) 
    {
    Instructor updatedInstructor = this.instructorService.updateInstructor(instructorId, instructor);
    return updatedInstructor != null ? ResponseEntity.ok(updatedInstructor) :
    ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{instructorId}"})
    public ResponseEntity<Void> deleteInstructor(@PathVariable String instructorId) 
    {
    this.instructorService.deleteInstructor(instructorId);
    return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
@Operation(
    summary = "Upload a file",
    description = "Allows instructors to upload files (e.g., tutorial videos, documents).",
    responses = {
        @ApiResponse(responseCode = "200", description = "File uploaded successfully.", content = @Content(schema = @Schema(type = "string"))),
        @ApiResponse(responseCode = "500", description = "Failed to upload file.")
    }
)
public ResponseEntity<String> uploadFile(
    @RequestParam("file") 
    @io.swagger.v3.oas.annotations.Parameter(description = "File to upload", required = true, schema = @Schema(type = "string", format = "binary")) 
    MultipartFile file) {
    try {
        String fileUrl = firebaseStorageService.uploadFile(file);
        return ResponseEntity.ok(fileUrl);
    } catch (IOException e) {
        return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
    }
}

}