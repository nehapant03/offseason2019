package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.arm.ArmSub;
import frc.robot.subsystems.arm.HallEffectSub;
import frc.robot.subsystems.arm.PotentiometerSub;
import frc.robot.subsystems.drive.*;
 
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveBaseSub driveBase;
  public static ArcadeCommand arcade;
  public static TankCommand tank;
  public static HallEffectSub hallEffect;
  public static PotentiometerSub potentiometer;
  public static ArmSub arm;
  public static TalonAuxPidTestCommand auxPidTest;
  public static RunWithMotionMagic motionMagic;

  @Override
  public void robotInit() {
    oi = new OI();
    driveBase = new DriveBaseSub();
    arcade = new ArcadeCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .2, .2);
    tank = new TankCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .2, .4);
    auxPidTest = new TalonAuxPidTestCommand(driveBase.leftMast, driveBase.rightMast, 12);
    hallEffect = new HallEffectSub();
    potentiometer = new PotentiometerSub();
    arm = new ArmSub();
    motionMagic = new RunWithMotionMagic(12);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    //arcade.start();
  }

  @Override
  public void teleopPeriodic() {
    if(oi.joystick.getA()){
      motionMagic.start();
    }
    else if(oi.joystick.getB()){
      motionMagic.cancel();
    }
    else if(oi.joystick.getXButton()){
      arcade.start();
    }
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

  public static TalonSRX getRightMast(){return driveBase.rightMast;}
  public static TalonSRX getLeftMast(){return driveBase.leftMast;}

}
