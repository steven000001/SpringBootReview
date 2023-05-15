package org.ll.review.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ll.review.common.R;
import org.ll.review.entity.pojo.User;
import org.ll.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMybatisPlus
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService mockUserService;

    @Test
    void testGetUserById() throws Exception {
        // Setup
        User build = User.builder()
                .id(3L)
                .age(17)
                .name("alice")
                .email("110@mail.com")
                .build();
        when(mockUserService.getUserById(3L)).thenReturn(build);

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

        R r = JSONUtil.toBean(response.getContentAsString(), R.class);
        log.info("result {}", R.success(build));
        log.info("r = {}", r);

        log.info("r.data= {}", r.getData());

        ObjectMapper objectMapper = new ObjectMapper();
        String string = response.getContentAsString().toString();
        R<User> rs = objectMapper.readValue(string, new TypeReference<R<User>>() {});
        User user = rs.getData();
        log.info("user = {}", user);
    }
}
