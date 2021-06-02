package com.yiben_video.service.impl;

import com.yiben_video.pojo.UserEntity;
import com.yiben_video.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王飞
 * @create 27/5/2021 下午3:06
 * @emai 936886169@qq.com
 * 用户管理
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public List<UserEntity> listUser() {
        return userDao.findAll();
    }
}
