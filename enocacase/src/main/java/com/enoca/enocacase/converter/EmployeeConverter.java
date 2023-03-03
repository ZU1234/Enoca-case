package com.enoca.enocacase.converter;

import com.enoca.enocacase.model.Employee;
import com.enoca.enocacase.response.EmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public EmployeeResponse convert(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setName(employee.getName());
        response.setCompany(employee.getCompany().getName());
        return response;
    }


}
