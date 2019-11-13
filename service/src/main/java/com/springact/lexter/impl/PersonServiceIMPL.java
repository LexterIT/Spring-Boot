package com.spring.lexter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.text.DateFormat;  

@Service
public class PersonServiceIMPL implements PersonService{

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private PersonRepository personRepository;

	public PersonServiceIMPL(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public List<Person> readPeople() {
		List<Person> people = new ArrayList<Person>();
		personRepository.findAll().forEach(p -> people.add(p));
		return people;
	}

	public Person getPerson(int id) {
		Person person = personRepository.findById(id).get();
		if(person == null) 
			return null;
		return person;
	}

	public void addPerson(Person person) {
		// hibernateUtil.insertObject(person);
		personRepository.save(person);
	}

	public void updatePerson(Person person) {
		personRepository.save(person);
	}

	public void deletePerson(int id) {
		personRepository.deleteById(id);
	}
}