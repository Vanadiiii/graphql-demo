package me.imatveev.graphqldemo.storage;

import me.imatveev.graphqldemo.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
