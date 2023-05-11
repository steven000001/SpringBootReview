package org.ll.review.controller;


import lombok.extern.slf4j.Slf4j;
import org.ll.review.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @RequestMapping("/getUserById")
    public Object getUserById(Long id){

        log.info("id = {}", id);

        return userService.getUserById(id);
    }

}
