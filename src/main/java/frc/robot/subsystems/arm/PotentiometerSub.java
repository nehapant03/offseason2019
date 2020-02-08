package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class PotentiometerSub{

    Potentiometer pot;
    
    public PotentiometerSub(){
        pot = new AnalogPotentiometer(0, 360, 30);
        AnalogInput ai = new AnalogInput(1);
        pot = new AnalogPotentiometer(ai, 360, 30);
    }

    public double getVals(){
        return pot.get(); // this seems like the level of abstraction that is like idk useful
    }
}