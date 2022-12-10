// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.lib.FeatureFlag;

public class DriveBase extends SubsystemBase {
  /** Creates a new DriveBase. */

  private WPI_TalonSRX frontleft = new WPI_TalonSRX(1);
  private WPI_TalonSRX frontright = new WPI_TalonSRX(2);

  private DifferentialDrive drive = new DifferentialDrive(frontleft,frontright);
  
  public DriveBase() {
    if (FeatureFlag.isEnabled(FeatureFlag.Flag.MotorDouble)){
      WPI_TalonSRX rearleft = new WPI_TalonSRX(3);
      WPI_TalonSRX rearright = new WPI_TalonSRX(4);
    
      rearleft.follow(frontleft);
      rearright.follow(frontright);
    }
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(-leftSpeed, rightSpeed);
  }
  public void arcadeDrive(double speed, double rotation){
    drive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
