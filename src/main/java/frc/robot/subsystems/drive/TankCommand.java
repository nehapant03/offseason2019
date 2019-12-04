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
public class TankCommand extends Command {

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
  public TankCommand(PaddedXbox joystick, MotorGroup leftSide, MotorGroup rightSide, double kStraight, double kTurn){
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
  protected void execute() {

    double leftPower = joystick.getLeftY();
    double rightPower = joystick.getRightY();

    if(leftPower * rightPower > 0){ //going in same direction, robot is straight
        leftPower *= kStraight;
        rightPower *= kStraight;
    }
    else{ //opp directions, robot is turning
        leftPower *= kTurn;
        rightPower *= kTurn;
    }

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
