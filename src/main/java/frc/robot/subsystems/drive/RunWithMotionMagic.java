package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.team7419.math.DriveBaseConversions;
import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunWithMotionMagic extends Command{

    private double setpoint;

    public RunWithMotionMagic(double setpoint){
        this.setpoint = setpoint;
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

        double leftSet = DriveBaseConversions.inchesToTicks(setpoint) + Robot.getLeftMast().getSelectedSensorPosition();
        double rightSet = DriveBaseConversions.inchesToTicks(setpoint) + Robot.getRightMast().getSelectedSensorPosition();

        Robot.getLeftMast().set(ControlMode.MotionMagic, leftSet);
		Robot.getRightMast().set(ControlMode.MotionMagic, rightSet);
        
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