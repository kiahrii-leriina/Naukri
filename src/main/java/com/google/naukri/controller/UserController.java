package com.google.naukri.controller;

import java.time.LocalTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.naukri.entity.User;
import com.google.naukri.service.UserService;
import com.google.naukri.util.ResponseStructure;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService uservice;

	@RequestMapping
	public String live() {
		return "<html><body><h2>Spring Application is live</h2></body></html>";
	}

	@PostMapping()
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return uservice.saveUser(user);
	}

//	@Scheduled(fixedRate = 1000)
//	public String hi() {
//		System.out.println(" happy new year"+LocalTime.now());
//		return "hello";
//	}
//	
//	@Scheduled(fixedRate = 1000*60*60*24)
//	public String dailyReminder() {
//		System.out.println("daily reminder");
//		return "daily reminder";
//	}

	@GetMapping("/login/{name}/{email}")
	public ResponseEntity<ResponseStructure<User>> login(@PathVariable(name = "name") String name,
			@PathVariable(name = "email") String email) {
		return uservice.login(name, email);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<User>> findAll() {
		return uservice.findAll();
	}

	@DeleteMapping("/del/{username}/{email}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable(name = "username") String name,
			@PathVariable(name = "email") String email) {
		
		return uservice.deleteUser(name, email);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<User>> permanentDelete(@PathVariable(name = "id") int id){
		return uservice.permanentDelete(id);
	}






}






