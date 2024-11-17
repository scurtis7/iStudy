package com.scurtis.istudy.controller;

import com.scurtis.istudy.dto.StudyMethodDto;
import com.scurtis.istudy.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping(value = "methods")
    public Flux<StudyMethodDto> getAllStudyMethods() {
        return studyService.getAllStudyMethods();
    }

}
