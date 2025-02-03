package org.webapp.savvy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.webapp.savvy.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}