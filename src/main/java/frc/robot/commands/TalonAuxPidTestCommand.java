package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TalonAuxPidTestCommand extends Command {
    
    public TalonSRX leftMast;
    public TalonSRX rightMast;

    public int kTurnTravelUnitsPerRotation;
    public int kEncoderUnitsPerRotation;
    public int kTimeoutMs = 30;

    public TalonAuxPidTestCommand(TalonSRX leftMast, TalonSRX rightMast){
        this.leftMast = leftMast;
        this.rightMast = rightMast;
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize() {
        /* factory default to make sure nothing acts up */
        leftMast.configFactoryDefault();
        rightMast.configFactoryDefault();

        /* make sure power output is 0 before we start */
        leftMast.set(ControlMode.PercentOutput, 0);
        rightMast.set(ControlMode.PercentOutput, 0);
        
        /* put into brake mode */
        leftMast.setNeutralMode(NeutralMode.Brake);
        rightMast.setNeutralMode(NeutralMode.Brake);

        /* configure left side as primary pid */
        leftMast.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs); 

        /* configure leftMast as remote sensor for rightMast */
        rightMast.configRemoteFeedbackFilter(leftMast.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 0, kTimeoutMs);

        /* sets up the difference term to be used for turning */
        rightMast.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0, kTimeoutMs);
        leftMast.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.CTRE_MagEncoder_Relative, kTimeoutMs);
        // this line says rightMast in sample code but im not convinced that makes any sense

        /* Scale the Feedback Sensor using a coefficient */
		/**
		 * Heading units should be scaled to ~4000 per 360 deg, due to the following limitations...
		 * - Target param for aux PID1 is 18bits with a range of [-131072,+131072] units.
		 * - Target for aux PID1 in motion profile is 14bits with a range of [-8192,+8192] units.
		 *  ... so at 3600 units per 360', that ensures 0.1 degree precision in firmware closed-loop
		 *  and motion profile trajectory points can range +-2 rotations.
		 */
        rightMast.configSelectedFeedbackCoefficient(kTurnTravelUnitsPerRotation / kEncoderUnitsPerRotation, 1, kTimeoutMs);

        /* configure output and sensor direction */
		leftMast.setInverted(false);
		leftMast.setSensorPhase(true);
		rightMast.setInverted(true);
        rightMast.setSensorPhase(true);
        
        /* set status frame periods */
        rightMast.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, kTimeoutMs);
		rightMast.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, kTimeoutMs);
		leftMast.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, kTimeoutMs);

    }

    @Override
    protected void execute(){

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