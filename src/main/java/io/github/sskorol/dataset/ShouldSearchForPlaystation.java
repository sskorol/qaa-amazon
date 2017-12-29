package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Playstation;
import lombok.Data;

/**
 * A class for processing dates of Account and Playstation.
 */
@Data
public class ShouldSearchForPlaystation {

    private final Account account;
    private final Playstation playstation;
}
