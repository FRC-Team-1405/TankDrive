// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class ArcadeDrive extends CommandBase {
  private DriveBase driveBase;
  private DoubleSupplier speed;
  private DoubleSupplier rotation;
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(DriveBase driveBase, DoubleSupplier speed, DoubleSupplier rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
    this.driveBase = driveBase;
    this.speed = speed;
    this.rotation = rotation;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
