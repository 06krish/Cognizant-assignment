package com.cognizant.spring_data_jpa_handson.EmployeeController;

import com.cognizant.spring_data_jpa_handson.Entity.Employee;
import com.cognizant.spring_data_jpa_handson.Service.Employeeservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
// it handles the http request.
@RequestMapping("/employee")
// instead of writing getmapping("/employee"),postmapping("/employee") again and again we write requestmapping("/employee")
public class EmployeeController {
    // injecting constructor dependency
    private final Employeeservice employeeservice;

    EmployeeController(Employeeservice employeeservice) {
        this.employeeservice = employeeservice;
    }

    @GetMapping
    public List<Employee> getallemployees() {
        return employeeservice.getallEmployees();
    }

    // here we have used path variable
    @GetMapping("/{id}")
    //public Optional<Employee> getemployee(@PathVariable Integer id){return employeeservice.getelementByID(id);}
    // responseEntity
    public ResponseEntity<Employee> getconfirmation(@PathVariable Integer id) {
        Optional<Employee> emp = employeeservice.getelementByID(id);
        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        }
        return ResponseEntity.notFound().build();
    }
//    Why do we return List<Employee> instead of ArrayList<Employee>?
//    Because we program to the interface, not the implementation.
    // data from the relational database will be converted into the form of json body and will be
    // shown at the browser.( Done by Jackson)


// @pathvariable -> http://localhost:8081/employees/10 ->10 is path variable (value that is part of url part)
// data is the part of url path
// used when we want data from the specific resource. "/employee/{id}", "/employee/{name}/age/{age}"
// @paramrequest  -> data come after ? . ("/employee?id")
// used for sorting,pagination,filtering.

// **********************
// @Postmapping used to post the data under to the database
// @Requestbody
//{
//        "name":"Virat",
//        "department":"IT",
//        "age":35
//        }
// without request body spring receives nothin
// with @requestbody annotation spring get to know this data have to changed from json format to object format

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeservice.saveEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee( @PathVariable Integer id,
                                    @RequestBody Employee employee){
        return employeeservice.updateEmployee(id,employee);
    }
    // A delete API deletes the object
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Integer id){
        return  employeeservice.deleteEmployee(id);
    }
    // @patchMapping is used for change the specific data.
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> specificupdate(
            @PathVariable Integer id,
            @RequestBody Map<String,Object>mp)
    {
        Employee emp = employeeservice.patchEmploye(id,mp);
        if(emp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }
}
