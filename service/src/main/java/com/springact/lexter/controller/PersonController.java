package com.spring.lexter;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.util.Date;

import java.util.stream.Collectors;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	private PersonConverter personConverter;

	@Autowired
	private RoleConverter roleConverter;

	@Autowired
	private PersonService personService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ContactService contactService;

	@RequestMapping(value="/person")
	public ModelAndView readPeople(){
		ModelAndView mv = new ModelAndView("person.jsp");
		mv.addObject("people", personService.readPeople());
		return mv;
	}

	@RequestMapping(value="/{id}")
	public ModelAndView readSinglePerson(@PathVariable int id){
		ModelAndView mv = new ModelAndView("singlePerson.jsp");
		Person person = personService.getPerson(id);
		PersonDTO personDTO = personConverter.entityToDTO(person);
		mv.addObject("person", personDTO);
		return mv;
	}

	@RequestMapping(value="/addPersonForm")
	public String addPersonForm() {
		return "addPersonForm.jsp";
	}

	@RequestMapping(value="/addPerson")
	public ModelAndView addPerson(PersonDTO personDTO) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/person"));
		Person person = personConverter.dtoToEntity(personDTO);
		personService.addPerson(person);
		return mv;
	}

	@RequestMapping(value="/delete/{id}")
	public ModelAndView deletePerson(@PathVariable int id) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/person"));
		personService.deletePerson(id);
		return mv;
	}

	@RequestMapping(value="/edit/{id}")
	public ModelAndView editPersonForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editPersonForm.jsp");
		Person person = personService.getPerson(id);
		PersonDTO personDTO = personConverter.entityToDTO(person);
		mv.addObject("person", personDTO);
		return mv;
	}

	@RequestMapping(value="/edit/updatePerson")
	public ModelAndView updatePerson(@ModelAttribute PersonDTO personDTO) {
		ModelAndView mv = new ModelAndView("updatePersonResult.jsp");
		Person person = personConverter.dtoToEntity(personDTO);
		Person tempPerson = personService.getPerson(person.getId());
		person.setRoles(tempPerson.getRoles());
		person.setContactInfo(tempPerson.getContactInfo());
		personService.updatePerson(person);
		personDTO = personConverter.entityToDTO(person);
		mv.addObject("person", personDTO);
		return mv;
	}

	@RequestMapping(value="/edit/roles/{id}")
	public ModelAndView updatePersonRole(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editPersonRolesForm.jsp");
		Person person = personService.getPerson(id);
		PersonDTO personDTO = personConverter.entityToDTO(person);
		List<Role> roles = roleService.readRoles();
		List<Role> tempRoles = new ArrayList<Role>(roles);
		for(Role role : tempRoles) {
			for(Role tempRole : personDTO.getRoles()) {
				if(role.toString().equals(tempRole.toString())) {
					roles.remove(role);
				}
			}
		}
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		roles.forEach(r -> roleDTOs.add(roleConverter.entityToDTO(r)));
		mv.addObject("personid", personDTO.getId());
		mv.addObject("personroles", personDTO.getRoles());
		mv.addObject("roles", roleDTOs);
		return mv;
	}

	@RequestMapping(value="/edit/roles/add/{id}")
	public ModelAndView updatePersonRoleAdd(@PathVariable int id, @RequestParam(value="personid") int personId) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/roles/"+personId));
		Role role = roleService.getRole(id);
		Person person = personService.getPerson(personId);
		person.getRoles().add(role);
		personService.updatePerson(person);
		return mv;
	}

	@RequestMapping(value="/edit/roles/delete/{id}")
	public ModelAndView updatePersonRoleDelete(@PathVariable int id, @RequestParam(value="personid") int personId) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/roles/"+personId));
		Role role = roleService.getRole(id);
		Person person = personService.getPerson(personId);
		Set<Role> roles = person.getRoles();
		List<Role> tempRoles = new ArrayList<>(person.getRoles());
		for(Role tempRole : tempRoles) {
			if(tempRole.toString().equals(role.toString())) {
				roles.remove(tempRole);
			}
		}
		person.setRoles(roles);
		personService.updatePerson(person);
		return mv;
	}	

	@RequestMapping(value="/edit/contactInfo/{id}")
	public ModelAndView editPersonContacts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editContactInfo.jsp");
		Person person = personService.getPerson(id);
		PersonDTO personDTO = personConverter.entityToDTO(person);
		mv.addObject("contactTypes",contactService.getContactTypes());
		mv.addObject("person", personDTO);
		return mv;
	}

	@RequestMapping(value="/edit/contactInfo/add")
	public ModelAndView editPersonContactsAdd(ContactInfo contactInfo, @RequestParam(value="personid") int personId) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/contactInfo/" + personId));
		Person person = personService.getPerson(personId);
		person.getContactInfo().add(contactInfo);
		personService.updatePerson(person);
		return mv;
	}

	@RequestMapping(value="/edit/contactInfo/delete/{id}")
	public ModelAndView editPersonContactsDelete(ContactInfo contactInfo, @PathVariable int id) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/contactInfo/"+id));
		Person person = personService.getPerson(id);
		List<ContactInfo> contactInfos = person.getContactInfo();
		List<ContactInfo> tempContactInfo = person.getContactInfo();
		contactInfos = contactInfos.stream().filter( c -> contactInfo.getId() != c.getId()).collect(Collectors.toList());
		person.setContactInfo(contactInfos);
		personService.updatePerson(person);
		return mv;
	}
}