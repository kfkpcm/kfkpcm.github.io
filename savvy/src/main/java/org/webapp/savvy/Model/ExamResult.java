package org.webapp.savvy.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_results")
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @Column(nullable = false)
    private double score;

    @Column(nullable = false)
    private boolean passed;

    // Constructors
    public ExamResult() {}

    public ExamResult(User user, Exam exam, double score, boolean passed) {
        this.user = user;
        this.exam = exam;
        this.score = score;
        this.passed = passed;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }
}