package com.service.imp;

import com.entity.LearningPlanEntity;
import com.repository.LearningPlanRepository;
import com.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningPlanServiceImpl implements LearningPlanService {

    @Autowired
    private LearningPlanRepository learningPlanRepository;

    @Override
    public List<LearningPlanEntity> getLearningPlansByUserId(int userId) {
        return learningPlanRepository.findByUserId(userId);
    }

    @Override
    public LearningPlanEntity updateLearningPlan(int planId, LearningPlanEntity updatedPlan) {
        LearningPlanEntity plan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        plan.setTasks(updatedPlan.getTasks());
        plan.setDueDate(updatedPlan.getDueDate());
        return learningPlanRepository.save(plan);
    }

    @Override
    public LearningPlanEntity markAsComplete(int planId) {
        LearningPlanEntity plan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        plan.setCompleted(true);
        return learningPlanRepository.save(plan);
    }
}
