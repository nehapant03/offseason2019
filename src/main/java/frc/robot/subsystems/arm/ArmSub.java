package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotMap;

public class ArmSub{

    public TalonSRX armMotor;

    public ArmSub(){
        armMotor = new TalonSRX(RobotMap.armTalon.value);
    }

    public void setPower(double power){
        armMotor.set(ControlMode.PercentOutput, power);
    }
}