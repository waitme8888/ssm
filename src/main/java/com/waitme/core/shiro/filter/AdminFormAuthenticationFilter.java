package com.waitme.core.shiro.filter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AdminFormAuthenticationFilter extends FormAuthenticationFilter {
	
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
    	
		Session session = subject.getSession();
		Set<String> permissionsSet = new HashSet<String>();
		permissionsSet.add("/user/list");
		session.setAttribute("perms", permissionsSet);
		issueSuccessRedirect(request, response);
		return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        return super.isAccessAllowed(request, response, mappedValue) ||
//                (!isLoginRequest(request, response) && isPermissive(mappedValue));
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
    	Set<String> permissions = (Set<String>)session.getAttribute("perms");
		String requestURI = getPathWithinApplication(request);
		return (permissions != null && permissions.contains(requestURI));
    }
    
    
}
