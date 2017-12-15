package io.github.sskorol.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple model class for processing Tv Show object.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TvShow extends Product {

    private String subCategory;
    private String year;
    private String avgCustomerReview;

    public TvShow(final String name, final String generalCategory, final String purchaseStatus) {
        super(name, generalCategory, purchaseStatus);
    }
}
