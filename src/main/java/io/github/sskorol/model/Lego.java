package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for Lego processing.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Lego extends Product {

    private String ageRange;

    public Lego(final String name, final String generalCategory, final String subCategory) {
        super(name, generalCategory, subCategory);
    }
}
