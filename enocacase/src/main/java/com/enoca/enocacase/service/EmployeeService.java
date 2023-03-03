package com.enoca.enocacase.service;

import com.enoca.enocacase.converter.EmployeeConverter;
import com.enoca.enocacase.exception.CompanyDoesNotException;
import com.enoca.enocacase.exception.EmployeeDoesNotException;
import com.enoca.enocacase.model.Company;
import com.enoca.enocacase.model.Employee;
import com.enoca.enocacase.repository.CompanyRepository;
import com.enoca.enocacase.repository.EmployeeRepository;
import com.enoca.enocacase.request.EmployeeRequest;
import com.enoca.enocacase.request.EmployeeUpdateRequest;
import com.enoca.enocacase.response.EmployeeResponse;
import com.enoca.enocacase.response.ProgressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeConverter employeeConverter;

    public EmployeeResponse save(EmployeeRequest employeeRequest) {

       Company company= companyfindById(employeeRequest.getCompanyId());

       Employee employee= new Employee();
       employee.setName(employeeRequest.getName());
       employee.setCompany(company);
        return employeeConverter.convert(employeeRepository.save(employee));
    }

    public ProgressResponse delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
        return new ProgressResponse("The employee belonging to the "+id+" identity have been deleted.",
                HttpStatus.OK);
    }
    public EmployeeResponse getById(Long id){
        Employee employee =findById(id);
        return employeeConverter.convert(employee);
    }
    public EmployeeResponse update(EmployeeUpdateRequest request) {

        Employee selectEmployee= findById(request.getId());
        Company selectCompany=companyfindById(request.getCompanyId());

        selectEmployee.setName(request.getName());
        selectEmployee.setCompany(selectCompany);

        employeeRepository.save(selectEmployee);

        //save hem kayıt hemde güncelleme işlemlerinde kullanılabilir.
        return employeeConverter.convert(selectEmployee);

    }
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    protected Employee findById(Long id){
        return  employeeRepository.findById(id).orElseThrow(() -> new EmployeeDoesNotException("The " +
                "employee belonging to the "+id+" identity could not be found."));
    }
    protected Company companyfindById(Long id){
        return  companyRepository.findById(id).orElseThrow(() -> new CompanyDoesNotException("The " +
                "company belonging to the "+id+" identity could not be found."));
    }


}
