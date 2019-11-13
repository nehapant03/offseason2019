package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.TankCommand;
import frc.robot.subsystems.DriveBaseSub;
 
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveBaseSub driveBase;
  public static ArcadeCommand arcade;
  public static TankCommand tank;

  @Override
  public void robotInit() {
    oi = new OI();
    driveBase = new DriveBaseSub();
    arcade = new ArcadeCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .4, .4);
    tank = new TankCommand(oi.joystick, driveBase.leftSide, driveBase.rightSide, .2, .4);
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
    tank.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
