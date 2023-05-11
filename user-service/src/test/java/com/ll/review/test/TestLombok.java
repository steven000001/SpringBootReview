package com.ll.review.test;

import lombok.extern.slf4j.Slf4j;
import org.ll.review.entity.pojo.User;

@Slf4j
public class TestLombok {





    public static void main(String[] args) {
        User build = User.builder().id(null).build();
        log.info("build = {}", build);
    }
}
