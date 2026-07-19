package com.cognizant.spring_data_jpa_handson.Repositary;

import com.cognizant.spring_data_jpa_handson.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
