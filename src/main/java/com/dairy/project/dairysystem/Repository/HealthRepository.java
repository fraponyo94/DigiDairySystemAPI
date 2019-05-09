package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Health,Integer> {
}
