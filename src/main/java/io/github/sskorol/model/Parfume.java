package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Parfume object.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class Parfume extends Product {

    private String subCategory;
    private String size;
    private String scent;

    public Parfume(final String name, final String category) {
        super(name, category);
    }
}
