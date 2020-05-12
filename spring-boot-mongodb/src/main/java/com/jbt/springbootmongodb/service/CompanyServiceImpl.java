package com.jbt.springbootmongodb.service;

import com.jbt.springbootmongodb.model.Company;
import com.jbt.springbootmongodb.model.Contact;
import com.jbt.springbootmongodb.model.Products;
import com.jbt.springbootmongodb.repository.CompanyRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final MongoTemplate mongoTemplate;

    public CompanyServiceImpl(CompanyRepository companyRepository, MongoTemplate mongoTemplate) {
        this.companyRepository = companyRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> getCompany(String id) {
        return companyRepository.findById(id);
    }

    //It will use $set operator
    @Override
    public Company editCompany(Company company) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(company.id()));
        Update update = new Update();
        update.set("name", company.name());
        update.set("products", company.products());
        update.set("contact", company.contact());
        return mongoTemplate.findAndModify(query, update, Company.class);
    }

    //It will use $addToSet operator
    @Override
    public Company addProductDetails(Company company, List<Products> products) {
        products.forEach(product -> {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(company.id()));
            Update update = new Update();
            update.set("name", company.name());
            update.addToSet("products", product);
            mongoTemplate.findAndModify(query, update, Company.class);
        });
        return findById(company.id()).orElseGet(null);
    }

    @Override
    public Company editCompanyContact(Company company, Contact contact) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(company.id()));
        Update update = new Update();
        update.set("name", company.name());
        update.set("products", company.products());
        update.set("contact", contact);
        mongoTemplate.findAndModify(query, update, Company.class);
        return findById(company.id()).orElseGet(null);
    }


    @Override
    public void deleteByName(String name) {
        companyRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findByCompanyName(String companyName) {
        return companyRepository.findByName(companyName);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company editProductDetails(Company company, Products product) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(company.id()));
        query.addCriteria(Criteria.where("products.code").is(product.code()));
        Update update = new Update();
        update.set("products.$.code", product.code());
        update.set("products.$.name", product.name());
        update.set("products.$.details", product.details());
        update.set("products.$.price", product.price());
        mongoTemplate.findAndModify(query, update, Company.class);
        return findById(company.id()).orElseGet(null);
    }
}
