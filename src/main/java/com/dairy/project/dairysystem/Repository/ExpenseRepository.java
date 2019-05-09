package com.dairy.project.dairysystem.Repository;

import com.dairy.project.dairysystem.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Integer> {
}
