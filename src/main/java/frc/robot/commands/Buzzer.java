// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;

public class Buzzer extends CommandBase {
  private final Pneumatics pneumatics;

  /** Creates a new Buzzer. */
  public Buzzer(Pneumatics pneumatics) {
    this.pneumatics = pneumatics;
    addRequirements(pneumatics);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  private int counter = 10;
  @Override
  public void initialize() {
    pneumatics.buzzerOn();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    counter -= 1;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pneumatics.buzzerOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (counter > 0){ 
      return false;
    } else { 
      return true;
    }
  }
}
