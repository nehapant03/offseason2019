/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

  public PaddedXbox joystick = new PaddedXbox();
  public JoystickButton leftDpad = new JoystickButton(joystick.playerOne, joystick.playerOne.getPOV());
  
  public OI(){}
}
