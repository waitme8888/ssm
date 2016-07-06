package com.waitme.core.hibernate.Intercptor;

import org.hibernate.EmptyInterceptor;

public class ExecuteSqlInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 555683643335717928L;
	
	public String onPrepareStatement(String sql) {
		System.out.println("=============================");
		System.out.println(sql);
		System.out.println("=============================");
		return sql;
	}

}
