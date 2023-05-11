package org.ll.review.entity.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@TableName("user")
public class User {

    //    @TableId
    @NonNull
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
