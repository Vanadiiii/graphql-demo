package me.imatveev.graphqldemo.api;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.ProductService;
import me.imatveev.graphqldemo.domain.entity.Item;
import me.imatveev.graphqldemo.domain.entity.Product;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductResolver implements GraphQLResolver<Item> {
    private final ProductService productService;

    public Product product(Item item) {
        return productService.findById(item.getProductId());
    }
}
