package org.frc1793.robot.api;

/**
 * Created by tyler on 4/11/17.
 */
public interface IPeriodic extends IModule{
    default void robotPeriodic() {
    }
    default void autonomousPeriodic() {

    }
    default void teleopPeriodic() {
    }
    default void disabledPeriodic() {
    }

    @Override
    default Type getType(){
        return Type.PERIODIC;
    }
}
