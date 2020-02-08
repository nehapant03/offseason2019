package frc.robot.subsystems;

import org.junit.*;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

import com.team7419.motors.DcMotor;
import com.team7419.motors.MotorType;

public class MockArmTest {

    DcMotor armMotor = new DcMotor(MotorType.Cim);

    @Test
    public void getArmValues(){
       armMotor.step(12, 5, 0, 5);
       double curPos = armMotor.getPosition();
       System.out.println(curPos);
        
    }

    /** 
     * current status: gives up when we try to make a PidController
     */
    @Test
    public void testPid() {

        PIDSource mockEncoderValues = new MockArmPidSource(armMotor);
        mockEncoderValues.setPIDSourceType(PIDSourceType.kRate);
        
        PIDOutput runMotor = new PIDOutput() { // this is where you choose what you want to do w the output of the pid loop
            @Override
            public synchronized void pidWrite(double output) {
                armMotor.step(output, 5, 0, 0.01);
            }
        };
        
        PIDController armController = new PIDController(.1, 0, .1, mockEncoderValues, runMotor); //new pid controller for gyro stuff
		armController.setInputRange(0f,  10000.0f); // not sure what upper bound is but like
		armController.setOutputRange(0.0, 12.0); //output should be from 0 to 12, controlling voltage
        armController.setContinuous(false); // not circular
        
        armController.setPID(0.5, 0, 0.1);
		armController.enable(); //turn it on
        armController.setSetpoint(12);
        armController.close();
        System.out.println(armController.get());

    }
}