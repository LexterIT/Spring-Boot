package com.spring.lexter;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContactServiceIMPL implements ContactService {

	@Autowired
	private HibernateUtil hibernateUtil;

	public ContactServiceIMPL(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public List<ContactType> getContactTypes() {
		List<ContactType> contactTypes = null;
		contactTypes = hibernateUtil.getSorted(ContactType.class, "id", "asc");
		return contactTypes;
	}

	public ContactType getContactType(int id) {
		ContactType contactType = (ContactType) hibernateUtil.getSingleObject(ContactType.class, id);
		if(contactType == null)
			return null;
		return contactType;
	}

	public void addContactType(ContactType contactType) {
		hibernateUtil.insertObject(contactType);
	}

	public void updatePerson(ContactType contactType) {
		hibernateUtil.updateObject(contactType);
	}

	public void deletePerson(ContactType contactType) {
		hibernateUtil.deleteObject(contactType);
	}
}