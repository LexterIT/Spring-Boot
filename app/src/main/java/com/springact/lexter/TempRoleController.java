package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@SessionAttributes("choice")
public class TempRoleController {

	@Autowired
	private RoleService roleSerivce;

	@RequestMapping(value="/rolesview", method = RequestMethod.GET)
	public String readRoles(Model model){
		model.addAttribute("roles", roleSerivce.readRoles());
		return "rolesview";
	}
}