package me.arthurlins.restaurant.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Arthur on 26/11/2018.
 */
public class Config {

    private static Config ourInstance = new Config();
    private Properties config;


    private Config() {
        try {
            load();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static Config getInstance() {
        return ourInstance;
    }

    private void save() throws IOException {
        File configFile = new File("config.properties");
        config.store(new FileWriter(configFile), "");
    }

    private void load() throws IOException {
        if (config == null) {
            config = new Properties();
            File configFile = new File("config.properties");
            if (!configFile.exists()) {
                if (configFile.createNewFile()) {
                    this.createDefaultConfig();
                    return;
                }
            }
            config.load(new FileInputStream(configFile));
        }
    }

    private void createDefaultConfig() {
        config.setProperty("margin", "2");
        config.setProperty("skip_count", "1");

        try {
            save();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }


    public String getProperty(String key, String defaultValue) {
        return config.getProperty(key, defaultValue);
    }

}
