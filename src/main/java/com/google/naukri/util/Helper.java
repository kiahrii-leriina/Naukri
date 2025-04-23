package com.google.naukri.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.naukri.entity.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Helper {

	@Autowired
	private JavaMailSender jms;
	
	
	public void sendEmail(User user) {
		MimeMessage mm = jms.createMimeMessage();
		
		try {
			MimeMessageHelper mmh=  new MimeMessageHelper(mm,true);
			mmh.setTo(user.getEmail());		
			mmh.setSubject("account created successfully");
			mmh.setText("dear "+user.getName()+" ur naukri account has been created successfully, your otp is: "+user.getOtp());
			jms.send(mm);
		
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static int getOTP() {
		int otp = (int) Math.random() * 10000;

		while (otp <= 1000) {
			otp = (int) (Math.random() * 10000);
		}

		return otp;
	}

}
