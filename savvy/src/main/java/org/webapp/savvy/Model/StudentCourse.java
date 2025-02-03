package org.webapp.savvy.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student; // The student who is enrolled in the course

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // The course the student is enrolled in

    private double grade; // Optional: store the grade for the student in the course
}