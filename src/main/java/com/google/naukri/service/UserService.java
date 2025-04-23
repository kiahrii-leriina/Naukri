package com.google.naukri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.naukri.dao.UserDao;
import com.google.naukri.entity.User;
import com.google.naukri.exceptionClass.DuplicateData;
import com.google.naukri.exceptionClass.EmptyListException;
import com.google.naukri.exceptionClass.InvalidCredentials;
import com.google.naukri.util.Helper;
import com.google.naukri.util.ResponseStructure;
import com.google.naukri.util.UserStatus;

@Service
public class UserService {

	@Autowired
	private UserDao udao;

	@Autowired
	private Helper helper;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		Optional<User> user1 = udao.findByEmail(user.getEmail());

		if (user1.isPresent()) {
			throw new DuplicateData("Duplicate Data");
		}

		int otp = Helper.getOTP();

		user.setOtp(otp);

		User saveduser = udao.saveUser(user);

		helper.sendEmail(saveduser);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("user saved successfully").body(saveduser).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<ResponseStructure<User>> login(String name, String email) {

		Optional<User> user = udao.findByNameAndEmail(name, email);

		if (user.isEmpty()) {
			throw new InvalidCredentials("user with name: " + name + " and email: " + email + " not found");
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value()).message("login successfull")
				.body(user).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);
		return re;
	}

	public ResponseEntity<ResponseStructure<User>> findAll() {

		List<User> users = udao.findAll();

		if (users.isEmpty()) {
			throw new EmptyListException("empty list, No user found ");
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value()).message("list of users")
				.body(users).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(String name, String email) {

		Optional<User> byNameAndEmail = udao.findByNameAndEmail(name, email);

		if (byNameAndEmail.isEmpty()) {
			throw new InvalidCredentials("No account found with name: " + name + " and email: " + email);
		}

		User user = byNameAndEmail.get();

		user.setStatus(UserStatus.DELETED);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("user deleted, status set to deleted").body(user).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<ResponseStructure<User>> permanentDelete(int id) {

		udao.deleteUser(id);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("user deleted successfully").body(null).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}
}
