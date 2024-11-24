package com.scurtis.istudy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private String testament;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate createdDate;

}
