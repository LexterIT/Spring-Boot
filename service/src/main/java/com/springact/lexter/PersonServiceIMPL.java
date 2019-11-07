package com.spring.lexter;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonServiceIMPL implements PersonService{

	@Autowired
	private HibernateUtil hibernateUtil;

	public PersonServiceIMPL(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public List<Person> readPeople() {
		List<Person> people = null;
		people = hibernateUtil.getSorted(Person.class, "id", "asc");
		return people;
	}

	public Person getPerson(int id) {
		Person person = (Person) hibernateUtil.getSingleObject(Person.class, id);
		System.out.println("PersonService getPerson" + person);
		if(person == null) 
			return null;
		return person;
	}

	public void addPerson(Person person) {
		hibernateUtil.insertObject(person);
	}

	public void updatePerson(Person person) {
		System.out.println("updatePersonService: " + person);
		hibernateUtil.updateObject(person);
		System.out.println(getPerson(person.getId()));
	}

	public void deletePerson(Person person) {
		hibernateUtil.deleteObject(person);
	}
}