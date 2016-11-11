package com.waitme.ssm.hibernate.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.waitme.core.hibernate.page.Page;
import com.waitme.ssm.hibernate.model.User;
import com.waitme.ssm.hibernate.service.UserService;

@RequestMapping("/user2")
@Controller("UserController2")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	public static final String PAGE_USER_LIST = "user/userList";
	public static final String PAGE_USER_INFO = "user/userInfo";
	
	@Resource(name="user2Service")
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNo", defaultValue="1") int pageNo,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize, 
			HttpServletRequest request, Model model) {
		
		String searchName = request.getParameter("searchName");
		
		DetachedCriteria criteria  = DetachedCriteria.forClass(User.class);
		if (searchName!=null && !"".equals(searchName)) {
			criteria.add(Restrictions.ilike("name", searchName));
			model.addAttribute("searchName", searchName);
		}
		Page<User> page = userService.findByCriteria(criteria, pageNo, pageSize);
		
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("page", page);
		log.info("");
		return PAGE_USER_LIST;
	}

}
