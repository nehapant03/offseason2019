package frc.com.team7419;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public abstract class TalonFuncs {

    public void configEncoder(TalonSRX talon){
        talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    }

    public void setMotionMagicParams(TalonSRX talon, int maxSpeed, int maxAcc){
        talon.configMotionCruiseVelocity(maxSpeed, 0);
        talon.configMotionAcceleration(maxAcc);
    }

    public static void setPIDFConstants(TalonSRX talon, double kP, double kI, double kD, double kF) {
		talon.config_kP(0, kP, 0);
		talon.config_kI(0, kI, 0);
		talon.config_kD(0, kD, 0);
		talon.config_kF(0, kF, 0);
	}

}