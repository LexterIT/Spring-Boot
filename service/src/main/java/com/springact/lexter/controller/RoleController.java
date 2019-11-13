package com.spring.lexter;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class RoleController {

	@Autowired
	private RoleService roleSerivce;

	@Autowired
	private RoleConverter roleConverter;

	@RequestMapping(value="/roles")
	public ModelAndView readRoles(){
		ModelAndView mv = new ModelAndView("roles.jsp");
		mv.addObject("roles", roleSerivce.readRoles());
		return mv;
	}

	@RequestMapping(value="/addRole")
	public ModelAndView addRole(RoleDTO roleDTO) {
		ModelAndView mv = new ModelAndView(new RedirectView("/role/roles"));
		Role role = roleConverter.dtoToEntity(roleDTO);
		roleSerivce.addRole(role);
		return mv;
	}

	@RequestMapping(value="/addRoleForm")
	public String addRoleForm() {
		return "addRoleForm.jsp";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRoleForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editRoleForm.jsp");
		Role role = roleSerivce.getRole(id);
		RoleDTO roleDTO = roleConverter.entityToDTO(role);
		mv.addObject("role",roleDTO);
		return mv;
	}

	@RequestMapping(value="/edit/updateRole")
	public ModelAndView updateRole(RoleDTO roleDTO) {
		ModelAndView mv = new ModelAndView(new RedirectView("/role/roles"));
		Role role = roleConverter.dtoToEntity(roleDTO);
		roleSerivce.updateRole(role);
		return mv;
	}

	@RequestMapping(value="/delete/{id}")
	public ModelAndView deleteRoleForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("deleteRoleResult.jsp");
		roleSerivce.deleteRole(id);
		mv.addObject("roleId",id);
		return mv;	
	}

}