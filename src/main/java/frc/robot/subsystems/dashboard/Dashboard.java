package frc.robot.subsystems.dashboard;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class Dashboard{

    ShuffleboardTab pidTab = Shuffleboard.getTab("motion magic tuning");

    public NetworkTableEntry kP = pidTab.add("P", 0.6).getEntry();
    public NetworkTableEntry kD = pidTab.add("D", 0.1).getEntry();    
    
    public void Dashboard(){}

    public double getkP(){
        return kP.getDouble(0.6);
    }
    
    public double getkD(){
        return kD.getDouble(0.1);
    }

}