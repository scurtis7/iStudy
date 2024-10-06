package com.scurtis.istudy.service;

import com.scurtis.istudy.converter.StudyCategoryConverter;
import com.scurtis.istudy.dto.StudyCategoryDto;
import com.scurtis.istudy.entity.StudyCategory;
import com.scurtis.istudy.repository.StudyCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@AllArgsConstructor
public class StudyService {

    private final StudyCategoryRepository studyCategoryRepository;
    private final StudyCategoryConverter studyCategoryConverter;

    public Flux<StudyCategoryDto> getAllCategories() {
        return studyCategoryRepository.findAll()
            .map(studyCategoryConverter::toDto);
    }

}
