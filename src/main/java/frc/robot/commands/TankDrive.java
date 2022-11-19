// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class TankDrive extends CommandBase {
  private DriveBase driveBase;
  private DoubleSupplier leftSpeed;
  private DoubleSupplier rightSpeed;
  /** Creates a new TankDrive. */
  public TankDrive(DriveBase driveBase, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
    this.driveBase = driveBase;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.tankDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
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
