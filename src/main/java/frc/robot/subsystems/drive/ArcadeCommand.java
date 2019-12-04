/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Command;
import com.team7419.MotorGroup;
import com.team7419.PaddedXbox;
import frc.robot.*;

/**
 * Reusable arcade command
 */
public class ArcadeCommand extends Command {

  private MotorGroup leftSide;
  private MotorGroup rightSide;
  private double kStraight;
  private double kTurn;
  private PaddedXbox joystick;

  /**
   * @param joystick PaddedXbox class
   * @param leftSide MotorGroup class
   * @param rightSide MotorGroup class
   * @param kStraight 
   * @param kTurn
   */
  public ArcadeCommand(PaddedXbox joystick, MotorGroup leftSide, MotorGroup rightSide, double kStraight, double kTurn){
    this.joystick = joystick;
    this.leftSide = leftSide;
    this.rightSide = rightSide;
    this.kStraight = kStraight;
    this.kTurn = kTurn;
    requires(Robot.driveBase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {
    
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY();
    double rightPower = kTurn * joystick.getRightX() + kStraight * joystick.getLeftY();

    leftSide.setPower(leftPower);
    rightSide.setPower(rightPower);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
