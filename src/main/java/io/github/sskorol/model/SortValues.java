package io.github.sskorol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for available sort values.
 */
@Getter
@RequiredArgsConstructor
public enum SortValues {

    RELEVANCE("Relevance"),
    PRICE_LOW_TO_HIGH("Price: Low to High"),
    PRICE_HIGH_TO_LOW("Price: High to Low"),
    DISCOUNT_LOW_TO_HIGH("Discount: Low to High"),
    DISCOUNT_HIGH_TO_LOW("Discount: High to Low"),
    NEWEST_ARRIVALS("Newest Arrivals"),
    AVG_CUSTOMER_REVIEW("Avg. Customer Review");

    private final String name;
}
