package com.google.naukri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.naukri.dao.EducationDao;
import com.google.naukri.entity.Education;
import com.google.naukri.entity.User;
import com.google.naukri.repository.UserRepository;
import com.google.naukri.util.ResponseStructure;

import jakarta.transaction.Transactional;

@Service
public class EducationService {

	@Autowired
	private EducationDao edao;
	
	@Autowired
	private UserRepository urepo;

	@Transactional
	public ResponseEntity<ResponseStructure<Education>> saveEducation(Education edu) {
		
		Optional<User> user =  urepo.findById(edu.getUserid());
		if(user.isEmpty()) {
			throw new RuntimeException(" no user found ");
		}
		
		
		edu.setUser(user.get());
		Education savededu = edao.saveEducation(edu);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Education saved successfuly").body(savededu).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);
		
		return re;
	}

}
