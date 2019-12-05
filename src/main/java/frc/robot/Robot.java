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

  @Override
  public void robotInit() {
    oi = new OI();
    driveBase = new DriveBaseSub();
    arcade = new ArcadeCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .4, .4);
    tank = new TankCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .2, .4);
    auxPidTest = new TalonAuxPidTestCommand(driveBase.leftMast, driveBase.rightMast, 24);
    hallEffect = new HallEffectSub();
    potentiometer = new PotentiometerSub();
    arm = new ArmSub();
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
    auxPidTest.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

  public TalonSRX getRightMast(){return driveBase.rightMast;}
  public TalonSRX getLeftMast(){return driveBase.leftMast;}

}
