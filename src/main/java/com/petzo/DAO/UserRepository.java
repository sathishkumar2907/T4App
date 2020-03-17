package com.petzo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petzo.DTO.RoleDTO;
import com.petzo.DTO.UserDTO;


@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long>{
	UserDTO findByEmail(String email);
}
