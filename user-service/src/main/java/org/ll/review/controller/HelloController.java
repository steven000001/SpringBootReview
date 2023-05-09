package org.ll.review.controller;


import org.ll.review.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {


    @GetMapping("/hello")
    R<?> hello() {
        return R.success("hello");
    }
}
