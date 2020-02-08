package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HallEffectSub extends Subsystem {
    
    DigitalInput sensor;

  public HallEffectSub(){
    
    sensor = new DigitalInput(RobotMap.hallEffect.value);

  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new PrintHallEffectVals());
  } 

}
