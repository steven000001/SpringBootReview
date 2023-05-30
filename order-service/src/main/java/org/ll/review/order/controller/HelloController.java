package org.ll.review.order.controller;


import org.ll.review.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
    Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    R<?> hello() {
        log.info("hello {}", "HelloController");
        return R.success("hello");
    }
}
