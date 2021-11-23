// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ultrasonicSensor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UltrasonicDistanceSensorSubsystem extends SubsystemBase {

  protected PIDSubsystem pidSub;
  private Ultrasonic.Unit units;
  /** Creates a new ExampleSubsystem. */
  public UltrasonicDistanceSensorSubsystem(int pingChannel, int echoChannel) {}
  public UltrasonicDistanceSensorSubsystem(int pingChannel, int echoChannel, Ultrasonic.Unit units) {}
  public UltrasonicDistanceSensorSubsystem(DigitalOutput pingChannel, DigitalInput echoChannel) {}
  public UltrasonicDistanceSensorSubsystem(DigitalOutput pingChannel, DigitalInput echoChannel, Ultrasonic.Unit units) {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void close() {

  }

  public Ultrasonic.Unit getDistanceUnits() {
    return units;
  }

  
  public double	getRangeInches() {
    return 0;}	//Get the range in inches from the ultrasonic sensor.
  public double	getRangeMM() {
    return 0;}	//Get the range in millimeters from the ultrasonic sensor.
  public void	initSendable​(SendableBuilder builder) {}	//Initializes this Sendable object.
  public boolean	isEnabled() {
    return false;}	//Is the ultrasonic enabled.
  public boolean	isRangeValid() {
    return false;}	//Check if there is a valid range measurement.
  public double	pidGet() {
    return 0;}	//Get the range in the current DistanceUnit for the PIDSource base object.
  public void	ping() {}	//Single ping to ultrasonic sensor.
  public static void	setAutomaticMode​(boolean enabling) {}	//Turn Automatic mode on/off for all sensors.
  public void	setDistanceUnits​(Ultrasonic.Unit units) {}	//Set the current DistanceUnit that should be used for the PIDSource base object.
  public void	setEnabled​(boolean enable) {}	//Set if the ultrasonic is enabled.
  public void	setPIDSourceType​(PIDSubsystem pidSource) {}
  
}

