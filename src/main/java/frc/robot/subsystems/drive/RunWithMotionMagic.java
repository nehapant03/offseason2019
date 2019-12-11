package frc.robot.subsystems.drive;

import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunWithMotionMagic extends Command{

    public RunWithMotionMagic(){
        requires(Robot.driveBase);
    }

    @Override
    public void initialize(){
        /* factory default just so nothing acts up */
		Robot.getRightMast().configFactoryDefault();
        Robot.getLeftMast().configFactoryDefault();
        
        Robot.getLeftMast().configMotionCruiseVelocity(5375, 0);
		Robot.getLeftMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);

        Robot.getRightMast().configMotionCruiseVelocity(5375, 0);
		Robot.getRightMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);    

    }

    @Override
    public void execute(){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(){

    }

    @Override
    public void interrupted(){

    }
}