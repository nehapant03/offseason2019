package frc.com.team7419;

import edu.wpi.first.wpilibj.XboxController;

public class PaddedXbox{

    private XboxController playerOne; 

    public PaddedXbox(){
        playerOne = new XboxController(F310Map.f310Main.value);
    }

    enum F310Map{
        //Input Map
        f310Main(0),
        f310Secondary(1),
        
        //F310 MAP
        kGamepadAxisLeftStickX(0),
        kGamepadAxisLeftStickY(1),
        kGamepadAxisLeftTrigger(2),
        kGamepadAxisRightTrigger(3),
        kGamepadAxisRightStickX(4),
        kGamepadAxisRightStickY(5),
        kGamepadAxisDpad(6),
        kGamepadButtonA(1),
        kGamepadButtonB(2),
        kGamepadButtonX(3),
        kGamepadButtonY(4),
        kGamepadButtonShoulderL(5),
        kGamepadButtonShoulderR(6),
        kGamepadButtonBack(7),
        kGamepadButtonStart(8),
        kGamepadButtonLeftStickButton(9),
        kGamepadButtonRightStickButton(10),
        kGamepadButtonMode(-1),
        kGamepadButtonLogitech(-1);
        
        public final int value;
        F310Map(int value) {
            this.value = value;
        }	
    }

    public double getRightX() {
		double out = playerOne.getRawAxis(F310Map.kGamepadAxisRightStickX.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return out;
	}
	public double getLeftX() {
		double out = playerOne.getRawAxis(F310Map.kGamepadAxisLeftStickX.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return out;
	}
	public double getLeftY() {
		double out = -playerOne.getRawAxis(F310Map.kGamepadAxisLeftStickY.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return -out;
	}
	public double getRightY() {
		double out = -playerOne.getRawAxis(F310Map.kGamepadAxisRightStickY.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return out;
	}
	public double getLeftTrig() {
		double out = playerOne.getRawAxis(F310Map.kGamepadAxisLeftTrigger.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return -out;
	}
	public double getRightTrig() {
		double out = playerOne.getRawAxis(F310Map.kGamepadAxisRightTrigger.value);
		if(Math.abs(out)<.05) {
			out = 0;
		}
		return out;
	}
	
	public boolean getB() {
		return playerOne.getRawButton(F310Map.kGamepadButtonB.value);
	}

	
	public boolean getA() {
		return playerOne.getRawButton(F310Map.kGamepadButtonA.value);
	}
	
	public boolean getY() {
		return playerOne.getRawButton(F310Map.kGamepadButtonY.value);
	}
	
	public boolean getX() {
		return playerOne.getRawButton(F310Map.kGamepadButtonX.value);
	}

	public boolean getRightShoulder(){
		return playerOne.getRawButton(F310Map.kGamepadButtonShoulderR.value);
	}

	public boolean getLeftShoulder(){
		return playerOne.getRawButton(F310Map.kGamepadButtonShoulderL.value);
	}

	public int getDpad(){
		return playerOne.getPOV();
	}
}