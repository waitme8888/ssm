package com.waitme.core.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionListener implements SessionListener {
	
	private static final Logger log = LoggerFactory.getLogger(ShiroSessionListener.class);
	
	@Override
	public void onStart(Session session) {
		log.info("the session that has started.");
		
	}

	@Override
	public void onStop(Session session) {
		log.info("the session that has stopped.");
		
	}

	@Override
	public void onExpiration(Session session) {
		log.info("the Session has expired. ");
		
	}

}
