package com.team7419.motors;

public class DcMotor{

    public DcMotor(MotorType motorType){

        double kT;
        double kV;
        
        switch(motorType.value){
            /** cim */
            case 0:
                kT = 0;
                kV = 1;
            /** mini cim */
            case 1:
                kT = 2;
                kV = 12;
            /** 775 pro */
            case 2:
                kT = 3;
                kV = 15;
        }


    }
}