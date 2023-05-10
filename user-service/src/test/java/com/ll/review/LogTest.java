package com.ll.review;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = LogTest.class)
public class LogTest {


    Logger log = LoggerFactory.getLogger(LogTest.class);


    @Test
    void testLog(){
        log.info("hello {}", "worldwww");
    }
}
