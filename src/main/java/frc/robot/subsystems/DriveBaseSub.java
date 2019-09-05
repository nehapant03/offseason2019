package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveBaseSub extends Subsystem {
  private VictorSPX leftFront;
	private VictorSPX rightFront;
	private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;
  
  public DriveBaseSub(){
    leftFol = new VictorSPX(RobotMap.LEFTFOL.value);
		rightFol = new VictorSPX(RobotMap.RIGHTFOL.value);
		leftMast = new TalonSRX(RobotMap.LEFTTAL.value);
		rightMast = new TalonSRX(RobotMap.RIGHTTAL.value);
		leftFront = new VictorSPX(RobotMap.LEFTFRONT.value);
    rightFront = new VictorSPX(RobotMap.RIGHTFRONT.value);
    

  }

  @Override
  public void initDefaultCommand() {
    
  }
}
