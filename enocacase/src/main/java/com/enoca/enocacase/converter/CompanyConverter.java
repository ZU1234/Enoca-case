package com.enoca.enocacase.converter;

import com.enoca.enocacase.model.Company;
import com.enoca.enocacase.request.CompanyRequest;
import com.enoca.enocacase.response.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {

    public CompanyResponse converter(Company company) {
        CompanyResponse response = new CompanyResponse();
        response.setName(company.getName());
        response.setProvince(company.getProvince());
        return response;
    }

    public Company converter(CompanyRequest companyRequest) {
        Company response = new Company();
        response.setName(companyRequest.getName());
        response.setProvince(companyRequest.getProvince());
        return response;
    }
}
