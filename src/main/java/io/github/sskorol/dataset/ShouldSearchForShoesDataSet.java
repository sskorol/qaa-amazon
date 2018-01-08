package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Shoes;
import lombok.Data;

/**
 * A class for processing data of Account and Shoes.
 */
@Data
public class ShouldSearchForShoesDataSet {

    private final Account account;
    private final Shoes shoes;
}
