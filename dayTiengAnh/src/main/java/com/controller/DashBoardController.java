package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.responseData.ResponseData;

@CrossOrigin
@RestController
@RequestMapping("/dashboard")
public class DashBoardController {
	@PostMapping("")
	public ResponseEntity<?> dash(@RequestParam String user, @RequestParam String pass){
		ResponseData response = new ResponseData();
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
