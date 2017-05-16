package org.frc1793.robot.config;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 3/27/17
 */

@SuppressWarnings("unused")
public class ConfigOption<T>  implements Supplier<T> {
    private final String key;
    private final T defaultVal;

    private final BiFunction<String, T, T> getDashboard;
    private final BiConsumer<String, T> setDashboard;
    private final Predicate<String> contains;
    public ConfigOption(String key, T defaultVal, Predicate<String> contains, BiConsumer<String, T> setDashboard, BiFunction<String, T, T> getDashboard) {
        this.key = key;
        this.defaultVal = defaultVal;
        this.getDashboard = getDashboard;
        this.setDashboard = setDashboard;
        this.contains = contains;
        this.update();
    }

    @Override
    public T get() {
        return this.getDashboard.apply(key, defaultVal);
    }

    public void put(T u) {
        this.setDashboard.accept(key, u);
    }

    public void update() {
        if (!this.contains.test(key))
            setDashboard.accept(key, this.defaultVal);
    }
}