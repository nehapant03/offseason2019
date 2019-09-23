package frc.robot; 

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class InitMethods{
    public void initVictor(VictorSPX motor) {
		motor.neutralOutput();
		motor.setSensorPhase(false);
		motor.configNominalOutputForward(0, 0);
		motor.configNominalOutputReverse(0, 0);
		motor.configClosedloopRamp(.2, 0);
	}
}
