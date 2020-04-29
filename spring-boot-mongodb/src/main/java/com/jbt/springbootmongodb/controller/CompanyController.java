package com.jbt.springbootmongodb.controller;

import com.jbt.springbootmongodb.model.Company;
import com.jbt.springbootmongodb.model.Contact;
import com.jbt.springbootmongodb.model.Products;
import com.jbt.springbootmongodb.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyService.getAllCompany();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable String id) {
        return new ResponseEntity(companyService.getCompany(id), HttpStatus.OK);
    }

    @GetMapping("/companyName/{companyName}")
    public ResponseEntity<List<Company>> getByCompanyName(@PathVariable String companyName) {
        List<Company> companies = companyService.findByCompanyName(companyName.replaceAll("%20", " ").trim());
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company company1 = companyService.createCompany(company);
        return new ResponseEntity<>(company1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Company> editCompany(@RequestBody Company company) {
        Company company1 = companyService.editCompany(company);
        return new ResponseEntity<>(company1, HttpStatus.OK);
    }

    @PutMapping("/add/products/{companyId}")
    public ResponseEntity<Company> addCompanyProducts(@PathVariable Long companyId, @RequestBody List<Products> products) {
        Company company = companyService.addProductDetails(companyService.findById(companyId).get(), products);
        return new ResponseEntity<>( company, HttpStatus.OK);
    }

    @PutMapping("/edit/products/{companyId}")
    public ResponseEntity<Company> editCompanyProduct(@PathVariable Long companyId, @RequestBody Products product) {
        Company company = companyService.editProductDetails(companyService.findById(companyId).get(), product);
        return new ResponseEntity<>( company, HttpStatus.OK);
    }


    @PutMapping("/contact/{companyId}")
    public ResponseEntity<Company> addCompanyContact(@PathVariable Long companyId, @RequestBody Contact contact) {
        Company company = companyService.editCompanyContact(companyService.findById(companyId).get(), contact);
        return new ResponseEntity<>(company,  HttpStatus.OK);
    }

    @DeleteMapping("/companyName/{name}")
    public ResponseEntity deleteCompanyByName(@PathVariable String name) {
        companyService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Long id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
