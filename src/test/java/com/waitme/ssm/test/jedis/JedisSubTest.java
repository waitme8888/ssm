package com.waitme.ssm.test.jedis;

import redis.clients.jedis.Jedis;

public class JedisSubTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.subscribe(new JedisPubSubListener(), "pubSubTest");
	}
}
