package com.jbt.springbootmongodb.model;

import java.io.Serializable;

public record Contact(String address, String phone) implements Serializable {
}
