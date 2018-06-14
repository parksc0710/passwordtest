package com.park.passwordtest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class PasswordTestMain {

	public static void main(String[] args) {

		String rowPassword = "1234";
		String name = "park";
		
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		for(int i = 1; i <6; i++){
			String bcpeEncodedPw = bcpe.encode(rowPassword);
			System.out.println(i + "번째 비밀번호 : " + bcpeEncodedPw);
		}
		
		System.out.println();
		
		PasswordEncoder md5pe = new Md5PasswordEncoder();
		
		for(int i = 1; i < 6; i++){
			String md5peEncodedPw = md5pe.encodePassword(rowPassword, name);
			System.out.println(i + "번째 비밀번호 : " + md5peEncodedPw);
		}
	}

}
