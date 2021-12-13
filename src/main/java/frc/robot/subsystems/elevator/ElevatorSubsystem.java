package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

public class ElevatorSubsystem extends SubsystemBase{

    private TalonSRX elevatorTalon1;
    private TalonSRX elevatorTalon2;

    public ElevatorSubsystem(){
        elevatorTalon1 = new TalonSRX(CanIds.elevatorTalon1.id);
        elevatorTalon2 = new TalonSRX(CanIds.elevatorTalon2.id);
    }

    public void setPower(double power){
        elevatorTalon1.set(ControlMode.PercentOutput, power);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
}
