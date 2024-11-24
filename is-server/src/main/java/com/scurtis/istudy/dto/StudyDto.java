package com.scurtis.istudy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyDto {

    private Long id;
    private String method;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate createdDate;

}
