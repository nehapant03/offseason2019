package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.arm.*;
import frc.robot.subsystems.dashboard.*;
import frc.robot.subsystems.drive.*;
 
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveBaseSub driveBase;
  public static ArcadeCommand arcade;
  public static TankCommand tank;
  public static HallEffectSub hallEffect;
  public static PotentiometerSub potentiometer;
  public static ArmSub arm;
  public static RunWithMotionMagic motionMagic;
  public static Dashboard dashboard;
  public static PathfinderTestCommand pathfinder;

  @Override
  public void robotInit() {
    oi = new OI();
    driveBase = new DriveBaseSub();
    arcade = new ArcadeCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .4, .4);
    tank = new TankCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .2, .4);
    hallEffect = new HallEffectSub();
    potentiometer = new PotentiometerSub();
    arm = new ArmSub();
    motionMagic = new RunWithMotionMagic(36);
    dashboard = new Dashboard();
    pathfinder = new PathfinderTestCommand();
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
    pathfinder.start();
  }

  @Override
  public void teleopPeriodic() {
    if(oi.joystick.getA()){
      pathfinder.start();
    }
    else if(oi.joystick.getB()){
      pathfinder.cancel();
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
