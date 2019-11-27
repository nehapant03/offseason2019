package com.team7419.motors;

import com.team7419.math.*;

/**
     * simulation motor based on 971's motor model
     * essentially modelling motor as generator + resistor
     */
public class DcMotor{

    private double kT;
    private double kV;

    public DcMotor(MotorType motorType){
        
        /**
         * sets the motor constants kT and kV based on motorType
         */
        switch(motorType.value){
            /** cim */
            case 0:
                kV = getkV(131, 5330, 2.7);
                kT = getkT(2.41, 131);
            /** mini cim */
            case 1:
                kV = getkV(89, 5840, 3.0);
                kT = getkT(1.41, 89);
            /** 775 pro */
            case 2:
                kV = getkV(134, 18730, 0.7);
                kT = getkT(.71, 134);
        }
    }

    /**
     * @param kPeakCurrent in Amps, current at stall torque
     * @param kFreeSpeed in rpm, when there's no load on motor
     * @param kFreeCurrent in Amps, current at free speed
     * @return voltage constant of the motor for use in calculations
     */
    public double getkV(double kPeakCurrent, double kFreeSpeed, double kFreeCurrent){
        double kInternalResistance = 12 / kPeakCurrent;
        return (UnitConversions.rpmToRadPerSec(kFreeSpeed) + kInternalResistance * kFreeCurrent) / 12;
    }

    /**
     * @param kStallTorque in N*m, when motor is stalled
     * @param kStallCurrent in Amps, current at stall torque
     * @return torque constant of the motor for use in calculations
     */
    public double getkT(double kStallTorque, double kStallCurrent){
        return kStallTorque / kStallCurrent;
    }
}