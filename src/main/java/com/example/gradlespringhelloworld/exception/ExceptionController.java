package com.example.gradlespringhelloworld.exception;

import com.example.gradlespringhelloworld.model.SampleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<SampleResponse> handleDateTimeParseException(Exception ex) {
        System.out.println("In Exception handling");
        if (ex.getCause().getCause() instanceof DateTimeParseException) {
            SampleResponse errorResponse = SampleResponse.builder()
                    .name("WRONG DATE")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        SampleResponse errorResponse = SampleResponse.builder()
                .name("Something went wrong")
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
