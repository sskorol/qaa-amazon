package io.github.sskorol.model;

import io.github.sskorol.customannotation.Source;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for Lego processing.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Source(source = "lego.json")
public class Lego extends Product {

    private String ageRange;

    public Lego(final String name, final String category) {
        super(name, category);
    }
}
