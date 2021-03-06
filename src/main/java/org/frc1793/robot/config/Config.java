package org.frc1793.robot.config;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 2/22/17
 */
@SuppressWarnings("unused")
public class Config {

    public static ConfigOption<Boolean> config(IConfigTable table, String key, Boolean defaultVal) {
        return new ConfigOption<>(key, defaultVal, table::containsKey, table::putBoolean, table::getBoolean);
    }

    public static ConfigOption<Double> config(IConfigTable table,String key, Double defaultVal) {
        return new ConfigOption<>(key, defaultVal, table::containsKey, table::putDouble, table::getDouble);
    }

    public static ConfigOption<String> config(IConfigTable table,String key, String defaultVal) {
        return new ConfigOption<>(key, defaultVal, table::containsKey, table::putString, table::getString);
    }

}

