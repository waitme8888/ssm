package com.waitme.ssm.test.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		String key = "mykey";
		long s = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			jedis.set(key, "123456");
//			System.out.println(jedis.get(key));
			jedis.get(key);
			jedis.del(key);
		}
		System.out.println("耗时：" + (System.currentTimeMillis()-s));
	}
	
	@Test
	public void pubTest() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		for (int i = 0; i < 100; i++) {
			jedis.publish("pubSubTest", "message"+i);
		}
	}

}
