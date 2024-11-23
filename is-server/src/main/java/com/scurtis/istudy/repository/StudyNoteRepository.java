package com.scurtis.istudy.repository;

import com.scurtis.istudy.entity.StudyNote;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyNoteRepository extends ReactiveCrudRepository<StudyNote, Long> {
}
