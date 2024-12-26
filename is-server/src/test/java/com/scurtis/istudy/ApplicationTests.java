package com.scurtis.istudy;

import com.scurtis.istudy.service.StudyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles(value = "test")
class ApplicationTests {

    @Autowired
    private StudyService studyService;

    @Test
    void contextLoads() {
        assertNotNull(studyService);
    }

}
