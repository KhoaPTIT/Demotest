package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JutHelper.JutHelper;
import com.entity.UserEntity;
import com.repository.UserRepository;
import com.request.RequestUser;
import com.responseData.ResponseData;
import com.service.LoginService;
import com.service.imp.LoginServiceImp;
import com.userDTO.UserDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class LoginController {
	@Autowired
	LoginServiceImp loginserviceimp;
	
	@Autowired
	JutHelper jutHelper;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestParam String user, @RequestParam String pass){
		ResponseData response = new ResponseData();
		
//		SecretKey key = Jwts.SIG.HS256.key().build();
//		String secretString = Encoders.BASE64.encode(key.getEncoded());
//		System.out.println("Secret:   " + secretString);
		String token = jutHelper.generateToken(user);
		System.out.println("1  " + user);
		System.out.println("2   " + pass);
//		System.out.println(loginserviceimp.checkLogin(user, pass));
		boolean check = loginserviceimp.checkLogin(user, pass);
		response.setSuccess(check);
		System.out.println(check);
		if(check) {
			response.setData(token);
			System.out.println(token);
		}
		else {
			response.setData("");
		}
		
		System.out.println("done");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody RequestUser requestuser){
		ResponseData response = new ResponseData();
//		System.out.println(requestuser.getUser());
//		System.out.println(requestuser.getPass());
		int status = loginserviceimp.addUser(requestuser);
		response.setSuccess(status == 1);
		response.setStatus(status);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
