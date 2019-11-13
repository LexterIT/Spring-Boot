package com.spring.lexter;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Service
public class RoleConverter {

	@Autowired
	private ModelMapper modelMapper;

	public RoleDTO entityToDTO(Role role) {
		RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
		return roleDTO;
	}

	public Role dtoToEntity(RoleDTO roleDTO) {
		Role role = modelMapper.map(roleDTO, Role.class);
		return role;
	}

}