package com.scurtis.istudy.converter;

import com.scurtis.istudy.dto.StudyCategoryDto;
import com.scurtis.istudy.entity.StudyCategory;
import org.springframework.stereotype.Component;

@Component
public class StudyCategoryConverter {

    public StudyCategoryDto toDto(StudyCategory entity) {
        return new StudyCategoryDto(entity.getId(), entity.getName());
    }

}
