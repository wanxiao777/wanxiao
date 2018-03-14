package cn.wx.crm.handler;

import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.wx.crm.entity.User;
import cn.wx.crm.service.UserService;

@SessionAttributes({"message","user"})
@RequestMapping(value="/user")
@Controller
@Scope(value="prototype")
public class UserHandler {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@Param("username") String username,@Param("password") String password,
			Map<String, Object> map,Locale locale){
		User user = userService.login(username, password);
		if(user != null && user.getEnabled() == 1 && user.getPassword().equals(password)){
			map.put("user", user);
			return "redirect:/success";
		}
		String message = messageSource.getMessage("user.login.error", null, locale);
		map.put("message",message);
		return "redirect:/index.jsp";
	}
}
