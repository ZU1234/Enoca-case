package com.enoca.enocacase.controller;


import com.enoca.enocacase.model.Employee;
import com.enoca.enocacase.request.EmployeeRequest;
import com.enoca.enocacase.request.EmployeeUpdateRequest;
import com.enoca.enocacase.response.EmployeeResponse;
import com.enoca.enocacase.response.ProgressResponse;
import com.enoca.enocacase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.save(employeeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgressResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.delete(id));
    }

    @PostMapping("/update")
    public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        return ResponseEntity.ok(employeeService.update(employeeUpdateRequest));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getList() {
        return ResponseEntity.ok(employeeService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }
}
