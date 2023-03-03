package com.enoca.enocacase.service;

import com.enoca.enocacase.converter.CompanyConverter;
import com.enoca.enocacase.exception.CompanyDoesNotException;
import com.enoca.enocacase.model.Company;
import com.enoca.enocacase.repository.CompanyRepository;
import com.enoca.enocacase.request.CompanyRequest;
import com.enoca.enocacase.response.CompanyResponse;
import com.enoca.enocacase.response.ProgressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyConverter companyConverter;

    public CompanyResponse save(CompanyRequest companyRequest) {
        Company company = companyRepository.save(companyConverter.converter(companyRequest));
        return companyConverter.converter(company);
    }

    public ProgressResponse delete(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyDoesNotException("The " +
                "company belonging to the identity could not be found."));
        companyRepository.delete(company);
        return new ProgressResponse(" companies belonging to the " + id + " identity have been deleted.", HttpStatus.OK);
    }

    public CompanyResponse update(CompanyRequest companyRequest, Long id) {
        Company selectCompany = companyfindById(id);

        selectCompany.setName(companyRequest.getName());
        selectCompany.setProvince(companyRequest.getProvince());

        companyRepository.save(selectCompany);


        //save hem kayıt hemde güncelleme işlemlerinde kullanılabilir.
        return companyConverter.converter(selectCompany);

    }

    public List<Company> getList() {
        return companyRepository.findAll();
    }

    public CompanyResponse getById(Long id) {
        return companyConverter.converter(companyfindById(id));
    }

    protected Company companyfindById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyDoesNotException("The " +
                "company belonging to the " + id + " identity could not be found."));
    }

}
