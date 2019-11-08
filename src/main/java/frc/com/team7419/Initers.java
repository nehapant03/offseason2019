package frc.com.team7419;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public abstract class Initers {

    public void initVictors(VictorSPX...victors){
        for (VictorSPX victor : victors) {
			victor.neutralOutput();
		    victor.setSensorPhase(false);
		    victor.configNominalOutputForward(0, 0);
		    victor.configNominalOutputReverse(0, 0);
		    victor.configClosedloopRamp(.2, 0);
		}
    }
}