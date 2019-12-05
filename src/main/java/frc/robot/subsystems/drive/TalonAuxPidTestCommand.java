package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team7419.math.DriveBaseConversions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TalonAuxPidTestCommand extends Command {
    
    public TalonSRX leftMast;
    public TalonSRX rightMast;

	public double encoderTarget;
    public int kTimeoutMs = 30;
    public double kNeutralDeadband = .001; // minimum allowable

    public double straightP = 0.1;
    public double straightI = 0;
    public double straightD = 0;
    public double straightF = 0;

    public double turnP = 0;
    public double turnI = 0;
    public double turnD = 0;
    public double turnF = 0;

    public int kIZone = 100;
    public double kStraightPeakOutput = .5;
    public double kTurnPeakOutput = 1;

    public TalonAuxPidTestCommand(TalonSRX leftMast, TalonSRX rightMast, double inches){
        this.leftMast = leftMast;
		this.rightMast = rightMast;
		this.encoderTarget = DriveBaseConversions.inchesToTicks(inches);
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize() {
        /* make sure nothing is moving */
		// rightMast.set(ControlMode.PercentOutput, 0);
		// leftMast.set(ControlMode.PercentOutput, 0);

		// /* factory default just so nothing acts up */
		// rightMast.configFactoryDefault();
		// leftMast.configFactoryDefault();
		
		// /* put into brake mode, idt its necessary but eh */
		// leftMast.setNeutralMode(NeutralMode.Brake);
		// rightMast.setNeutralMode(NeutralMode.Brake);
		
		// /* init left talon as master value getter basically for primary pid*/
		// leftMast.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,	1, kTimeoutMs);

		// /* make left talon remote sensor for right talon */
		// rightMast.configRemoteFeedbackFilter(leftMast.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 0, kTimeoutMs);
		
		// /* for primary pid, use sum of encoder vals (to be averaged later) */
		// rightMast.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, kTimeoutMs);
        // rightMast.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Relative, kTimeoutMs);	
        
		// /* use encoder deltas for adjustments */
		// rightMast.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0, kTimeoutMs);
		// rightMast.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.CTRE_MagEncoder_Relative, kTimeoutMs);
		
		// /* use sum of encoder vals for primary pid basically */
		// rightMast.configSelectedFeedbackSensor(	FeedbackDevice.SensorSum, 0, kTimeoutMs);
		
		// /* this is where we average */
		// rightMast.configSelectedFeedbackCoefficient(0.5, 0, kTimeoutMs);
		
		// /* use encoder deltas for aux pid */
		// rightMast.configSelectedFeedbackSensor(FeedbackDevice.SensorDifference, 1, kTimeoutMs);
		
		// /* unclear as to why we are scaling the coeff but like eh */
		// rightMast.configSelectedFeedbackCoefficient(1, 1, kTimeoutMs);
		// /* output and sensor directions */
		// leftMast.setInverted(false);
		// leftMast.setSensorPhase(true);
		// rightMast.setInverted(true);
		// rightMast.setSensorPhase(true);
		
		// /* set status frame periods so data is non stale allegedly */
		// rightMast.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, kTimeoutMs);
		// rightMast.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, kTimeoutMs);
		// rightMast.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, kTimeoutMs);
		// rightMast.setStatusFramePeriod(StatusFrame.Status_10_Targets, 20, kTimeoutMs);
		// leftMast.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, kTimeoutMs);

		// /* configure neutral deadband, unclear as to what it does but like */
		// rightMast.configNeutralDeadband(kNeutralDeadband, kTimeoutMs);
		// leftMast.configNeutralDeadband(kNeutralDeadband, kTimeoutMs);
		
		// /* motion magic config */
		// rightMast.configMotionAcceleration(2000, kTimeoutMs);
		// rightMast.configMotionCruiseVelocity(2000, kTimeoutMs);

		// /**
		//  * Max out the peak output (for all modes).  
		//  * However you can limit the output of a given PID object with configClosedLoopPeakOutput().
		//  */
		// leftMast.configPeakOutputForward(+1.0, kTimeoutMs);
		// leftMast.configPeakOutputReverse(-1.0, kTimeoutMs);
		// rightMast.configPeakOutputForward(+1.0, kTimeoutMs);
		// rightMast.configPeakOutputReverse(-1.0, kTimeoutMs);

		// /* FPID Gains for distance servo */
		// rightMast.config_kP(0, straightP, kTimeoutMs);
		// rightMast.config_kI(0, straightI, kTimeoutMs);
		// rightMast.config_kD(0, straightD, kTimeoutMs);
		// rightMast.config_kF(0, straightF, kTimeoutMs);
		// rightMast.config_IntegralZone(0, kIZone, kTimeoutMs);
		// rightMast.configClosedLoopPeakOutput(0, kStraightPeakOutput, kTimeoutMs);
		// rightMast.configAllowableClosedloopError(0, 0, kTimeoutMs);

		// /* FPID Gains for turn servo */
		// rightMast.config_kP(1, turnP, kTimeoutMs);
		// rightMast.config_kI(1, turnI, kTimeoutMs);
		// rightMast.config_kD(1, turnD, kTimeoutMs);
		// rightMast.config_kF(1, turnF, kTimeoutMs);
		// rightMast.config_IntegralZone(1, kIZone, kTimeoutMs);
		// rightMast.configClosedLoopPeakOutput(1, kTurnPeakOutput, kTimeoutMs);
		// rightMast.configAllowableClosedloopError(1, 0, kTimeoutMs);

		// /**
		//  * 1ms per loop.  PID loop can be slowed down if need be.
		//  * For example,
		//  * - if sensor updates are too slow
		//  * - sensor deltas are very small per update, so derivative error never gets large enough to be useful.
		//  * - sensor movement is very slow causing the derivative error to be near zero.
		//  */
		// int closedLoopTimeMs = 1;
		// rightMast.configClosedLoopPeriod(0, closedLoopTimeMs, kTimeoutMs);
		// rightMast.configClosedLoopPeriod(1, closedLoopTimeMs, kTimeoutMs);

		// /**
		//  * configAuxPIDPolarity(boolean invert, int timeoutMs)
		//  * false means talon's local output is PID0 + PID1, and other side Talon is PID0 - PID1
		//  * true means talon's local output is PID0 - PID1, and other side Talon is PID0 + PID1
		//  */
		// rightMast.configAuxPIDPolarity(true, kTimeoutMs);


    }

    @Override
    protected void execute(){

		// rightMast.selectProfileSlot(0, 0);
		// rightMast.selectProfileSlot(1, 1);

		// rightMast.set(ControlMode.MotionMagic, encoderTarget, DemandType.AuxPID, 0);
		// leftMast.follow(rightMast, FollowerType.AuxOutput1);

		SmartDashboard.putNumber("leftMast", leftMast.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("rightMast", rightMast.getSelectedSensorPosition(0));


		SmartDashboard.putNumber("leftMast", leftMast.getMotorOutputPercent());
		SmartDashboard.putNumber("rightMast", rightMast.getMotorOutputPercent());

    }

    @Override
    protected void end(){

    }

    @Override
    protected void interrupted(){
        
    }

    @Override
    protected boolean isFinished(){
        return false;
    }
}