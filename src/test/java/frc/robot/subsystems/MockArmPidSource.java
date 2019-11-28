package frc.robot.subsystems;

import com.team7419.motors.DcMotor;
import com.team7419.pid.PidSourceBase;

public class MockArmPidSource extends PidSourceBase {
    DcMotor motor;

    public MockArmPidSource(DcMotor motor){
        this.motor = motor;
    }

    @Override
    public double pidGet(){
        return this.motor.getPosition(); 
    }
}