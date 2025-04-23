package com.google.naukri.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.naukri.entity.Education;
import com.google.naukri.repository.EducationRepository;

@Repository
public class EducationDao {

	@Autowired
	private EducationRepository erepo;

	public Education saveEducation(Education edu) {
		
		return erepo.save(edu);
	}
}
