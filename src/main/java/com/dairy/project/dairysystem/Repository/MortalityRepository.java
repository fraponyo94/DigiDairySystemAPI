package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Mortality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortalityRepository extends JpaRepository<Mortality,String > {
}
