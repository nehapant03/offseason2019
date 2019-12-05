package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.team7419.Initers;
import com.team7419.MotorGroup;
import com.team7419.TalonFuncs;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveBaseSub extends Subsystem {

	private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;
  public MotorGroup leftSide; 
  public MotorGroup rightSide;
  
  public DriveBaseSub(){
    
    leftFol = new VictorSPX(RobotMap.leftVictor.value);
		rightFol = new VictorSPX(RobotMap.rightVictor.value);
		leftMast = new TalonSRX(RobotMap.leftTalon.value);
		rightMast = new TalonSRX(RobotMap.rightTalon.value);

    leftSide = new MotorGroup(leftMast, leftFol);
    rightSide = new MotorGroup(rightMast, rightFol);

    Initers.initVictors(leftFol, rightFol);

    leftSide.followMaster();
    rightSide.followMaster();

    leftMast.neutralOutput();
		leftMast.setSensorPhase(false);
    leftMast.configNominalOutputForward(0, 0);
		leftMast.configNominalOutputReverse(0, 0);
    leftMast.configClosedloopRamp(.2, 0);
        
    rightMast.neutralOutput();
		rightMast.setSensorPhase(false);
    rightMast.configNominalOutputForward(0, 0);
		rightMast.configNominalOutputReverse(0, 0);
		rightMast.configClosedloopRamp(.2, 0);

    TalonFuncs.configEncoder(leftMast);
    TalonFuncs.configEncoder(rightMast);
  }

  @Override
  public void initDefaultCommand() {} 
    //imma not do this bc we want to feed arcade constructor useful things in Robot.java
    
  public MotorGroup getLeftSide(){return leftSide;}
  public MotorGroup getRightSide(){return rightSide;}
  
}
