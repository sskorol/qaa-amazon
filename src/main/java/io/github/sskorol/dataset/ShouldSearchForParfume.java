package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Parfume;
import lombok.Data;

/**
 * A class for processing dates of Account and Parfume.
 */
@Data
public class ShouldSearchForParfume {

    private final Account account;
    private final Parfume parfume;
}
