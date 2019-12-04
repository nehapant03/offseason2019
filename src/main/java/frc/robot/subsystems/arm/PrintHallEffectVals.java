package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class PrintHallEffectVals extends Command{

    @Override
    public void initialize(){

    }

    @Override 
    public void execute(){

    }
    
    @Override
    public void end(){
        SmartDashboard.putString("hall effect status", "end");
    }

    @Override
    public void interrupted(){
        end();
    }

    @Override
    public boolean isFinished(){
        return Robot.hallEffect.sensor.get();
    }

}