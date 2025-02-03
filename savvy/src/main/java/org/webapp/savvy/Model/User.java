package org.webapp.savvy.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "ADMIN", "TEACHER", "STUDENT"

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> enrolledCourses = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<Course> coursesTaught = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExamResult> examResults = new HashSet<>();

    @Column(nullable = false)
    private int currencyPoints = 0; // In-app currency for rewards

    // Constructors
    public User() {}

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Set<Course> getEnrolledCourses() { return enrolledCourses; }
    public void setEnrolledCourses(Set<Course> enrolledCourses) { this.enrolledCourses = enrolledCourses; }

    public Set<Course> getCoursesTaught() { return coursesTaught; }
    public void setCoursesTaught(Set<Course> coursesTaught) { this.coursesTaught = coursesTaught; }

    public Set<ExamResult> getExamResults() { return examResults; }
    public void setExamResults(Set<ExamResult> examResults) { this.examResults = examResults; }

    public int getCurrencyPoints() { return currencyPoints; }
    public void setCurrencyPoints(int currencyPoints) { this.currencyPoints = currencyPoints; }

    public void addCurrencyPoints(int points) { this.currencyPoints += points; }

}