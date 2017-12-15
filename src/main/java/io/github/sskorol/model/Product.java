package io.github.sskorol.model;

import lombok.Getter;

/**
 * A simple base class for processing common methods for all children classes.
 */
@Getter
public abstract class Product {

    private final String name;
    private final String generalCategory;
    private final String purchaseStatus;

    public Product(final String name, final String generalCategory, final String purchaseStatus) {
        this.name = name;
        this.generalCategory = generalCategory;
        this.purchaseStatus = purchaseStatus;
    }
}
