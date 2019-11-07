package com.spring.lexter;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

public interface ContactService {

	List<ContactType> getContactTypes();

	ContactType getContactType(int id);

	void addContactType(ContactType contactType);

	void updatePerson(ContactType contactType);

	void deletePerson(ContactType contactType);
}