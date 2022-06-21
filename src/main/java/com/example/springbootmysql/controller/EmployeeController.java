package com.example.springbootmysql.controller;

import com.example.springbootmysql.entity.Employee;
import com.example.springbootmysql.model.EmployeeModel;
import com.example.springbootmysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.readResources();
    }


    @PostMapping
    public String createEmployee( @RequestBody EmployeeModel employeeModel)
    {
        return employeeService.createResources(employeeModel);
    }
    
    @GetMapping("/email/{email}")
    public List<Employee> getEmployeeByEmail(@PathVariable String email)
    {
        return employeeService.getEmployee(email);
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeModel employeeModel)
    {
        return employeeService.updateResources(employeeModel);
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestBody EmployeeModel employeeModel)
    {
        return employeeService.deleteResource(employeeModel);
    }
}
