package me.imatveev.graphqldemo.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.CartService;
import me.imatveev.graphqldemo.domain.entity.Cart;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartResolver implements GraphQLQueryResolver {
    private final CartService cartService;

    public Cart cart(String id) {
        return cartService.findById(id);
    }

    public List<Cart> carts() {
        return cartService.findAll();
    }
}
