// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;
import frc.robot.lib.CycleCommands;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Pneumatics;
import frc.robot.commands.Buzzer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController driver = new XboxController (0);
private final DriveBase driveBase = new DriveBase();
private final TankDrive tankDrive = new TankDrive(driveBase, driver::getLeftY, driver::getRightY);
private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveBase, driver::getLeftY, driver::getRightX);
private final Pneumatics pneumatics = new Pneumatics();
private final Buzzer buzzer = new Buzzer(pneumatics);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    driveBase.setDefaultCommand(tankDrive);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    new JoystickButton(driver, XboxController.Button.kY.value).whenPressed(buzzer);

    new CycleCommands( "Drive Mode",
                       new CommandBase[] {tankDrive, arcadeDrive},
                       new JoystickButton(driver, XboxController.Button.kLeftBumper.value),
                       new JoystickButton(driver, XboxController.Button.kRightBumper.value)
                       );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new PrintCommand("no auto command");
  }
}
