// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.limelight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  public LimelightSubsystem() {
  }

  // set up a new instance of NetworkTables (the api/library used to read values from limelight)
  NetworkTable networkTable = NetworkTableInstance.getDefault().getTable("limelight");
  
  // return network table values for tx and ty using getEntry()
  NetworkTableEntry tx = networkTable.getEntry("tx");
  NetworkTableEntry ty = networkTable.getEntry("ty");

  @Override
  public void periodic() {
    // write tx/ty values onto the smart dashboard
    SmartDashboard.putNumber("tx:", getTx());
    SmartDashboard.putNumber("ty:", getTy());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // create accessor methods to reference tx/ty values outside of this class
  public double getTx() {
    return tx.getDouble(0.00);
  }
  public double getTy() {
    return ty.getDouble(0.00);
  }

}
