package io.github.sskorol.model;

import lombok.Getter;

/**
 * A simple base class for processing common methods for all children classes.
 */
@Getter
public abstract class Product {

    private final String name;
    private final String category;

    public Product(final String name, final String category) {
        this.name = name;
        this.category = category;
    }
}
