package com.waitme.zk;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ZkTest {
	
	@Test
	public void curator() {
		String path = "/test";
		CuratorFramework client = CuratorFrameworkFactory
				.builder()
				.connectString("127.0.0.1:2181")
				.namespace("test")
				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
				.connectionTimeoutMs(5000)
				.build();
		
		client.start();
		
		// create a node
		try {
			Object o = client.create().forPath("/head", new byte[0]);
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// delete a node in background
		try {
			Object o = client.delete().inBackground().forPath("/head");
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create a EPHEMERAL_SEQUENTIAL
		try {
			Object o = client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
					.forPath("/head/child", new byte[0]);
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get the data
		try {
			Object o = client.getData().watched().inBackground().forPath("/test");
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// check the path exits
		try {
			Object o = client.checkExists().forPath(path);
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.close(); 
	}

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList();
	}

}
