package com.yiben_video.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiben_video.common.Result;
import com.yiben_video.common.ResultEnum;
import com.yiben_video.pojo.UserEntity;
import com.yiben_video.service.LoginService;
import com.yiben_video.utils.JwtUtil;
import org.springframework.stereotype.Service;


/**
 * @author 王飞
 * @create 2021/5/31 10:27
 * @emai 936886169@qq.com
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {
    Result result = new Result();
    @Override
    public Result login(UserEntity userEntity) {
        JSONObject json = new JSONObject();
        UserEntity mysqlUser = userDao.findByUsername(userEntity.getUsername());
        if (mysqlUser == null){
            return result.error(ResultEnum.USER_NOT_EXIST);
        } else if (!mysqlUser.getPassword().equals(userEntity.getPassword())) {
            return result.error(ResultEnum.USER_PASSWORD_ERROR);
        } else {
            String token = JwtUtil.sign(userEntity.getUsername(),userEntity.getPassword());
            json.put("token",token);
            return result.success(ResultEnum.SUCCESS_USER_LOGIN,json);
        }
    }

    @Override
    public UserEntity findByUserName(String userName) {
        UserEntity user = userDao.findByUsername(userName);
        return user;
    }
}
