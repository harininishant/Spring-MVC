package io.pragra.learning.spring_mvc.controller.rest;


import io.pragra.learning.spring_mvc.entity.ErrorMessage;
import io.pragra.learning.spring_mvc.entity.Student;
import io.pragra.learning.spring_mvc.service.StudentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController // return Api body
//@Controller
//@ResponseBody // both these anotations together is part of RestController anotation
/*
@ResponseBody annotation indicates that the return value of the method will be the body of web response.
The @ResponseBody annotation is used at method level or method return type level.
 */
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentRestController {
    private final StudentService service;

    @GetMapping("/student")
    public List<Student> getAllstudent(){
        return service.getAll();
    }
/*
content should return schema. / content is default.
 */
    @ApiResponses({
            @ApiResponse(
                    responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorMessage.class)),
                    description = "Student not found for the record"
            ),
            @ApiResponse(
                    responseCode = "200",content = @Content(schema = @Schema(implementation = Student.class))
            ),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    }
    )
    @GetMapping("/student/{studentId}") //produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentbyId(@PathVariable("studentId") Long id ){
        Optional<Student> serviceById = service.findById(id);
        if(serviceById.isPresent()){
            return ResponseEntity.ok(serviceById);
        }
        return ResponseEntity.status(404).body(ErrorMessage.builder()
                .errCode("APP404").desc("No Record Found for the id").timeOfError(new Date()));
    }
//     @GetMapping("/student/{studentId}")// this is for a single swagger page
//     public Student getStudentbyId(@PathVariable ("studentId") Long id){
//         Optional<Student> serviceById = service.findById(id);
//         return serviceById.get();
//
//     }
}
