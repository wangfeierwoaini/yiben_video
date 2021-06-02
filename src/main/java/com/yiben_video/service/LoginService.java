package com.yiben_video.service;

import com.yiben_video.common.Result;
import com.yiben_video.pojo.UserEntity;

/**
 * @author 王飞
 * @create 2021/5/31 10:26
 * @emai 936886169@qq.com
 */
public interface LoginService {
    Result login(UserEntity userEntity);
    UserEntity findByUserName(String userName);
}
