package com.Jobportal.demo.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String status;
    private String error;

}
