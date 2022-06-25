package com.jbt.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "companies")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record Company(@Id Long id, String name, List<Products> products, Contact contact) implements Serializable {
}
