package org.frc1793.robot.modules.config;

import edu.wpi.first.wpilibj.Preferences;
import org.frc1793.robot.api.IInit;
import org.frc1793.robot.api.IPeriodic;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 2/22/17
 */
@SuppressWarnings("unused")
public class Config implements IInit, IPeriodic{
    public static final Config INSTANCE = new Config();
    public ConfigOption<String> autonomous;

    public final Preferences p = Preferences.getInstance();

    public ConfigOption<Boolean> config(String key, Boolean defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putBoolean, p::getBoolean);
    }

    public ConfigOption<Double> config(String key, Double defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putDouble, p::getDouble);
    }

    public ConfigOption<String> config(String key, String defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putString, p::getString);
    }

    @Override
    public Type getType() {
        return Type.BOTH;
    }
}

