package io.github.sskorol.model;

import io.github.sskorol.customannotation.Source;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Playstation object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Source(source = "playstation.json")
public class Playstation extends Product {

    public Playstation(final String name, final String category) {
        super(name, category);
    }
}
