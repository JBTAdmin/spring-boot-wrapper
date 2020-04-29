package com.jbt.springbootmongodb.service;

import com.jbt.springbootmongodb.model.Company;
import com.jbt.springbootmongodb.model.Contact;
import com.jbt.springbootmongodb.model.Products;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

  Company createCompany(Company company);

  Optional<Company> getCompany(String id);

  Company editCompany(Company company);

  Company addProductDetails(Company company, List<Products> product);

  Company editCompanyContact(Company company, Contact contact);

  void deleteByName(String name);

  void deleteById(Long id);

  List<Company> getAllCompany();

  List<Company> findByCompanyName(String companyName);

  Optional<Company> findById(Long id);

  Company editProductDetails(Company company, Products products);
}
