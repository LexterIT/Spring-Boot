package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@RequestMapping(value="/role")
@Controller
public class TempRoleController {

	@Autowired
	private RoleService roleSerivce;

	@RequestMapping(value="/roles")
	public ModelAndView readRoles(Model model){
		ModelAndView mv = new ModelAndView("roles.jsp");
		mv.addObject("roles", roleSerivce.readRoles());
		return mv;
	}

	@RequestMapping(value="/addRole")
	public ModelAndView addRole(Role role) {
		ModelAndView mv = new ModelAndView(new RedirectView("/role/roles"));
		System.out.println(role);
		roleSerivce.addRole(role);
		return mv;
	}

	@RequestMapping(value="/addRoleForm")
	public String addRoleForm() {
		return "addRoleForm.jsp";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRoleForm(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("editRoleForm.jsp");
		System.out.println(id);
		int roleId = Integer.parseInt(id);
		Role role = roleSerivce.getRole(roleId);
		mv.addObject("role",role);
		return mv;
	}

	@RequestMapping(value="/edit/updateRole")
	public ModelAndView updateRole(Role role) {
		ModelAndView mv = new ModelAndView(new RedirectView("/role/roles"));
		roleSerivce.updateRole(role);
		System.out.println(role);
		return mv;
	}

	@RequestMapping(value="/delete/{id}")
	public ModelAndView deleteRoleForm(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("deleteRoleResult.jsp");
		int roleId = Integer.parseInt(id);
		roleSerivce.deleteRole(roleId);
		mv.addObject("roleId",roleId);
		return mv;	
	}

}