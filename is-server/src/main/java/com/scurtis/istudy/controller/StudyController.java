package com.scurtis.istudy.controller;

import com.scurtis.istudy.dto.BookDto;
import com.scurtis.istudy.dto.StudyDto;
import com.scurtis.istudy.dto.StudyMethodDto;
import com.scurtis.istudy.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping(value = "methods")
    public Flux<StudyMethodDto> getAllStudyMethods() {
        log.debug("StudyController -> getAllStudyMethods");
        return studyService.getAllStudyMethods();
    }

    @GetMapping(value = "study")
    public Flux<StudyDto> getAllStudies() {
        log.debug("StudyController -> getAllStudies");
        return studyService.getAllStudies();
    }

    @GetMapping(value = "study/{id}")
    public Mono<StudyDto> getStudyById(@PathVariable Long id) {
        log.debug("StudyController -> getStudyById");
        return studyService.getStudyById(id);
    }

    @PostMapping(value = "study")
    public Mono<StudyDto> saveStudy(@RequestBody StudyDto studyDto) {
        log.debug("StudyController -> saveStudy");
        return studyService.saveStudy(studyDto);
    }

    @DeleteMapping(value = "study/{id}")
    public Mono<Void> deleteStudy(@PathVariable Long id) {
        log.debug("StudyController -> deleteStudy: {}", id);
        return studyService.deleteStudy(id);
    }

    @GetMapping(value = "book")
    public Flux<BookDto> getAllBooks() {
        log.debug("StudyController -> getAllBooks");
        return studyService.getAllBooks();
    }

}
