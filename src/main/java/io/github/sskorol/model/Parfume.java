package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Parfume object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Parfume extends Product {

    private String sortValue;
    private String size;
    private String scent;

    public Parfume(final String name, final String generalCategory, final String subCategory) {
        super(name, generalCategory, subCategory);
    }
}
