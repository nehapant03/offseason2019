package frc.robot.subsystems.drive;

import org.junit.*;
import frc.robot.Robot;

import static org.mockito.Mockito.*;
import com.team7419.MotorGroup;
import com.team7419.PaddedXbox;

public class DriveBaseSubTest {


    @Before
    public void setUp() {
        Robot.driveBase = mock(DriveBaseSub.class);
    }

    @Test
    public void firstTest() {

        MotorGroup leftMock = mock(MotorGroup.class);
        MotorGroup rightMock = mock(MotorGroup.class);
        PaddedXbox joystick = mock(PaddedXbox.class);

        ArcadeCommand arcadeMock = new ArcadeCommand(joystick, leftMock, rightMock, 0.5, 0.2);
        arcadeMock.execute();
    }
}