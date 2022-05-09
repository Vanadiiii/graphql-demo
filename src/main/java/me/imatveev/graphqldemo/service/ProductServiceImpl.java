package me.imatveev.graphqldemo.service;

import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.client.ProductMockClient;
import me.imatveev.graphqldemo.domain.ProductService;
import me.imatveev.graphqldemo.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMockClient client;

    @Override
    public Product findById(String id) {
        return client.findById(id);
    }
}
