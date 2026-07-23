package com.cognizant.spring_data_jpa_handson.Service;

import com.cognizant.spring_data_jpa_handson.Entity.Employee;
import com.cognizant.spring_data_jpa_handson.Repositary.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class Employeeservice {
    @Autowired
    public EmployeeRepository employeerepository;

    // this accept Employee object and save it to database
    public Employee saveEmployee(Employee employee) {
        return employeerepository.save(employee);
    }

    public List<Employee> getallEmployees() {
        return employeerepository.findAll();
    }

    // optinal is container that may or may not contain a value
    public Optional<Employee> getelementByID(Integer id) {
        return employeerepository.findById(id);
    }

    // deleting method use void
    public void deletebyID(Integer id) {
        employeerepository.deleteById(id);
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Optional<Employee> emp = employeerepository.findById(id);
        if (emp.isPresent()) {
            Employee existingEmp = emp.get();
            existingEmp.setName(updatedEmployee.getName());
            existingEmp.setSalary(updatedEmployee.getSalary());
            existingEmp.setDepartment(updatedEmployee.getDepartment());
            return employeerepository.save(existingEmp);
        }
        return null;
    }

    public Boolean deleteEmployee(Integer id) {
        if (employeerepository.existsById(id)) {
            employeerepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Employee patchEmploye(Integer id, Map<String, Object> updates) {
        Optional<Employee> emp = employeerepository.findById(id);
        if (emp.isPresent()) {
            Employee existingEmp = emp.get();
            if (updates.containsKey("name")) {
                existingEmp.setName((String) updates.get("name"));
            }
            if (updates.containsKey("department")) {
                existingEmp.setDepartment((String) updates.get("department"));
            }
            if (updates.containsKey("salary")) {
                existingEmp.setSalary((Double) updates.get("salary"));
            }
            return employeerepository.save(existingEmp);
        }
        return null;
    }
    // Q: Why does save() return an entity instead of void?
    //
    // Answer: Because after saving, JPA returns the managed entity,
    // which may contain changes made during persistence—for example,
    // an auto-generated primary key (id) or other values set by the database.
}
