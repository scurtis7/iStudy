package com.scurtis.istudy.repository;

import com.scurtis.istudy.entity.StudyCategory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyCategoryRepository extends ReactiveCrudRepository<StudyCategory, Long> {
}
