package com.system.realestate.shiro;



import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;




import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 这个类是参照JDBCRealm写的，主要是自定义了如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger log =LoggerFactory.getLogger(UserRealm.class);

/*    @Autowired
    private UserService userService;*/


    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashMatcher.setStoredCredentialsHexEncoded(false);
        hashMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(hashMatcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        principals.getPrimaryPrincipal();
       /* SysUser user = (SysUser) getAvailablePrincipal(principals);*/
		/*
		 * Set<AuthVo> roles = user.getRoles(); Set<AuthVo> perms = user.getPerms();
		 * log.info("获取角色权限信息: roles: {}, perms: {}",roles,perms);
		 * 
		 * 
		 * info.setRoles(roles.stream().map(AuthVo::getVal).collect(Collectors.toSet()))
		 * ; info.setStringPermissions(perms.stream().map(AuthVo::getVal).collect(
		 * Collectors.toSet()));
		 */
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       
		/*
		 * Set<String> roles = new HashSet<>(); roles.add("root"); Set<String> perms =
		 * new HashSet<>(); perms.add("*"); info.setRoles(roles);
		 * info.setStringPermissions(perms);
		 */
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        if (username == null) {
            throw new AccountException("用户名不能为空");
        }

       /* SysUser userDB = userService.selectOne(username);
        if (userDB == null) {
            throw new UnknownAccountException("找不到用户（"+username+"）的帐号信息");
        }

        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
		
		 * Set<AuthVo> roles = roleService.getRolesByUserId(userDB.getUid());
		 * Set<AuthVo> perms = permService.getPermsByUserId(userDB.getUid());
		 * userDB.getRoles().addAll(roles); userDB.getPerms().addAll(perms);
		 

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPassWord(), getName());
		
		
		if (userDB.getSalt() != null) {
			info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt())); 
		}*/
		 
		 

       /* return info;*/
        return null;

    }





}
