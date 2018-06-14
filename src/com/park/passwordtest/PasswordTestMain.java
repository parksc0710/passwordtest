package com.park.passwordtest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class PasswordTestMain {

	public static void main(String[] args) {

		String rawPassword = "1234";
		String name = "park";
		
		String bcpeEncodedPw = null;		
		String md5peEncodedPw = null;
		
		boolean bcpeMatch = false;
		boolean md5peMatch = false;
		
		
		// encode
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		for(int i = 1; i <6; i++){
			bcpeEncodedPw = bcpe.encode(rawPassword);
			System.out.println(i + "번째 비밀번호 : " + bcpeEncodedPw);
		}
		
		
		System.out.println();
		
		
		PasswordEncoder md5pe = new Md5PasswordEncoder();
		
		for(int i = 1; i < 6; i++){
			md5peEncodedPw = md5pe.encodePassword(rawPassword, name);
			System.out.println(i + "번째 비밀번호 : " + md5peEncodedPw);
		}
		
		
		System.out.println();
		
		
		// match
		bcpeMatch = bcpe.matches("1234", bcpeEncodedPw);
		md5peMatch = md5pe.isPasswordValid(md5peEncodedPw, "1234", name);
		
		System.out.println("bcpeMatch : " + bcpeMatch);
		System.out.println("md5peMatch : " + md5peMatch);
	}

}
