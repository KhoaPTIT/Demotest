package com.service;

import com.entity.LearningPlanEntity;
import java.util.List;

public interface LearningPlanService {
    List<LearningPlanEntity> getLearningPlansByUserId(int userId);
    LearningPlanEntity updateLearningPlan(int planId, LearningPlanEntity updatedPlan);
    LearningPlanEntity markAsComplete(int planId);
}
