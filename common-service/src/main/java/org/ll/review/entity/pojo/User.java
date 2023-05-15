package org.ll.review.entity.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //    @TableId
    @NonNull
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
