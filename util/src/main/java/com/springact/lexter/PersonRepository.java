package com.spring.lexter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	// @Override
	// public List<Role> findAll();

}