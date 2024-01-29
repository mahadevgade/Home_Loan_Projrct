package com.cjc.hl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.hl.main.entity.EmiCalculator;

@Repository
public interface EmiCalculatorRepository extends JpaRepository<EmiCalculator, Integer> 
{

}
