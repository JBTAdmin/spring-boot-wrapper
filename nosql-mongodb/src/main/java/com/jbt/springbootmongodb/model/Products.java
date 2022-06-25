package com.jbt.springbootmongodb.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record Products(String code, String name, String details, BigDecimal price) implements Serializable {
}
