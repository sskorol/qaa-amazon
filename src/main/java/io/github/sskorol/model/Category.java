package io.github.sskorol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for available categories.
 */
@Getter
@RequiredArgsConstructor
public enum Category {

    BRAND("Brand"),
    AMAZON_FASHION(""),
    AMAZON_PRIME(""),
    SELLER("Seller"),
    SHOE_SIZE("Shoe Size"),
    SHOE_WIDTH("Shoe Width"),
    COLOR("Color"),
    WOMEN_FRAGRANCE_SIZE("Women's Fragrance Size"),
    MOVIE_TV("Movie & TV Show Release Decade"),
    TOYS_AGE_RANGE("Toys Age Range");

    private final String name;
}
