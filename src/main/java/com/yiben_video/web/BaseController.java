package com.yiben_video.web;

import com.yiben_video.service.LoginService;
import com.yiben_video.service.UserService;
import com.yiben_video.service.VideoService;

import javax.annotation.Resource;

/**
 * @author ηι£
 * @create 27/5/2021 δΈε4:04
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
