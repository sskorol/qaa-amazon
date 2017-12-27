package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Playstation object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Playstation extends Product {

    private String priceLowToHigh;

    public Playstation(final String name, final String generalCategory, final String subCategory) {
        super(name, generalCategory, subCategory);
    }
}
