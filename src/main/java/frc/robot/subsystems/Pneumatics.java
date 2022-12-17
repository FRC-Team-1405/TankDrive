// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private DoubleSolenoid buzzer = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  private DoubleSolenoid piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  private int counter = 10;
  /** Creates a new Pneumantics. */
  public Pneumatics() {
    piston.set(Value.kOff);
    buzzer.set(Value.kOff);
  }
  public void pistonOut(){
    piston.set(Value.kForward);

  }
  public void pistonIn(){
    piston.set(Value.kReverse);
  }
  public void buzzerOn(){
    buzzer.set(Value.kForward);
    }
  public void buzzerOff(){
    buzzer.set(Value.kOff);
  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
