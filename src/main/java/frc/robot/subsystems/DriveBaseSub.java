package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveBaseSub extends Subsystem {

	private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;

  
  public DriveBaseSub(){
    leftFol = new VictorSPX(RobotMap.leftVictor.value);
		rightFol = new VictorSPX(RobotMap.rightVictor.value);
		leftMast = new TalonSRX(RobotMap.leftTalon.value);
		rightMast = new TalonSRX(RobotMap.rightTalon.value);

    

  }

  @Override
  public void initDefaultCommand() {
    
  }
}
