package org.frc1793.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1793.robot.config.Config;
import org.frc1793.robot.config.ConfigOption;
import org.frc1793.robot.config.SmartDashboardWrapper;
import org.strongback.command.Command;
import org.strongback.components.CurrentSensor;
import org.strongback.components.VoltageSensor;
import org.strongback.hardware.Hardware;

import java.util.List;

/**
 * Created by tyler on 4/12/17.
 */
public class Dashboard {

    private VoltageSensor voltageSensor;
    private CurrentSensor currentSensor;

    private ConfigOption<String> autonomous;
    private SmartDashboardWrapper smartDashboard = new SmartDashboardWrapper();


    public Dashboard() {
        voltageSensor = Hardware.powerPanel().getVoltageSensor();
        currentSensor = Hardware.powerPanel().getTotalCurrentSensor();
        autonomous = Config.config(smartDashboard,"autonomousOption","Left");
    }

    public void update(Robot.State state) {
        smartDashboard.putDouble("voltage", voltageSensor.getVoltage());
        smartDashboard.putDouble("current", currentSensor.getCurrent());
        smartDashboard.putDouble("robotTime", DriverStation.getInstance().getMatchTime());
        smartDashboard.putString("robotPhase", state.getValue());
        autonomous.update();
    }
}
