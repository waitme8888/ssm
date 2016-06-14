package com.waitme.ssm.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		map.put("name", "哈哈");
		return "/index";
	}


	@RequestMapping("/json")
	@ResponseBody
	public Object getJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fd", "哈哈");
		return map;
	}
	
	@RequestMapping("/str")
	@ResponseBody
	public Object getString() {
		return "哈哈";
	}
	
	@RequestMapping("/ex")
	public void throwException() {
		throw new RuntimeException();
	}
	
	@RequestMapping("/nopage")
	public String pageNoFund() {
		return "null";
	}
}
