package com.waitme.ssm.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyTest {

	public static void main(String[] args) {
		final ProxyObject o = (ProxyObject)Proxy.newProxyInstance(ProxyObject.class.getClassLoader(), new Class[]{ProxyObject.class}, 
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName());
						method.invoke(new ProxyObject() {

							@Override
							public void Method1() {
								System.out.println("Method1....");
							}

							@Override
							public void Method2() {
								System.out.println("Method2....");
								
							}
							
						}, args);
						return null;
					}
			
		});
		ProxyObject o1 = (ProxyObject)Proxy.newProxyInstance(ProxyObject.class.getClassLoader(), new Class[]{ProxyObject.class}, 
				new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName());
				method.invoke(o, args);
				return null;
			}
			
		});
		
		o1.Method1();
		o1.Method2();
	}
}
