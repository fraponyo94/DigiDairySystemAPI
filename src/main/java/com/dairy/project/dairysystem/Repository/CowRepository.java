package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Cow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowRepository extends JpaRepository<Cow,String > {
}
