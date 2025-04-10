// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Commands.LedCommand;
import frc.robot.Subsystems.*;
import frc.deploy.animations;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private Leds s_leds = new Leds();
  private Drivetrain s_Drivetrain = new Drivetrain();

  private CommandXboxController driver = new CommandXboxController(0);

  public RobotContainer() {
    setSystemBindings();
    configureControllerBindings();
  }

  private void setSystemBindings() {
    s_leds.setDefaultCommand(new LedCommand(s_leds, animations.eyes));
  }

  private void configureControllerBindings() {
    s_Drivetrain.setDefaultCommand(Commands.run(() ->
      s_Drivetrain.driveMecanum(driver.getLeftY(), driver.getLeftX(), driver.getRightX())  
    , s_Drivetrain));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
