package com.bishwajit.simplesearchapplication.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String score;
    private String comment;
    public Interview(String score, String comment){
        this.score = score;
        this.comment = comment;
    }
}
