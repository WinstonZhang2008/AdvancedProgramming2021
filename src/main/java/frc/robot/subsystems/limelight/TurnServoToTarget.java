// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PaddedXbox;
import frc.robot.subsystems.limelight.LimelightSubsystem;

public class TurnServoToTarget extends CommandBase {

  private LimelightSubsystem limesub;
  private PaddedXbox xbox;

  /** Creates a new TurnServoToTarget. */
  public TurnServoToTarget(PaddedXbox xbox, LimelightSubsystem limesub) {
    this.limesub = limesub;
    this.xbox = xbox;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limesub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // turn on LED
    this.limesub.setLED(3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (this.xbox.getXButtonPressed()) {
      double offset = this.limesub.getTx();
      this.limesub.setServoAngle(limesub.getServoAngle() + offset); // try -offset if opposite
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Turn off
    this.limesub.setLED(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return false;
    return this.limesub.getTx() == 0; //might be too strict
  }

}
