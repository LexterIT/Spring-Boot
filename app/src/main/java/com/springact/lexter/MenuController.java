package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;


@Controller
public class MenuController {

	// @RequestMapping("/index")
	// public String index() {
	// 	return "index";
	// }
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	// @RequestMapping(value="/index")
	// public String roleViewPage(ModelMap model, @RequestParam String choice) {
	// 	System.out.println(choice);
	// 	if(choice.equalsIgnoreCase("role")) {
	// 		model.put("choice",choice);
	// 		return "rolesview";
	// 	}
	// 	return "index";
	// }
}