package com.application.five.repository;

import com.application.five.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {

    Optional<Employees> findByEmail(String email);

}
