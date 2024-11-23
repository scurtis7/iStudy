package com.scurtis.istudy.service;

import com.scurtis.istudy.converter.BookConverter;
import com.scurtis.istudy.converter.StudyConverter;
import com.scurtis.istudy.converter.StudyMethodConverter;
import com.scurtis.istudy.dto.BookDto;
import com.scurtis.istudy.dto.StudyDto;
import com.scurtis.istudy.dto.StudyMethodDto;
import com.scurtis.istudy.entity.Study;
import com.scurtis.istudy.repository.BookRepository;
import com.scurtis.istudy.repository.StudyMethodRepository;
import com.scurtis.istudy.repository.StudyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class StudyService {

    private final StudyMethodRepository studyMethodRepository;
    private final StudyMethodConverter studyMethodConverter;
    private final StudyRepository studyRepository;
    private final StudyConverter studyConverter;
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public Flux<StudyMethodDto> getAllStudyMethods() {
        log.debug("StudyService -> getAllStudyMethods");
        return studyMethodRepository.findAll()
            .map(studyMethodConverter::toDto);
    }

    public Flux<StudyDto> getAllStudies() {
        log.debug("StudyService -> getAllStudies");
        return studyRepository.findAll()
            .map(studyConverter::toDto);
    }

    public Mono<StudyDto> saveStudy(StudyDto studyDto) {
        log.debug("StudyService - saveStudy");
        return studyRepository.save(studyConverter.toEntity(studyDto))
            .map(studyConverter::toDto);
    }

    public Flux<BookDto> getAllBooks() {
        log.debug("StudyService -> getAllBooks");
        return bookRepository.findAll()
            .map(bookConverter::toDto);
    }

}
