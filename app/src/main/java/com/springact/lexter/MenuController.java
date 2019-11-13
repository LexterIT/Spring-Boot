package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class MenuController {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	// @RequestMapping("/index")
	// public String index() {
	// 	return "index";
	// }
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/home")
	public String home2() {
		return "home.jsp";
	}

	@RequestMapping("/login")
	public String loginPage()
	{
		return "login.jsp";
	}

	@RequestMapping("/registerform")
	public String registerForm() {
		return "registerform.jsp";
	}

	@RequestMapping(value="/register")
	public ModelAndView registerSuccess(UserDTO userDTO) {
		System.out.println("abc" + userDTO);
		ModelAndView mv = new ModelAndView(new RedirectView("registerform.jsp"));
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		User user = new User(userDTO.getUsername(), encodedPassword);
		userDetailsService.addUser(user);
		return mv;
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}

	// @RequestMapping
	// public String login() {
	// 	return "login.jsp";
	// }

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