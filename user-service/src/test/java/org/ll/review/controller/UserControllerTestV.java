package org.ll.review.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ll.review.common.R;
import org.ll.review.config.TestConfig;
import org.ll.review.entity.pojo.User;
import org.ll.review.mapper.UserMapper;
import org.ll.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Slf4j
@SpringBootTest
@Import(TestConfig.class)
@AutoConfigureMockMvc // need this in Spring Boot test
@AutoConfigureMybatisPlus
class UserControllerTestV {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService mockUserService;

    @Test
    void testGetUserById() throws Exception {
        // Setup
        User build = userMapper.selectById(3L);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/getUserById")
                        .param("id", "3")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        log.info("response.getContentAsString() = {}", response.getContentAsString());
        String expected = JSONUtil.toJsonStr(JSONUtil.parseObj(R.success(build), false));
        assertThat(response.getContentAsString()).isEqualTo(expected);

        R<User> userR = JSONUtil.toBean(response.getContentAsString(), new TypeReference<R<User>>() {}, false);
        User user = userR.getData();
        log.info("user = {}", user);
        assertThat(user).isEqualTo(build);
    }
}
