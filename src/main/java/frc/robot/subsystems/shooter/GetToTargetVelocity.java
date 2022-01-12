package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.limelight.LimelightSubsystem;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSub shooterSubsystem;
  private LimelightSubsystem limelight;
  private double kF;

  private double targetRPM;
  private double steadyLoops = 0;
  private boolean stable = true;

  public GetToTargetVelocity(ShooterSub shooter, LimelightSubsystem limelight, double targetRPM) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelight = limelight;
    this.targetRPM = targetRPM;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "ramping up");
      shooter.setkF(shooter.lookUpkF(targetRPM));
      
      double kP = 0;
      double kI = 0;
      double kD = 0;
      // double[] gains = dashboard.getRampingGains();
      shooter.setPIDF(kP, kI, kD, shooter.getkF());
      shooter.setTargetRawSpeed(targetRPM);
      // shooter.setControlMethod(ControlMethod.SPIN_UP);
  }

  @Override
  public void execute() {
    shooterSubsystem.getShooterTalon().set(ControlMode.Velocity, targetRPM);
  }

  @Override
  public void end(boolean interrupted) {
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
