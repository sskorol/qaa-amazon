package io.github.sskorol.browsers;

import io.github.sskorol.config.XmlConfig;
import io.github.sskorol.core.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Chrome browser configuration.
 */
public class Chrome implements Browser {

    public Name name() {
        return Name.Chrome;
    }

    @Override
    public boolean isRemote() {
        return true;
    }

    @Override
    public Capabilities configuration(final XmlConfig config) {
        final ChromeOptions options = new ChromeOptions();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        options.setCapability("name", config.getTestName());
        options.setCapability("screenResolution", "1280x1024x24");
        return merge(config, options);
    }
}
