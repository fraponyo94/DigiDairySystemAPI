package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Calving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalvingRepository extends JpaRepository<Calving,Integer> {
}
