package com.scurtis.istudy.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "istudy", name = "study_note")
public class StudyNote implements Persistable<Long> {

    @Id
    @Column(value = "note_id")
    private Long id;
    @Column(value = "study_id")
    private Long studyId;
    private String verse;
    private String note;
    @ReadOnlyProperty
    private LocalDate createdDate;

    /**
     * This method is called by the R2DBC persistence framework to determine
     * if it's a new or existing record.  If new then an insert
     * is done otherwise an update statement is executed.  This is the only
     * way the framework can know which statement to use and is hence required.
     *
     * @return true if this is a new record otherwise false
     */
    @Override
    @Transient
    public boolean isNew() {
        return id == null || id == 0;
    }

}
