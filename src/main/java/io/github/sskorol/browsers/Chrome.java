package io.github.sskorol.browsers;

import io.github.sskorol.config.XmlConfig;
import io.github.sskorol.core.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.String.format;

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

    @Override
    public String url() {
        return format("http://%s:4444/wd/hub", System.getenv("SELENOID_1_PORT_4444_TCP_ADDR"));
    }
}
