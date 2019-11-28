package com.team7419.motors;

import com.team7419.math.*;

/**
* simulation motor based on 971's motor model
* essentially modelling motor as generator + resistor
*/
public class DcMotor{

    private double kT;
    private double kV;
    private double kInternalResistance;

    /**
     * constructs a DcMotor based on a given type
     */
    public DcMotor(MotorType motorType){
        
        /**
         * sets the motor constants kT and kV based on motorType
         */
        switch(motorType.value){
            /** cim */
            case 0:
                kInternalResistance = getkInternalResistance(131);
                kV = getkV(kInternalResistance, 5330, 2.7);
                kT = getkT(2.41, 131);
            /** mini cim */
            case 1:
                kInternalResistance = getkInternalResistance(89);
                kV = getkV(kInternalResistance, 5840, 3.0);
                kT = getkT(1.41, 89);
            /** 775 pro */
            case 2:
                kInternalResistance = getkInternalResistance(134);
                kV = getkV(kInternalResistance, 18730, 0.7);
                kT = getkT(.71, 134);
        }
    }

    /**
     * pretty much only for use setting up a transmission but like eh
     * @param kV can be computed using getkV
     * @param kT can be computed using getkT
     * @param kInternalResistance can be computed using getkInternalResistance
     */
    public DcMotor(double kV, double kT, double kInternalResistance){
        this.kV = kV;
        this.kInternalResistance = kInternalResistance;
        this.kT = kT;
    }


    private double getkInternalResistance(double kPeakCurrent){
        return 12 / kPeakCurrent;
    }

    /**
     * @param kPeakCurrent in Amps, current at stall torque
     * @param kFreeSpeed in rpm, when there's no load on motor
     * @param kFreeCurrent in Amps, current at free speed
     * @return voltage constant of the motor for use in calculations
     */
    private double getkV(double internalResistance, double freeSpeed, double freeCurrent){
        return (UnitConversions.rpmToRadPerSec(freeSpeed) + internalResistance * freeCurrent) / 12;
    }

    /**
     * @param kStallTorque in N*m, when motor is stalled
     * @param kStallCurrent in Amps, current at stall torque
     * @return torque constant of the motor for use in calculations
     */
    private double getkT(double stallTorque, double stallCurrent){
        return stallTorque / stallCurrent;
    }
}