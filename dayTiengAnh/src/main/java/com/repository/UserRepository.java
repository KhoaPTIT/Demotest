package com.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	List<UserEntity> findByUserAndPass(String user, String pass);
//	Boolean existByUser(String user);
//	List<UserEntity> findByUser(String user);
	UserEntity findByUser(String user);
}
