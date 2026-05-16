package com.tuempresa.centrodeportivo.repository;

import com.tuempresa.centrodeportivo.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}