package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.InitMethods;

public class DriveBaseSub extends Subsystem {
  private VictorSPX leftFront;
	private VictorSPX rightFront;
	private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;

  public InitMethods init;
  
  public DriveBaseSub(){
    leftFol = new VictorSPX(RobotMap.LEFTFOL.value);
		rightFol = new VictorSPX(RobotMap.RIGHTFOL.value);
		leftMast = new TalonSRX(RobotMap.LEFTTAL.value);
		rightMast = new TalonSRX(RobotMap.RIGHTTAL.value);
		leftFront = new VictorSPX(RobotMap.LEFTFRONT.value);
    rightFront = new VictorSPX(RobotMap.RIGHTFRONT.value);

    init = new InitMethods();
    
    init.initVictor(leftFol);
		init.initVictor(rightFol);
		init.initVictor(leftFront);
		init.initVictor(rightFront);

  }

  @Override
  public void initDefaultCommand() {
    
  }
}
