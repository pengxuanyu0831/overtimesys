package com.xuanyu.shiro;

import com.xuanyu.model.User;
import com.xuanyu.model.UserActive;
import com.xuanyu.service.imple.UserServiceImple;
import netscape.security.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImple userServiceImple;

    protected AuthorizationInfo  doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        // 从token中获取用户名
        String userName = (String) token.getPrincipal();
        // 从token获取密码
        String password = new String((char[])token.getCredentials());


        // 去校验是不是有这个用户
        User user = userServiceImple.validatorUserExits(userName);

        if(user == null){
            return null;
        }

        // 获取验证信息的实体
        UserActive userActive = new UserActive();
        userActive.setEmail(user.getEmail());
        userActive.setPassword(user.getPassword());
        userActive.setId(user.getId());
        userActive.setPassword(password);

        // SimpleAuthenticationInfo这个类可以解salt获取真实密码
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userActive,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName()
        );
        return simpleAuthenticationInfo;





    }
    public void clearCache() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }


}
