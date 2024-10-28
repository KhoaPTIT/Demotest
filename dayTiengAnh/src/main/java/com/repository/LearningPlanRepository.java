package com.repository;

import com.entity.LearningPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LearningPlanRepository extends JpaRepository<LearningPlanEntity, Integer> {
    List<LearningPlanEntity> findByUserId(Integer userId);
}
