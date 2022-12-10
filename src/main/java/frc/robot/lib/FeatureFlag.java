package frc.robot.lib;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class FeatureFlag {
    public static enum Flag {
        CIM,
        Falcon,
        Tank,
        Mecanum,
        MotorDouble,
    }

    private static HashMap<Flag, Boolean> values = new HashMap<Flag, Boolean>();

    static {
        DigitalInput digitalInput;
        
        digitalInput = new DigitalInput(0);
        values.put(Flag.CIM, digitalInput.get());
        digitalInput.close();

        digitalInput = new DigitalInput(1);
        values.put(Flag.Falcon, digitalInput.get());
        digitalInput.close();

        digitalInput = new DigitalInput(4);
        values.put(Flag.Tank, digitalInput.get());
        digitalInput.close();

        digitalInput = new DigitalInput(5);
        values.put(Flag.Mecanum, digitalInput.get());
        digitalInput.close();

        digitalInput = new DigitalInput(6);
        values.put(Flag.MotorDouble, digitalInput.get());
        digitalInput.close();
    }

    public static boolean isEnabled(Flag flag){
        return values.get(flag);
    }
}
