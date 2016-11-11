package com.waitme.core.shiro.session.mgt;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSessionDao extends AbstractSessionDAO {
	
	@Resource
	RedisTemplate<Serializable, Session> redisTemplate;

	@Override
	public void update(Session session) throws UnknownSessionException {
		if (session == null) {
			throw new NullPointerException("session argument cannot be null.");
		}
		Serializable sessionId = session.getId();
		if (sessionId == null) {
			throw new NullPointerException("id argument cannot be null.");
		}
		redisTemplate.opsForValue().set(sessionId, session, session.getTimeout(), TimeUnit.MILLISECONDS);
	}

	@Override
	public void delete(Session session) {
		if (session == null) {
			throw new NullPointerException("session argument cannot be null.");
		}
		Serializable sessionId = session.getId();
		if (sessionId == null) {
			throw new NullPointerException("id argument cannot be null.");
		}
		redisTemplate.delete(sessionId);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		if (sessionId == null) {
			throw new NullPointerException("id argument cannot be null.");
		}
		redisTemplate.opsForValue().set(sessionId, session, session.getTimeout(), TimeUnit.MILLISECONDS);
		return sessionId;
	}
	
	@Override
    protected void assignSessionId(Session session, Serializable sessionId) {
        ((CustomSession) session).setId(sessionId);
    }

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if (sessionId == null) {
			throw new NullPointerException("id argument cannot be null.");
		}
		Session session = redisTemplate.opsForValue().get(sessionId);
		return session;	
	}

}
