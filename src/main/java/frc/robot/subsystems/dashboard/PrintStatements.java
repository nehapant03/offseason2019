package frc.robot.subsystems.dashboard;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class PrintStatements extends Command{
    
    public PrintStatements(){
        requires(Robot.dashboard);
    }

    @Override 
    public void initialize(){

    }

    @Override 
    public void execute(){

        SmartDashboard.putString("drive base", Robot.driveBase.getCurrentCommandName());

        SmartDashboard.putNumber("leftMast", Robot.driveBase.leftMast.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("rightMast", Robot.driveBase.rightMast.getSelectedSensorPosition(0));
    
        SmartDashboard.putNumber("leftMastOutput", Robot.driveBase.leftMast.getMotorOutputPercent());
        SmartDashboard.putNumber("rightMastOutput", Robot.driveBase.rightMast.getMotorOutputPercent());

    }

    @Override 
    public void end(){

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