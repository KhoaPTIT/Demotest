package com.service.imp;

import java.util.List;

import com.request.RequestUser;
import com.userDTO.UserDTO;

public interface LoginServiceImp {
	public List<UserDTO> getAllUser();
	public boolean checkLogin(String user, String pass);
	public int addUser(RequestUser requestuser);
}
