package com.scurtis.istudy.repository;

import com.scurtis.istudy.entity.Study;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends ReactiveCrudRepository<Study, Long> {
}
