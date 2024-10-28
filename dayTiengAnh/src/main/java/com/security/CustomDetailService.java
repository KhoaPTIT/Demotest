package com.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;
import com.entity.UserEntity;


@Service
public class CustomDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRes;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserEntity user = userRes.findByUser(name);
		if(user == null) {
			throw new UsernameNotFoundException("Tai khoan khong ton tai");
		}
		return new User(name, passwordEncoder.encode(user.getPass()), new ArrayList<>());
	}
}
