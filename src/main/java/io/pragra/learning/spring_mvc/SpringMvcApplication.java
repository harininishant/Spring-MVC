package io.pragra.learning.spring_mvc;

import io.pragra.learning.spring_mvc.entity.Student;
import io.pragra.learning.spring_mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc
public class SpringMvcApplication {
    private  final StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(){
        return args -> {
            service.createStudent(Student.builder().FirstName("Sam").LastName("Hughes").build());
            service.createStudent(Student.builder().FirstName("Peter").LastName("Patrick").build());
            service.createStudent(Student.builder().FirstName("Tom").LastName("Cruise").build());
        };
    }

}
