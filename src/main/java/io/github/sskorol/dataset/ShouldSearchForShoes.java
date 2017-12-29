package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Shoes;
import lombok.Data;

/**
 * A class for processing dates of Account and Shoes.
 */
@Data
public class ShouldSearchForShoes {

    private final Account account;
    private final Shoes shoes;
}
