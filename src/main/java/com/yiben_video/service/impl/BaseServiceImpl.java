package com.yiben_video.service.impl;

import com.yiben_video.dao.UserDao;
import com.yiben_video.dao.VideoDao;

import javax.annotation.Resource;

/**
 * @author ηι£
 * @create 27/5/2021 δΈε3:23
 * @emai 936886169@qq.com
 */
public class BaseServiceImpl {
    @Resource
    UserDao userDao;
    @Resource
    VideoDao videoDao;

}
