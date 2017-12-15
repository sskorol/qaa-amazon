package io.github.sskorol.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * Key interface for loading default project properties.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config, Reloadable {

    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("url")
    @DefaultValue("http://localhost")
    String url();

    @Key("regexpGroup")
    @DefaultValue("1")
    int regexpGroup();
}
