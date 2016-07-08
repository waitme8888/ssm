package com.waitme.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm {
	
	private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		log.info("用户登录开始...");
        String username = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if (!"admin".equals(username) || !"admin".equals(password)) {
        	throw new AuthenticationException();
        }
        ByteSource salt = ByteSource.Util.bytes(username.getBytes());
        SimpleAuthenticationInfo authenticationInfo 
        	= new SimpleAuthenticationInfo(username, "3ef7164d1f6167cb9f2658c07d3c2f0a", salt, getName());
        return authenticationInfo;
	}

}
