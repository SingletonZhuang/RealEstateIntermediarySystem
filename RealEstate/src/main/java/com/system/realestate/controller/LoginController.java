package com.system.realestate.controller;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/auth")
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/login")
    public String login(@RequestBody String body){

        String oper = "user login";
        log.info("{}, body: {}",oper,body);

        JSONObject json = JSON.parseObject(body);
        String userName = json.getString("userName");
        String passWord = json.getString("passWord");

        if (StringUtils.isEmpty(userName)){
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(passWord)){
            return "密码不能为空";
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login( new UsernamePasswordToken(userName, passWord) );
           /* //从session取出用户信息
            SysUser user = (SysUser) currentUser.getPrincipal();
            if (user==null) throw new AuthenticationException();
            log.info("user login: {}, sessionId: {}",user.getUserName(),currentUser.getSession().getId());
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return Json.succ(oper)
            		.data("token", UUID.randomUUID().toString())
                    .data("uid",user.getId())
                    .data("nick",user.getUserName())
                    .data("roles",null)
                    .data("perms",null).toString();*/

        } catch ( UnknownAccountException uae ) {
           /* log.warn("用户帐号不正确");
            return Json.fail(oper,"用户帐号或密码不正确");*/

        } catch ( IncorrectCredentialsException ice ) {
           /* log.warn("用户密码不正确");
            return Json.fail(oper,"用户帐号或密码不正确");*/

        } catch ( LockedAccountException lae ) {
           /* log.warn("用户帐号被锁定");
            return Json.fail(oper,"用户帐号被锁定不可用");*/

        } catch ( AuthenticationException ae ) {
          /*  log.warn("登录出错");
            return Json.fail(oper,"登录失败："+ae.getMessage());*/
        }
		return passWord;
    }
}
