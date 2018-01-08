package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Playstation;
import lombok.Data;

/**
 * A class for processing data of Account and Playstation.
 */
@Data
public class ShouldSearchForPlaystationDataSet {

    private final Account account;
    private final Playstation playstation;
}
