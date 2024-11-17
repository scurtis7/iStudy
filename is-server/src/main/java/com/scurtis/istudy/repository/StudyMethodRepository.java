package com.scurtis.istudy.repository;

import com.scurtis.istudy.entity.StudyMethod;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMethodRepository extends ReactiveCrudRepository<StudyMethod, Long> {
}
