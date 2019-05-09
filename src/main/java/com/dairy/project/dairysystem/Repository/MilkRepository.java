package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Milk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkRepository extends JpaRepository<Milk,Integer> {
}
