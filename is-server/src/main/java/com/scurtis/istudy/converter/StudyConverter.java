package com.scurtis.istudy.converter;

import com.scurtis.istudy.dto.StudyDto;
import com.scurtis.istudy.entity.Study;
import org.springframework.stereotype.Component;

@Component
public class StudyConverter {

    public StudyDto toDto(Study entity) {
        return new StudyDto(entity.getId(), entity.getMethod(), entity.getName(),
            entity.getDescription(), entity.getCreatedDate());
    }

    public Study toEntity(StudyDto dto) {
        Study entity = new Study();
        entity.setId(dto.getId());
        entity.setMethod(dto.getMethod());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
