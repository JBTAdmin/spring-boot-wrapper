package com.jbt.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record Contact(String address, String phone) implements Serializable {
}
