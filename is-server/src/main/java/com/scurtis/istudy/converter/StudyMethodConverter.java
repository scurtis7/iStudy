package com.scurtis.istudy.converter;

import com.scurtis.istudy.dto.StudyMethodDto;
import com.scurtis.istudy.entity.StudyMethod;
import org.springframework.stereotype.Component;

@Component
public class StudyMethodConverter {

    public StudyMethodDto toDto(StudyMethod entity) {
        return new StudyMethodDto(entity.getId(), entity.getName());
    }

}
