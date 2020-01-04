package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.command.Command;
import com.team7419.MotorGroup;
import com.team7419.PaddedXbox;
import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    requires(Robot.gyro);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    /* factory default just so nothing acts up */
		Robot.driveBase.rightMast.configFactoryDefault();
		Robot.driveBase.leftMast.configFactoryDefault();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    
    SmartDashboard.putString("command status", "arcade");
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY();
    double rightPower = -kTurn * joystick.getRightX() - kStraight * joystick.getLeftY();

    leftSide.setPower(leftPower);
    rightSide.setPower(rightPower);

    if(Robot.oi.joystick.getRightShoulder()){
      Robot.getLeftMast().getSensorCollection().setQuadraturePosition(0, 10);
      Robot.getRightMast().getSensorCollection().setQuadraturePosition(0, 10);
    }

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
