package org.ll.review.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ll.review.entity.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes = UserMapperTest.class)
@AutoConfigureMybatisPlus
@MapperScan("org.ll.review.mapper")
public class UserMapperTest {


    @Resource
    private UserMapper userMapper;


    @Test
    void testFindUserById() {
        User user = userMapper.selectById(1L);
        log.info("user = {}", user);
    }


}
