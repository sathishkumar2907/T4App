package com.petzo.services;

import java.util.List;

import com.petzo.DTO.RoleDTO;
import com.petzo.DTO.UserDTO;

public interface UserService {
 
	void saveUser(UserDTO userDTO);
	UserDTO findUserByEmail(String email);
	List<RoleDTO> getRoles();
}
