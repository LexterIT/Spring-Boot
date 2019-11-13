package com.spring.lexter;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

@Service
public class PersonConverter {

	@Autowired
	private ModelMapper modelMapper;

	public PersonDTO entityToDTO(Person person) {
		PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
		return personDTO;
	}

	public Person dtoToEntity(PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);
		return person;
	}

}