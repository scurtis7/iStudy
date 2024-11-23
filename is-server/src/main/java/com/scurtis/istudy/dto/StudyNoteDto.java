package com.scurtis.istudy.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyNoteDto {

    private Long id;
    private Long studyId;
    private String verse;
    private String note;
    private LocalDate createdDate;

}
