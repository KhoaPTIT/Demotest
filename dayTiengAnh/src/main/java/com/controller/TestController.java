package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.imp.TestServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestController {
	@Autowired
	TestServiceImp testImp;
	
	@PostMapping("")
	public ResponseEntity<?> test(){
		
		return new ResponseEntity<>(testImp.getAllTest(), HttpStatus.OK);
	}
}
