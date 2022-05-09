package me.imatveev.graphqldemo.service;

import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.CartService;
import me.imatveev.graphqldemo.domain.entity.Cart;
import me.imatveev.graphqldemo.storage.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart findById(String id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ooops..."));
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
