package com.petzo.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petzo.DAO.RoleRepository;
import com.petzo.DAO.UserRepository;
import com.petzo.DTO.RoleDTO;
import com.petzo.DTO.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveUser(UserDTO userDTO) {
		RoleDTO roleDTO;
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		userDTO.setActive(1);
		roleDTO=roleRepository.findByRole("USER");
		userDTO.setRoles(new HashSet<RoleDTO>(Arrays.asList(roleDTO)));
		userRepository.save(userDTO);
	}
	

	@Override
	public UserDTO findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<RoleDTO> getRoles() {
		return roleRepository.findAll();
	}
	
	

}
