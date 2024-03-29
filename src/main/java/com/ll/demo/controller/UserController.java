package com.ll.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.annotation.WebLog;
import com.ll.demo.common.R;
import com.ll.demo.dto.PageDto;
import com.ll.demo.dto.UserDto;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import com.ll.demo.util.PageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "user", description = "Tutorial management APIs")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/user")
    public R<?> user() {
        User user = userService.getUserById(1L);
        return R.success(user);
    }

    @GetMapping("/allUser")
    public R<?> all(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }

    @GetMapping("/allUser22")
    public R<?> allObjetc(PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }

    /**
     * json请求转为对象, 必须加 @RequestBody
     * Content-Type:application/json
     * <p>
     * {
     * "pageNo": "1",
     * "pageSize": 2
     * }
     *
     * @param page
     * @return
     */
    @Operation(summary = "测试接口hello", description = "测试接口description", tags = {"测试接口tags", "测试接口tags2"})
    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = R.class), mediaType = "application/json") })
    })
    @PostMapping("/postUsers") //
    @WebLog
    public R<PageInfo<UserDto>> postUsers(@Valid @RequestBody PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);

        PageInfo<UserDto> replace = PageUtils.replace(pageInfo, UserDto.class);

        return R.success(replace);
    }
}
