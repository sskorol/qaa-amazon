package io.github.sskorol.model;

import lombok.Getter;

/**
 * A simple base class for processing common methods for all children classes.
 */

@Getter
public abstract class Product {

    private final String name;
    private final String price;
    private final String generalCategory;

    public Product(final String name, final String price, final String generalCategory) {
        this.name = name;
        this.price = price;
        this.generalCategory = generalCategory;
    }
}
