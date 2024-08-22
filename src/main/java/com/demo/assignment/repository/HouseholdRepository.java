package com.demo.assignment.repository;

import com.demo.assignment.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, String> {
}
