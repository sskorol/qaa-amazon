package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Playstation extends Product {

    private String subCategory;
    private String priceLowToHigh;

    public Playstation(final String name, final String generalCategory, final String purchaseStatus) {
        super(name, generalCategory, purchaseStatus);
    }
}
