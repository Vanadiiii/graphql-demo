package me.imatveev.graphqldemo.client;

import me.imatveev.graphqldemo.domain.entity.Product;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductMockClient {
    private static final EasyRandom RANDOM = new EasyRandom(
            new EasyRandomParameters()
                    .seed(LocalDate.now().getYear())
                    .collectionSizeRange(3, 6)
                    .stringLengthRange(10, 20)
    );

    public Product findById(String id) {
        return RANDOM.nextObject(Product.class).toBuilder()
                .id(id)
                .build();
    }
}
