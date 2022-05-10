package me.imatveev.graphqldemo.api;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.CartService;
import me.imatveev.graphqldemo.domain.entity.Cart;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartGraph {
    private final CartService cartService;

    @GraphQLQuery(name = "cart")
    public Cart cart(@GraphQLArgument(name = "id") String id) {
        return cartService.findById(id);
    }

    @GraphQLQuery(name = "carts")
    public List<Cart> carts() {
        return cartService.findAll();
    }
}
