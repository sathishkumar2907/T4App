package com.petzo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petzo.DTO.RoleDTO;

@Repository
public interface RoleRepository extends JpaRepository<RoleDTO, Long> {
	RoleDTO findByRole(String role);
}
