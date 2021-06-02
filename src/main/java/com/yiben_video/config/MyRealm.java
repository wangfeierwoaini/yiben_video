package com.yiben_video.config;
import com.yiben_video.pojo.UserEntity;
import com.yiben_video.service.LoginService;
import com.yiben_video.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MyRealm:自定义一个授权
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */

@Component
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Resource
    private LoginService userService;

    /**
     * 必须重写此方法，不然Shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //取得用户名
        String token = (String) authenticationToken.getPrincipal();
        log.warn("输入的账号是："+token);
        String userName = null;
        try {
            //这里工具类没有处理空指针等异常这里处理一下(这里处理科学一些)
            userName = JwtUtil.getUsername(token);
        } catch (Exception e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (userName == null) {
            log.warn("token无效(空''或者null都不行!)");
            throw new AuthenticationException("token无效");
        }
        UserEntity user = userService.findByUserName(userName);
        if (user == null) {
            log.error("用户不存在");
            throw new AuthenticationException("用户不存在");
        }
        if (!JwtUtil.verify(token,userName,user.getPassword())) {
            log.error("用户名或密码错误(token无效或者与登录者不匹配)!)");
            throw new AuthenticationException("用户名或密码错误(token无效或者与登录者不匹配)!");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JwtUtil.getUsername(principalCollection.toString());
        UserEntity user = userService.findByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }
}
