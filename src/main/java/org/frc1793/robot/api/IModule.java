package org.frc1793.robot.api;

/**
 * Created by tyler on 4/11/17.
 */
public interface IModule {
    Type getType();
    enum Type {
        PERIODIC,
        INIT,
        BOTH
    }
}
