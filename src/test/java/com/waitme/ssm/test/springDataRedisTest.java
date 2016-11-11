package com.waitme.ssm.test;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waitme.ssm.mybatis.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class springDataRedisTest {
	
	private static final Logger log = LoggerFactory.getLogger(springDataRedisTest.class);
	
	@Resource
	RedisTemplate<Serializable, Serializable> redisTemplate;
	
	@Test
	public void test() {
		
		User user= null;
		for (int i = 0; i < 10; i++) {
			user= new User();
			user.setName(""+i);
			redisTemplate.opsForHash().put("user", ""+i, user);
		}
		Map<Object, Object> hh = redisTemplate.opsForHash().entries("user");
		Iterator<Entry<Object, Object>> it = hh.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Object, Object> entry =it.next();
			log.info("key:"+entry.getKey()+",value:"+((User)entry.getValue()).getName());
		}
		log.info("map->hh->key->3:"+redisTemplate.opsForHash().get("hh", "3"));
//		redisTemplate.delete("user");
	}
}
