package com.google.naukri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.naukri.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByNameAndEmail(String name, String email);

	Optional<User> findByEmailAndPhone(String email, long phone);

	Optional<User> findByEmail(String email);

}
