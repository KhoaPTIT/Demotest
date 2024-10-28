package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer>{

}
