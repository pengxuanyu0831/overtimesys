package com.xuanyu.shiro;

import com.xuanyu.service.imple.UserServiceImple;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImple userServiceImple;

    protected AuthorizationInfo  doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        // 从token中获取用户名
        String userCode = (String) token.getPrincipal();
        // 从token获取密码
        String password = new String((char[])token.getCredentials());


    }


}
