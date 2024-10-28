package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.repository.UserRepository;
import com.service.imp.UserServiceImp;
import com.userDTO.UserDTO;

@Service
public class UserService implements UserServiceImp{
	@Autowired
	UserRepository userRes;
	@Override
	public List<UserDTO> getAllUser(){
		List<UserEntity> user = userRes.findAll();
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		for(UserEntity i : user) {
			UserDTO us = new UserDTO();
			us.setId(i.getId());
			us.setUser(i.getUser());
			us.setStatus(i.getStatus());
			us.setPass(i.getPass());
//			System.out.println(i.getUser());
			userDTO.add(us);
		}
		return userDTO;
	}
}
