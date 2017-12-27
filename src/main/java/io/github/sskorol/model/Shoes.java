package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Shoes object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Shoes extends Product {

    private String size;
    private String color;
    private String brand;

    public Shoes(final String name, final String generalCategory, final String subCategory) {
        super(name, generalCategory, subCategory);
    }
}
