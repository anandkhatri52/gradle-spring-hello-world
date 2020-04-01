package com.example.gradlespringhelloworld.controller;

import com.example.gradlespringhelloworld.model.SampleRequest;
import com.example.gradlespringhelloworld.model.SampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
@Slf4j
public class ExampleController {

    @GetMapping
    public String getYourName(){
        return "Anand Khatri";
    }

    @PostMapping(value = "/sample",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleResponse dateSample(@RequestBody SampleRequest sampleRequest){
        log.info("Date Sample endpoint invoke.");
        return SampleResponse.builder()
                .name("Anand")
                .date(sampleRequest.getSampleDate())
                .build();
    }

}
