package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.ArcadeCommand;
import frc.robot.subsystems.DriveBaseSub;
 
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveBaseSub driveBase;
  public static ArcadeCommand arcade;

  @Override
  public void robotInit() {
    oi = new OI();
    driveBase = new DriveBaseSub();
    //arcade = new ArcadeCommand();
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
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
