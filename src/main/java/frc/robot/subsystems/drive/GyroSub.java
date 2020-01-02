package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.SerialPort;
import com.kauailabs.navx.frc.AHRS;

public class GyroSub {

    public AHRS ahrs;
    
    public void GyroSub(){
        try {
			/* Communicate w/navX-MXP via the MXP SPI Bus (use mini USB to USB A cable)   
			   Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or S     
			   See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
			ahrs = new AHRS(SerialPort.Port.kUSB); 
		} catch (RuntimeException ex ) {
			System.out.println("Error instantiating navX-MXP: " + ex.getMessage()); 
        }
        this.ahrs = ahrs;
    }

    public double getGyroAngle(){
        return ahrs.getAngle();
    }
}