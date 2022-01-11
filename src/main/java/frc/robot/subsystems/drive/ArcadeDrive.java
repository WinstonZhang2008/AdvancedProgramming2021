package frc.robot.subsystems.drive;

import frc.robot.PaddedXbox;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Reusable arcade command
 */
public class ArcadeDrive extends CommandBase {

  private DriveBaseSubsystem driveBase;
  private double kStraight;
  private double kTurn;
  private double kSlowStraight;
  private double kSlowTurn;
  private PaddedXbox joystick;

  
  // public ArcadeDrive(PaddedXbox joystick, DriveBaseSubsystem driveBase, double kStraight, double kTurn, double kSlowStraight, double kSlowTurn){
  public ArcadeDrive(PaddedXbox joystick, DriveBaseSubsystem driveBase){
    this.joystick = joystick;
    this.driveBase = driveBase;
    this.kStraight = 0.5;
    this.kTurn = 0.5;
    this.kSlowStraight = 0.5;
    this.kSlowTurn = 0.5;
    addRequirements(driveBase);
}

  @Override
  public void initialize() {
    driveBase.factoryResetAll();    
    driveBase.setAllDefaultInversions();
    driveBase.coast(); 
    SmartDashboard.putString("command status", "init arcade");
  }

  @Override
  public void execute() {

    SmartDashboard.putString("command status", "exec arcade");
    
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kSlowStraight * joystick.getRightY();
    double rightPower = -kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kSlowStraight * joystick.getRightY();

    // double leftX = joystick.getLeftX();

    // if(leftX > 0){
    //   rightPower -= kSlowTurn * leftX;
    // }
    // else if(leftX < 0){
    //   leftPower += kSlowTurn * leftX;
    // }
    // else{}

    driveBase.setLeftPower(leftPower);
    driveBase.setRightPower(rightPower);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

}
