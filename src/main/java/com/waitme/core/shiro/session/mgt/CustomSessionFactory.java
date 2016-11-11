package com.waitme.core.shiro.session.mgt;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

public class CustomSessionFactory implements SessionFactory {

	@Override
	public Session createSession(SessionContext initData) {
        if (initData != null) {
            String host = initData.getHost();
            if (host != null) {
                return new CustomSession(host);
            }
        }
		return new CustomSession();
	}

}
