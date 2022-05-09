package me.imatveev.graphqldemo.domain;

import me.imatveev.graphqldemo.domain.entity.Product;

public interface ProductService {
    Product findById(String id);
}
