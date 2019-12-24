package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.team7419.TalonFuncs;
import com.team7419.math.DriveBaseConversions;
import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class RunWithMotionMagic extends Command{

    private double setpoint;

    public RunWithMotionMagic(double setpoint){
        this.setpoint = setpoint;
        requires(Robot.driveBase);
    }

    @Override
    public void initialize(){

        SmartDashboard.putString("command status", "motion magic test");
        /* factory default just so nothing acts up */
		Robot.getRightMast().configFactoryDefault();
        Robot.getLeftMast().configFactoryDefault();
        
        Robot.getLeftMast().getSensorCollection().setQuadraturePosition(0, 10);
        Robot.getRightMast().getSensorCollection().setQuadraturePosition(0, 10); 

        // velocity: 5375, acc. converting .7
        Robot.getLeftMast().configMotionCruiseVelocity(5375, 0);
		Robot.getLeftMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);

        Robot.getRightMast().configMotionCruiseVelocity(5375, 0);
        Robot.getRightMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);  
        
        TalonFuncs.setPIDFConstants(0, Robot.getLeftMast(), .6, 0, 0.1, 0);
        TalonFuncs.setPIDFConstants(0, Robot.getRightMast(), .6, 0, 0.1, 0);

        double leftSet = DriveBaseConversions.inchesToTicks(setpoint) + Robot.getLeftMast().getSelectedSensorPosition(0);
        double rightSet = DriveBaseConversions.inchesToTicks(setpoint) + Robot.getRightMast().getSelectedSensorPosition(0);

        SmartDashboard.putNumber("leftSet", leftSet);
        SmartDashboard.putNumber("rightSet", rightSet);

        Robot.getLeftMast().set(ControlMode.MotionMagic, leftSet);
		Robot.getRightMast().set(ControlMode.MotionMagic, rightSet);

    }

    @Override
    public void execute(){

        SmartDashboard.putString("command status", "excuting motion magic");

        SmartDashboard.putNumber("leftMast", Robot.driveBase.leftMast.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("rightMast", Robot.driveBase.rightMast.getSelectedSensorPosition(0));
    
        SmartDashboard.putNumber("leftMastOutput", Robot.driveBase.leftMast.getMotorOutputPercent());
        SmartDashboard.putNumber("rightMastOutput", Robot.driveBase.rightMast.getMotorOutputPercent());
        
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