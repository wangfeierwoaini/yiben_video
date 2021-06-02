package com.yiben_video.web;

import com.yiben_video.service.LoginService;
import com.yiben_video.service.UserService;
import com.yiben_video.service.VideoService;

import javax.annotation.Resource;

/**
 * @author 王飞
 * @create 27/5/2021 下午4:04
 * @emai 936886169@qq.com
 */
public class BaseController {
    @Resource
    UserService userService;
    @Resource
    VideoService videoService;
    @Resource
    LoginService loginService;
}
