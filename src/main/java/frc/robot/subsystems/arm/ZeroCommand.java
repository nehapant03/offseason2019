package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ZeroCommand extends Command{

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        Robot.arm.setPower(-.1);
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
        end();
    }
}