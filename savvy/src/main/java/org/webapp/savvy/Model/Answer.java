package org.webapp.savvy.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text; // The answer text
    private boolean isCorrect; // Whether the answer is correct or not

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question; // The question this answer belongs to
}