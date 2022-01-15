package frc.robot.subsystems.limitswitch;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.talon.TalonSubsystem;

public class RunMotorWithLimitSwitch extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private LimitswitchSubsystem limitswitchSubsystem;
  private TalonSubsystem talonSubsystem;

  public RunMotorWithLimitSwitch(LimitswitchSubsystem limitSwitchSubsystem, TalonSubsystem talonSubsystem) {
    this.limitswitchSubsystem = limitSwitchSubsystem;
    this.talonSubsystem= talonSubsystem;
    // uses addRequirements() instead of requires()
    addRequirements(limitswitchSubsystem, talonSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (limitswitchSubsystem.getLimitSwitch().get()){
      talonSubsystem.getTalon().setPower(0.2);
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
