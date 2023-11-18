package org.gb.task.configuration;

import org.apache.commons.configuration2.*;

public class MainConfig extends AbstractConfig {

    private static final Configuration config = readConfigFile("config.properties");

    public static String getBaseUrl() {
        return config.getString("base.url");
    }

    public static String getSelenoidHubUrl() {
        return config.getString("selenoid.hub.url");
    }
}
