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
import java.util.stream.Collectors;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping(value="/person")
public class TempPersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ContactService contactService;

	@RequestMapping(value="/person")
	public ModelAndView readPeople(Model model){
		ModelAndView mv = new ModelAndView("person.jsp");
		mv.addObject("people", personService.readPeople());
		return mv;
	}

	@RequestMapping(value="/{id}")
	public ModelAndView readSinglePerson(@PathVariable String id){
		ModelAndView mv = new ModelAndView("singlePerson.jsp");
		int personId = Integer.parseInt(id);
		mv.addObject("person", personService.getPerson(personId));
		return mv;
	}

	@RequestMapping(value="/addPersonForm")
	public String addPersonForm() {
		return "addPersonForm.jsp";
	}

	@RequestMapping(value="/addPerson")
	public ModelAndView addPerson(Person person) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/person"));
		personService.addPerson(person);
		System.out.println("addPerson: " + person);
		return mv;
	}

	@RequestMapping(value="/delete/{id}")
	public ModelAndView deletePerson(@PathVariable int id) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/person"));
		Person person = personService.getPerson(id);
		personService.deletePerson(person);
		return mv;
	}

	@RequestMapping(value="/edit/{id}")
	public ModelAndView editPersonForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editPersonForm.jsp");
		// System.out.println(id);
		// int personId = Integer.parseInt(id);
		Person person = personService.getPerson(id);
		System.out.println(person);
		mv.addObject("person",person);
		return mv;
	}

	@RequestMapping(value="/edit/updatePerson")
	public ModelAndView updatePerson(@ModelAttribute Person person,@RequestParam Map<String,String> params) {
		ModelAndView mv = new ModelAndView("updatePersonResult.jsp");
		System.out.println("updatePerson" + person);
		Person tempPerson = personService.getPerson(person.getId());
		if(params.get("roleUpdate").equalsIgnoreCase("false")) {	
			Set<Role> roles = tempPerson.getRoles();
			person.setRoles(roles);
		}
		if(params.get("contactUpdate").equalsIgnoreCase("false")) {
			List<ContactInfo> contacts = tempPerson.getContactInfo();
			person.setContactInfo(contacts);
		}
		personService.updatePerson(person);
		mv.addObject("person",person);
		return mv;
	}

	@RequestMapping(value="/edit/roles/{id}")
	public ModelAndView updatePersonRole(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editPersonRolesForm.jsp");
		Person person = personService.getPerson(id);
		List<Role> roles = roleService.readRoles();
		List<Role> tempRoles = new ArrayList<Role>(roles);
		for(Role role : tempRoles) {
			for(Role tempRole : person.getRoles()) {
				if(role.toString().equals(tempRole.toString())) {
					roles.remove(role);
				}
			}
		}
		System.out.println("roles after removeall" + roles);
		mv.addObject("personid", person.getId());
		mv.addObject("personroles", person.getRoles());
		mv.addObject("roles", roles);
		return mv;
	}

	@RequestMapping(value="/edit/roles/add/{id}")
	public ModelAndView updatePersonRoleAdd(@PathVariable int id, @RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/roles/"+params.get("personid")));
		Role role = roleService.getRole(id);
		System.out.println(role);
		int personId = Integer.parseInt(params.get("personid"));
		Person person = personService.getPerson(personId);
		System.out.println("personRols before Add" + person.getRoles());
		person.getRoles().add(role);
		System.out.println("personRolse after Add" + person.getRoles());
		personService.updatePerson(person);
		return mv;
	}

	@RequestMapping(value="/edit/roles/delete/{id}")
	public ModelAndView updatePersonRoleDelete(@PathVariable int id, @RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/roles/"+params.get("personid")));
		Role role = roleService.getRole(id);
		System.out.println(role);
		int personId = Integer.parseInt(params.get("personid"));
		Person person = personService.getPerson(personId);
		System.out.println("personRoles before Delete" + person.getRoles());
		Set<Role> roles = person.getRoles();
		List<Role> tempRoles = new ArrayList<>(person.getRoles());
		for(Role tempRole : tempRoles) {
			if(tempRole.toString().equals(role.toString())) {
				roles.remove(tempRole);
			}
		}
		person.setRoles(roles);
		System.out.println("personRoles after Delete" + roles);
		personService.updatePerson(person);
		return mv;
	}	

	@RequestMapping(value="/edit/contactInfo/{id}")
	public ModelAndView editPersonContacts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editContactInfo.jsp");
		Person person = personService.getPerson(id);
		System.out.println("EditPersonContacts" + person.getContactInfo());
		mv.addObject("contactTypes",contactService.getContactTypes());
		mv.addObject("person", person);
		return mv;
	}

	@RequestMapping(value="/edit/contactInfo/add")
	public ModelAndView editPersonContactsAdd(ContactInfo contactInfo, @RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/contactInfo/"+params.get("personid")));
		int id = Integer.parseInt(params.get("personid"));
		Person person = personService.getPerson(id);
		System.out.println("editPersonAdd" + contactInfo.getId() + contactInfo);
		person.getContactInfo().add(contactInfo);
		personService.updatePerson(person);
		return mv;
	}

	@RequestMapping(value="/edit/contactInfo/delete/{id}")
	public ModelAndView editPersonContactsDelete(ContactInfo contactInfo, @PathVariable int id) {
		ModelAndView mv = new ModelAndView(new RedirectView("/person/edit/contactInfo/"+id));
		Person person = personService.getPerson(id);
		System.out.println(contactInfo.getId() + "" +contactInfo);
		System.out.println(person.getContactInfo());

		List<ContactInfo> contactInfos = person.getContactInfo();
		List<ContactInfo> tempContactInfo = person.getContactInfo();

		contactInfos = contactInfos.stream().filter( c -> contactInfo.getId() != c.getId()).collect(Collectors.toList());

		person.setContactInfo(contactInfos);

		personService.updatePerson(person);
		return mv;
	}
}