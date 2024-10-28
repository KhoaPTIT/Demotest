package com.service.imp;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.userDTO.UserDTO;

public interface UserServiceImp{
	public List<UserDTO> getAllUser();
}
