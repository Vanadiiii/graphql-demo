package me.imatveev.graphqldemo.api;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.CartService;
import me.imatveev.graphqldemo.domain.ProductService;
import me.imatveev.graphqldemo.domain.entity.Cart;
import me.imatveev.graphqldemo.domain.entity.Item;
import me.imatveev.graphqldemo.domain.entity.Product;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductGraph {
    private final ProductService productService;

    @GraphQLQuery(name = "product")
    public Product product(@GraphQLContext Item item) {
        return productService.findById(item.getProductId());
    }

    @GraphQLQuery(name = "images")
    public List<String> images(@GraphQLContext Product product,
                               @GraphQLArgument(name = "limit", defaultValue = "0") int limit) {
        List<String> images = product.getImages();
        int normalizedLimit = limit > 0 ? limit : images.size();
        return images.subList(0, Math.min(normalizedLimit, images.size()));
    }
}
