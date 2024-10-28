package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.request.RequestUser;
import com.service.imp.UserServiceImp;
import com.userDTO.UserDTO;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	@Autowired
	UserServiceImp userimp;

	@PostMapping("")
	public ResponseEntity<?> user(){
		return new ResponseEntity<>(userimp.getAllUser(), HttpStatus.OK);
	}
}
