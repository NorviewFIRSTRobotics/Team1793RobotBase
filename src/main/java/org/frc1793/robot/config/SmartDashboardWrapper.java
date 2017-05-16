package org.frc1793.robot.config;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Optional;

/**
 * Created by tyler on 4/12/17.
 */
public class SmartDashboardWrapper implements IConfigTable {
    @Override
    public boolean containsKey(String key) {
        return SmartDashboard.containsKey(key);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        SmartDashboard.putBoolean(key,value);
    }

    @Override
    public void putString(String key, String value) {
        SmartDashboard.putString(key,value);
    }

    @Override
    public void putDouble(String key, Double value) {
        SmartDashboard.putNumber(key,value);
    }

    @Override
    public void putInteger(String key, Integer value) {
        SmartDashboard.putNumber(key,value);
    }

    @Override
    public void putData(String key, Sendable data) {
        SmartDashboard.putData(key, data);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultVal) {
        return SmartDashboard.getBoolean(key,defaultVal);
    }

    @Override
    public String getString(String key, String defaultVal) {
        return SmartDashboard.getString(key,defaultVal);
    }

    @Override
    public Double getDouble(String key, Double defaultVal) {
        return SmartDashboard.getNumber(key,defaultVal);
    }

    @Override
    public Integer getInteger(String key, Integer defaultVal) {
        return (int)SmartDashboard.getNumber(key,defaultVal);
    }

    @Override
    public Sendable getData(String key) {
        try {
            return SmartDashboard.getData(key);
        } catch( IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}