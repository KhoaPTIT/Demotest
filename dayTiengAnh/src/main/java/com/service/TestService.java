package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.entity.TestEntity;
import com.repository.TestRepository;
import com.service.imp.TestServiceImp;
import com.userDTO.TestDTO;

@Service
public class TestService implements TestServiceImp{
	@Autowired
	TestRepository testRepository;
	
	@Override
	public List<TestDTO> getAllTest(){
		PageRequest pageRequest = PageRequest.of(0, 6);
		Page<TestEntity> allTest = testRepository.findAll(pageRequest);

		List<TestDTO> test = new ArrayList<>();
		for(TestEntity i : allTest) {
			TestDTO k = new TestDTO();
			k.setImg(i.getImg());
			k.setQues(i.getQues());
			k.setDap(i.getDap());
			test.add(k);
		}
		return test;
	}
}
