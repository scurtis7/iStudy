package com.scurtis.istudy.converter;

import com.scurtis.istudy.dto.StudyNoteDto;
import com.scurtis.istudy.entity.StudyNote;
import org.springframework.stereotype.Component;

@Component
public class StudyNoteConverter {

    public StudyNoteDto toDto(StudyNote entity) {
        return new StudyNoteDto(entity.getId(), entity.getStudyId(),
            entity.getVerse(), entity.getNote(), entity.getCreatedDate());
    }

    public StudyNote toEntity(StudyNoteDto dto) {
        StudyNote entity = new StudyNote();
        entity.setId(dto.getId());
        entity.setStudyId(dto.getStudyId());
        entity.setVerse(dto.getVerse());
        entity.setNote(dto.getNote());
        return entity;
    }

}
