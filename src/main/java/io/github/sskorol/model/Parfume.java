package io.github.sskorol.model;

import io.github.sskorol.customannotation.Source;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Parfume object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Source(source = "parfume.json")
public class Parfume extends Product {

    private String amount;
    private String scent;

    public Parfume(final String name, final String generalCategory, final String subCategory) {
        super(name, generalCategory, subCategory);
    }
}
