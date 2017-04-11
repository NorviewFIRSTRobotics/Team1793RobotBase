package org.frc1793.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.frc1793.robot.api.IInit;
import org.frc1793.robot.api.IModule;
import org.frc1793.robot.api.IPeriodic;
import org.frc1793.robot.modules.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tyler on 4/11/17.
 */
public class Robot extends IterativeRobot {
    public List<IInit> initModules = new ArrayList<>(Arrays.asList(Config.INSTANCE));
    public List<IPeriodic> periodicModules = new ArrayList<>();

    public Robot() {
        super();
        registerModule(Config.INSTANCE);
    }

    public void registerModule(IModule module) {
        IModule.Type t = module.getType();
        if (t == IModule.Type.INIT || t == IModule.Type.BOTH) {
            initModules.add((IInit) module);
        }
        if (t == IModule.Type.PERIODIC || t == IModule.Type.BOTH) {
            periodicModules.add((IPeriodic) module);
        }
    }

    @Override
    public void robotInit() {
        initModules.forEach(IInit::robotInit);
    }

    @Override
    public void robotPeriodic() {
        periodicModules.forEach(IPeriodic::robotPeriodic);
    }

    @Override
    public void autonomousInit() {
        initModules.forEach(IInit::autonomousInit);
    }

    @Override
    public void autonomousPeriodic() {
        periodicModules.forEach(IPeriodic::autonomousPeriodic);
    }

    @Override
    public void teleopInit() {
        initModules.forEach(IInit::teleopInit);
    }

    @Override
    public void teleopPeriodic() {
        periodicModules.forEach(IPeriodic::teleopPeriodic);
    }

    @Override
    public void disabledInit() {
        initModules.forEach(IInit::disabledInit);
    }

    @Override
    public void disabledPeriodic() {
        periodicModules.forEach(IPeriodic::disabledPeriodic);
    }

}
