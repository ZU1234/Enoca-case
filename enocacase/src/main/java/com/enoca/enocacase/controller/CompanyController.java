package com.enoca.enocacase.controller;

import com.enoca.enocacase.model.Company;
import com.enoca.enocacase.request.CompanyRequest;
import com.enoca.enocacase.response.CompanyResponse;
import com.enoca.enocacase.response.ProgressResponse;
import com.enoca.enocacase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping
    public ResponseEntity<CompanyResponse> save(@RequestBody CompanyRequest companyRequest){
        return ResponseEntity.ok(companyService.save(companyRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProgressResponse> delete(@PathVariable Long id){
        return ResponseEntity.ok(companyService.delete(id));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<CompanyResponse> update(@RequestBody CompanyRequest companyRequest,@PathVariable Long id){
        return ResponseEntity.ok(companyService.update(companyRequest,id));
    }
    @GetMapping
    public ResponseEntity<List<Company>>getList(){
        return ResponseEntity.ok(companyService.getList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse>getById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));
    }
}
