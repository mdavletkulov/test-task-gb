package org.gb.task.configuration;

import java.io.*;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.fluent.*;
import org.apache.commons.configuration2.ex.*;

public abstract class AbstractConfig {

    protected static Configuration readConfigFile(String fileName) {
        try {
            return new Configurations().properties(fileName);
        } catch (ConfigurationException e) {
            throw new RuntimeException("Something went wrong while reading config file %s"
                    .formatted(fileName));
        }
    }
}
