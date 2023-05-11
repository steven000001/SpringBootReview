package org.ll.review.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ll.review.entity.pojo.User;
import org.springframework.stereotype.Repository;


//@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}