package frc.robot.subsystems.drive;

public enum DriveBaseConstants{

    width(.83), // in m

    maxAcceleration(.7), // in m/s^2
    maxVelocity(2); // in m/s

    public final double value; 
    DriveBaseConstants(double value){
    this.value = value;
  }
}