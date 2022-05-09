package me.imatveev.graphqldemo.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GenericGenerator(
            name = "nano_id",
            strategy = "me.imatveev.graphqldemo.configuration.NanoIdGenerator")
    @GeneratedValue(generator = "nano_id")
    private String id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();

    public BigDecimal getSubTotal() {
        return items.stream()
                .map(Item::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
