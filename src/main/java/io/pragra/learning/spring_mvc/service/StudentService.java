package io.pragra.learning.spring_mvc.service;

import io.pragra.learning.spring_mvc.entity.Course;
import io.pragra.learning.spring_mvc.entity.Student;
import io.pragra.learning.spring_mvc.exception.StudentNotFoundException;
import io.pragra.learning.spring_mvc.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // this will generate constructor for this class
public class StudentService {
    private final StudentRepo repo;// we can either use manual constructor or anotation as above

   public List<Student> getAll(){
    return  repo.findAll();

}
public Student createStudent(Student student){
    return repo.save(student);
}

public Student entolledCourse(Long studentId, Course course){
    Optional<Student> studentOptional = repo.findById(studentId);
    if (studentOptional.isPresent()){
   studentOptional.get().getEntolledCourses().add(course);
       return repo.save(studentOptional.get());

    }
return null;
}
public void delete(Long id){
    repo.deleteById(id);
}

    public Optional<Student> findById(Long id) {
        if(!repo.findById(id).isPresent())
            throw new StudentNotFoundException("No student could be located for id"+ id);
        return repo.findById(id);
    }

}
