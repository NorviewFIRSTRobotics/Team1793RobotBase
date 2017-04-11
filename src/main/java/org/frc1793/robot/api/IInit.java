package org.frc1793.robot.api;

/**
 * Created by tyler on 4/11/17.
 */
public interface IInit extends IModule {
    default void robotInit() {
    }
    default void autonomousInit() {
    }
    default void teleopInit() {
    }
    default void disabledInit() {
    }
    @Override
    default Type getType() {
        return Type.INIT;
    }
}
