// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.limitswitch;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.drivebase.DriveBaseSub;

  public class LimitswitchSubsystem extends SubsystemBase{
    DigitalInput forwardLimitSwitch, reverseLimitSwitch;


    public LimitswitchSubsystem(){
        DigitalInput forwardLimitSwitch = new DigitalInput(1);
        DigitalInput reverseLimitSwitch = new DigitalInput(2);
    }

    public void periodic()
    {
        forwardLimitSwitch.get();
    }

    public DigitalInput getForwardLimitSwitch() {
        return forwardLimitSwitch;
    }

    public DigitalInput getReverseLimitSwitch(){
        return reverseLimitSwitch;
    }
}
