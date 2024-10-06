package com.scurtis.istudy.controller;

import com.scurtis.istudy.dto.StudyCategoryDto;
import com.scurtis.istudy.entity.StudyCategory;
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

    @GetMapping(value = "categories")
    public Flux<StudyCategoryDto> getAllCategories() {
        return studyService.getAllCategories();
    }

}
