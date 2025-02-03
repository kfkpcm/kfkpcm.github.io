package org.webapp.savvy.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text; // Question text
    private String answerType; // "open" or "closed"

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz; // The quiz this question belongs to

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers; // Answers associated with the question
}