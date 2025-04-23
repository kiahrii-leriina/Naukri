package com.google.naukri.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.naukri.entity.User;
import com.google.naukri.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository urepo;

	public User saveUser(User user) {
		return urepo.save(user);
	}

	public Optional<User> findByNameAndEmail(String name, String email) {
		return urepo.findByNameAndEmail(name,email);
	}

	public List<User> findAll() {
		return urepo.findAll();
	}

	public void deleteUser(int id) {
		urepo.deleteById(id);
	}

	public Optional<User> findById(int id) {
		return urepo.findById(id);
	}

	public Optional<User> findByEmailAndPhone(String email, long phone) {
		
		return urepo.findByEmailAndPhone(email,phone);
	}

	public Optional<User> findByEmail(String email) {
		return urepo.findByEmail(email);
	}
}
