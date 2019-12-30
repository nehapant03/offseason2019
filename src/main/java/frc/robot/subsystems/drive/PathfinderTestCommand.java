package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class PathfinderTestCommand extends Command{

    double leftOutput;
    double rightOutput;

    EncoderFollower left;
    EncoderFollower right;

    public void PathfinderTestCommand(){
        requires(Robot.driveBase);
    }

    @Override
    public void initialize(){

        SmartDashboard.putString("command status", "initializing");

        // fix the max velocity / acceleration at some point (in the nice enum!)
        // check drivebasefunctions?
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, 
                                                        Trajectory.Config.SAMPLES_HIGH, 
                                                        0.02, // timestep on watchdog
                                                        2, // max velocity
                                                        .7, // max acceleration
                                                        30); // jerk because i kinda j wanna make this menos agresivo as they say
        Waypoint[] points = new Waypoint[] {
            // new Waypoint(3, 3, 45),
            new Waypoint(10, 10, Pathfinder.d2r(-90)),
            new Waypoint(0, 0, 0),
        };

        /* generating ideal trajectory for center of robot */
        Trajectory trajectory = Pathfinder.generate(points, config); 

        /* life isn't perfect and dimensionality exists. so.
           set up modifier to account for robot width */
        TankModifier modifier = new TankModifier(trajectory);
        modifier.modify(DriveBaseConstants.width.value);

        /* reset encoders because why not */
        Robot.getLeftMast().getSensorCollection().setQuadraturePosition(0, 10);
        Robot.getRightMast().getSensorCollection().setQuadraturePosition(0, 10); 

        /* sets up encoder follower objects for each side of the drive train */ 
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());

        left.configureEncoder(Robot.getLeftMast().getSelectedSensorPosition(0), 4096, 6);
        right.configureEncoder(Robot.getRightMast().getSelectedSensorPosition(0), 4096, 6);

        left.configurePIDVA(.5, 0.0, 0.0, 1 / DriveBaseConstants.maxVelocity.value, 0);
        right.configurePIDVA(.5, 0.0, 0.0, 1 / DriveBaseConstants.maxVelocity.value, 0);

    }

    @Override
    public void execute(){

        SmartDashboard.putString("command status", "pathfinder");

        leftOutput = left.calculate(Robot.getLeftMast().getSelectedSensorPosition(0));
        rightOutput = right.calculate(Robot.getRightMast().getSelectedSensorPosition(0));

        

        Robot.getLeftMast().set(ControlMode.PercentOutput, leftOutput);
        Robot.getRightMast().set(ControlMode.PercentOutput, rightOutput);

        SmartDashboard.putNumber("leftMastOutput", leftOutput);
        SmartDashboard.putNumber("rightMastOutput", rightOutput);
    }

    @Override
    public void end(){
        Robot.getLeftMast().set(ControlMode.PercentOutput, 0);
        Robot.getRightMast().set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void interrupted(){
        end();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}