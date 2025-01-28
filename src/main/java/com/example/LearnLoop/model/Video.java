package com.example.LearnLoop.model;

//import java.sql.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Videos")
public class Video{

    @Id
    private String id; 
    private String title;
    private int price;
    private String description;
    private String videoUrl;
   // private Date uploadDate;
    
}
