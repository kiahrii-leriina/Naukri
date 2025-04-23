package com.google.naukri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.naukri.entity.Education;
import com.google.naukri.service.EducationService;
import com.google.naukri.util.ResponseStructure;

@RestController
@RequestMapping("/education")
public class EducationController {
	
	@Autowired
	private EducationService eservice;
	
//	@RequestMapping("/hi")
//	public String hi() {
//		return "<html><body><h2> Hiiiiii</h2></body></html>";
//	}
	
	@PostMapping()
	public ResponseEntity<ResponseStructure<Education>> saveEducation(@RequestBody Education edu){
		
		return eservice.saveEducation(edu);
	}
	
	
	
	
	
	
	
	
	
	
	
}

