package io.pragra.learning.spring_mvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Builder
public class ErrorMessage {
    private String errCode;
    private String desc;
    @JsonFormat(pattern = "yyyy-DD-mm HH:mm:ss.SSS")
    private Date timeOfError;
}
