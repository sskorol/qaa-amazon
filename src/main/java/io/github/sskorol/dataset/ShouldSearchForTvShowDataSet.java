package io.github.sskorol.dataset;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.TvShow;
import lombok.Data;

/**
 * A class for processing data of Account and TvShow.
 */
@Data
public class ShouldSearchForTvShowDataSet {

    private final Account account;
    private final TvShow tvShow;
}
