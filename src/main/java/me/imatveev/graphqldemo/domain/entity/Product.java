package me.imatveev.graphqldemo.domain.entity;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder(toBuilder = true)
public class Product {
    String id;
    String title;
    BigDecimal price;
    String description;
    String sku;
    List<String> images;
}
