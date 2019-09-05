package frc.robot;

public enum RobotMap {
  LEFTFOL(39),
	RIGHTFOL(44),
	LEFTTAL(31),
	RIGHTTAL(36),
	LEFTFRONT(32),
  RIGHTFRONT(34);
  
  public final int value; 
  
  RobotMap(int value){
    this.value = value;
  }
}
