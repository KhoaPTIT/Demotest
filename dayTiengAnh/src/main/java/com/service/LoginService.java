package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.repository.UserRepository;
import com.request.RequestUser;
import com.service.imp.LoginServiceImp;
import com.userDTO.UserDTO;

@Service
public class LoginService implements LoginServiceImp {
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
	@Override
	public boolean checkLogin(String username, String pass) {
		List<UserEntity> user = userRes.findByUserAndPass(username, pass);
		if(user.size() <= 0)
			return false;
		return true;
//		System.out.println("pass   " + pass);
//		System.out.println("passuser   " + user.getPass());
//		if(passwordEncoder.matches(pass, passwordEncoder.encode(user.getPass()))) {
//			return true;
//		}
//		return false;
//		Dựa vào usersecurity, tự động mã hóa encode cho pass truyền vào
	}
	@Override
	public int addUser(RequestUser requestuser) {
		UserEntity userAdd = new UserEntity();
//		List<UserEntity> userRight = userRes.findByUser(requestuser.getUser());
//		if(userRight.size() > 0)
//			return 2;
		userAdd.setUser(requestuser.getUser());
		userAdd.setPass(requestuser.getPass());
		
		try {
			userRes.save(userAdd);
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
		
	}

}
