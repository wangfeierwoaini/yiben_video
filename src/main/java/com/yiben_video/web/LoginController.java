package com.yiben_video.web;

import com.alibaba.fastjson.JSONObject;
import com.yiben_video.common.Result;
import com.yiben_video.common.ResultEnum;
import com.yiben_video.pojo.UserEntity;
import com.yiben_video.utils.JwtUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 王飞
 * @create 27/5/2021 下午4:06
 * @emai 936886169@qq.com
 */
@Slf4j
@RestController
@Api(tags = "用户登录")
@CrossOrigin
@RequestMapping("/user")
public class LoginController extends BaseController{
    Result result =new Result();
    /*@PostMapping("/login")
    public Result login(@RequestBody UserEntity userEntity) {
        log.warn("执行登录操作!:" +userEntity.getUsername()+"   "+userEntity.getPassword());
        Result user1 =loginService.login(userEntity);
        System.out.println(user1);
        return user1;
    }*/
    @PostMapping("/login")
    public Result login(@RequestBody UserEntity userEntity){
        log.warn(userEntity.toString());
        UserEntity userEntity1 = loginService.findByUserName(userEntity.getUsername());
        JSONObject jsonObject = new JSONObject();
        if (!userEntity.getPassword().equals(userEntity1.getPassword())) {
            return result.error(ResultEnum.USER_PASSWORD_ERROR);
        } else {
            String token = JwtUtil.sign(userEntity.getUsername(),userEntity.getPassword());
            jsonObject.put("token", token);
            return result.success(ResultEnum.SUCCESS_USER_LOGIN,jsonObject);
        }
    }
    @GetMapping("/info")
    public Result info(){
        System.out.println("wopaole");
        List<UserEntity> list = userService.listUser();
        return result.success(2000,list,"用户列表");
    }

    @PostMapping("/logout")
    public Result logout(HttpSession session) throws Exception{
        session.invalidate();
        return result.success(2000,null,"成功");
    }
    /*@PostMapping("/login")
    public Result login(@PathVariable("username") String username,
                        @PathVariable("password") String password) {
        System.out.println(username);
        System.out.println(password);
        //log.warn("执行登录操作!:" +userEntity.getUsername()+"   "+userEntity.getPassword());
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        Result user1 =loginService.login(userEntity);
        System.out.println(user1);
        return user1;
    }*/


}
