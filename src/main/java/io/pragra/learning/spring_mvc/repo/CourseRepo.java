package io.pragra.learning.spring_mvc.repo;

import io.pragra.learning.spring_mvc.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
}
