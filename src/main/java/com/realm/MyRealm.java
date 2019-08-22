package com.realm;

import com.alibaba.druid.util.StringUtils;
import com.entity.User;
import com.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm{
    @Resource
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("product:update");
//        info.addRole("admin");
        Subject subject = SecurityUtils.getSubject();
        User dbUser = (User) subject.getPrincipal();
        List<String> perms = userService.queryPermissionById(dbUser.getId());
        if(perms!=null){
            for (String perm:perms) {
                if(!StringUtils.isEmpty(perm)){
                    info.addStringPermission(perm);
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入认证方法");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        String name="zhangsan";
//        String password="123";
//        if(!username.equals(name)){
//            return  null;
//        }
//        实现动态认证
        User dbUser = userService.findName(token.getUsername());

        if(dbUser==null){
            return  null;
        }

        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),"");
    }
}
