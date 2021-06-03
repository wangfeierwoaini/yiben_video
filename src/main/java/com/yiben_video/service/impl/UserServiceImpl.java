package com.yiben_video.service.impl;

import com.yiben_video.common.Result;
import com.yiben_video.common.ResultEnum;
import com.yiben_video.pojo.UserEntity;
import com.yiben_video.pojo.VideoEntity;
import com.yiben_video.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 王飞
 * @create 27/5/2021 下午3:06
 * @emai 936886169@qq.com
 * 用户管理
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public List<UserEntity> listUser() {
        return userDao.findAll();
    }

}
