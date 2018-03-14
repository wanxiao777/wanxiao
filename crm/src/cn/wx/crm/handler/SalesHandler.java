package cn.wx.crm.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/saleschance")
@Controller
@Scope(value="prototype")
public class SalesHandler {

	@RequestMapping(value="/list")
	public String list(){
		return "saleschance/list";
	}
}
