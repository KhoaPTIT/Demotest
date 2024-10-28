package com.controller;

import com.entity.LearningPlanEntity;
import com.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learningPlans")
public class LearningPlanController {

    @Autowired
    private LearningPlanService learningPlanService;

    @GetMapping("/{userId}")
    public List<LearningPlanEntity> getLearningPlansByUserId(@PathVariable int userId) {
        return learningPlanService.getLearningPlansByUserId(userId);
    }

    @PutMapping("/{planId}")
    public ResponseEntity<LearningPlanEntity> updateLearningPlan(@PathVariable int planId, @RequestBody LearningPlanEntity plan) {
        return ResponseEntity.ok(learningPlanService.updateLearningPlan(planId, plan));
    }

    @PutMapping("/{planId}/complete")
    public ResponseEntity<LearningPlanEntity> markAsComplete(@PathVariable int planId) {
        return ResponseEntity.ok(learningPlanService.markAsComplete(planId));
    }
}
