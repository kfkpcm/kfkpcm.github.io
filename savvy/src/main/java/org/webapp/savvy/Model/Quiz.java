package org.webapp.savvy.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // The course the quiz belongs to

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions; // List of questions in the quiz
}