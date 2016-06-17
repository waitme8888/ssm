package com.waitme.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waitme.ssm.model.User;
import com.waitme.ssm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	public static final String PAGE_USER_LIST = "user/userList";
	public static final String PAGE_USER_INFO = "user/userInfo";
	

	@Resource
	private UserService userService;
	
	/**
	 * 查询列表
	 * @param pageNo    当前页码，默认第一页
	 * @param pageSize  每页显示记录数，默认10条
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNo", defaultValue="1") int pageNo,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize, 
			HttpServletRequest request, Model model) {
		
		// 查询条件，也可以放在参数中 @RequestParam(value="searchName", required=false) String searchName
		// 其中 required=false设置当不传searchName参数时，不会保错，默认：true
		String searchName = request.getParameter("searchName");
		
		// 增加查询条件
		Condition condition = new Condition(User.class);
		Criteria criteria = condition.createCriteria();
		if (searchName!=null && !"".equals(searchName)) {
			criteria.andLike("name", "%" + searchName + "%");
			model.addAttribute("searchName", searchName);
		}
		
		// 添加分页查询条件
		PageHelper.startPage(pageNo, pageSize);
		// 排序
		PageHelper.orderBy("id");
		List<User> users = userService.selectByCondition(condition);
		// 将记录封装到分页对象中，jsp页面使用
		PageInfo<User> page = new PageInfo<User>(users);
		// 封装到model中，传递给jsp页面
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("page", page);
		// 跳转到jsp页面user/userList.jsp
		/*
	    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/pages/"></property>
        <property name="suffix" value=".jsp"></property>
	    </bean>
	    */
		// spring-mvc.xml中配置已经限定了在pages下查找.jsp文件，所以只返回user/userList即可
		return PAGE_USER_LIST;
	}
	
	/**
	 * 查询用户信息
	 * 
	 * <pre>
	 * /{id}，rest形式，前端调用url时为：/user/1，其中的1代表{id}中的id
	 * 也参数@PathVariable Long id中获取，即：id=1
	 * </pre>
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/{id}")
	public String getUser(@PathVariable Long id, Model model) {
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		return PAGE_USER_INFO;
	}
	
	/**
	 * 删除用户
	 * @param id    删除用户的id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object deleteUser(@RequestParam("id") Long id, Model model) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		try {
			int count = userService.deleteById(id);
			log.info("删除数据：{}条。",count);
		} catch (Exception e) {
			log.error("删除数据失败：", e);
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 保存用户
	 * 
	 * <pre>
	 * @ModelAttribute("user") 是将前端表单中的对象根据名字绑定在user对象中
	 * </Pre>
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		if (user!=null) {
			if (user.getId()==null) {
				// 新增
				int count = userService.save(user);
				log.info("插入数据{}条", count);
			} else {
				// 修改
				int count = userService.updateNotNull(user);
				log.info("更新数据{}条", count);
			}
		} else {
			log.error("用户不能为空！");
		}
		// 重定向 : /user/list
		return "redirect:list";
	}
	
}
