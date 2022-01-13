  // Copyright (c) FIRST and other WPILib contributors.
  // Open Source Software; you can modify and/or share it under the terms of
  // the WPILib BSD license file in the root directory of this project.

  package frc.robot.subsystems.limitswitch;

  import com.ctre.phoenix.motorcontrol.can.TalonFX;

<<<<<<< HEAD
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
        return getForwardLimitSwitch;
    }

    public DigitalInput getReverseLimitSwitch(){
        return getReverseLimitSwitch;
    }
}
=======
  import edu.wpi.first.wpilibj2.command.CommandBase;
  import frc.robot.drivebase.DriveBaseSub;


  //telebop
  //telebop
  //telebop 

  public class LimitswitchSubystem extends CommandBase {

    private double power;
    /** Creates a new limitSwitch. */
    public LimitswitchSubystem(double power) {
      this.power = power;
      
      // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      //this is the power they told me to use
      if (power > 0.4) {
        DriveBaseSub.setPower(0.4);
      } else {
        DriveBaseSub.setPower(power);
      }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }
>>>>>>> c993bde23d0a35d6697bf43578e8b9c5a15cb603
