package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class MenuController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}