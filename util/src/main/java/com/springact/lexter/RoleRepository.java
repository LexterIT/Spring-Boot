package com.spring.lexter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	// @Override
	// public List<Role> findAll();

}