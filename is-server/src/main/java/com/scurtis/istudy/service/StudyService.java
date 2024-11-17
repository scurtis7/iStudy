package com.scurtis.istudy.service;

import com.scurtis.istudy.converter.StudyMethodConverter;
import com.scurtis.istudy.dto.StudyMethodDto;
import com.scurtis.istudy.repository.StudyMethodRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@AllArgsConstructor
public class StudyService {

    private final StudyMethodRepository studyMethodRepository;
    private final StudyMethodConverter studyMethodConverter;

    public Flux<StudyMethodDto> getAllStudyMethods() {
        log.debug("StudyService -> getAllStudyMethods");
        return studyMethodRepository.findAll()
            .map(studyMethodConverter::toDto);
    }

}
