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

    public Parfume(final String name, final String category) {
        super(name, category);
    }
}
