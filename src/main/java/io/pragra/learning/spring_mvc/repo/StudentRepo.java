package io.pragra.learning.spring_mvc.repo;

import io.pragra.learning.spring_mvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
