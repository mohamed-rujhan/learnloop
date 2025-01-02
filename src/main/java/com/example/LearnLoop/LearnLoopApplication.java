package com.example.LearnLoop;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class LearnLoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnLoopApplication.class, args);

        try {
			FileInputStream serviceAccount =
			new FileInputStream("src/main/resources/firebase/firebase-admins");
		

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("your-project-id.appspot.com") // Your Firebase Storage bucket
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase initialized successfully!");
        } catch (IOException e) {
            System.err.println("Error initializing Firebase: " + e.getMessage());
        }
    }
}
