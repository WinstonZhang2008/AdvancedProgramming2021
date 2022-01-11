// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.limelight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  // set up a new instance of NetworkTables (the api/library used to read values from limelight)
  private NetworkTable networkTable;
  
  // return network table values for tx and ty using getEntry()
  private NetworkTableEntry tv;
  private NetworkTableEntry tx;
  private NetworkTableEntry ty;
  // private NetworkTableEntry ta;
  // private NetworkTableEntry ts;

  public LimelightSubsystem() {
    this.networkTable = NetworkTableInstance.getDefault().getTable("limelight");
    this.tv = this.networkTable.getEntry("tv"); // Whether the limelight has any valid targets (0 or 1)
    this.tx = this.networkTable.getEntry("tx"); // Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
    this.ty = networkTable.getEntry("ty"); // Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
    // this.ta = this.networkTable.getEntry("ta"); // Target Area (0% of image to 100% of image)
    // this.ts = this.networkTable.getEntry("ts"); // Skew or rotation (-90 degrees to 0 degrees)
  }


  @Override
  public void periodic() {
    // write tx/ty values onto the smart dashboard
    SmartDashboard.putNumber("tv:", getTv());
    SmartDashboard.putNumber("tx:", getTx());
    SmartDashboard.putNumber("ty:", getTy());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // create accessor methods to reference values outside of this class
  public double getTv() {
    return this.tv.getDouble(0.0);
  }
  public double getTx() {
    return tx.getDouble(0.00);
  }

  public double getTy() {
    return ty.getDouble(0.00);
  }
   

  /**
   * set limelight led state
   * @param state Integer with value of 0, 1, 2, or 3
   * <ul>
   * <li>0: use the LED Mode set in the current pipeline</li>
   * <li>1: force off</li>
   * <li>2: force blink</li>
   * <li>3: force on</li>
   * </ul>
   */
  public void setLED(int state) {
    this.networkTable.getEntry("ledMode").setNumber(state);
  }


}
