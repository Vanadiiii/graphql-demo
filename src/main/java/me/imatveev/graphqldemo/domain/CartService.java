package me.imatveev.graphqldemo.domain;

import me.imatveev.graphqldemo.domain.entity.Cart;

import java.util.List;

public interface CartService {
    Cart findById(String id);

    List<Cart> findAll();
}
