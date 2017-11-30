package io.github.sskorol.core;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

/**
 * Key interface for PageObjects, which defines common actions.
 */
public interface Page {

    default Page navigateTo() {
        return navigateTo(url());
    }

    Page navigateTo(String url);

    default String url() {
        return BASE_CONFIG.url();
    }
}
