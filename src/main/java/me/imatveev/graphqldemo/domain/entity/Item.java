package me.imatveev.graphqldemo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String productId;
    @Column(nullable = false)
    private BigDecimal total;
}
