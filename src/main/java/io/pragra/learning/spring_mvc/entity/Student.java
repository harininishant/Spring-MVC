package io.pragra.learning.spring_mvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String FirstName;
    private String LastName;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyDDmmHHmmSS")
    private Instant createTime;

    @JsonIgnore
    private Instant updateTime;

    @OneToMany
   private List<Course> entolledCourses;
}
