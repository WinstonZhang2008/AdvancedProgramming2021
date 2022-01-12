package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.team7419.TalonFuncs;
import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.*;
import frc.robot.subsystems.limelight.LimelightSubsystem;

public class ShooterSubsystem extends SubsystemBase{

    private TalonFX talon;
    private LimelightSubsystem limelight = new LimelightSubsystem();
    public double powerOutput = 0;
    public double kP = 0;
    public double kI = 0;
    public double kD = 0;
    public double kF = 0;
    public double targetVelocity = 0;
    public double target = 500;
    private double threshold = 200;
    public ControlMethod controlMethod = ControlMethod.PERCENT_OUTPUT;

    private double kCameraHeight = LimelightConstants.kCameraHeight;
    private double kTargetHeight = LimelightConstants.kTargetHeight;
    private double theta = limelight.getTheta();
    private double n = LimelightConstants.n;
    private double m = LimelightConstants.m;
    private double r1 = LimelightConstants.r1;
    private double g = LimelightConstants.g;
  
    private double d = (kTargetHeight-kCameraHeight)/Math.tan(Math.toRadians(theta));
    private double b = ((kTargetHeight-kCameraHeight)*((-Math.pow(d,2)*n)-(2*d*m*r1)+(Math.pow(m,2)*Math.pow(r1,2))))
                            /((d*m*r1)*((m*r1)-d));
    private double a = (((kTargetHeight-kCameraHeight)*(1+n))-(b*(d-(m*r1))))/(Math.pow((d-(m*r1)),2));
    private double alpha = Math.atan((b-Math.tan(Math.toRadians(theta)))/(1+(b*Math.tan(Math.toRadians(theta)))));
    private double beta = theta + alpha;
    private double v0 = Math.sqrt(g/(2*a*(Math.pow(Math.cos(Math.toRadians(beta)),2))));

    public ShooterSubsystem(){
        talon = new TalonFX(CanIds.shooterFalcon.id);
        talon.configFactoryDefault();
        talon.setInverted(true);
        talon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    }

    public enum ControlMethod{
        PERCENT_OUTPUT,
        SPIN_UP,
        HOLDING,
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("periodic speed", talon.getSelectedSensorVelocity());
    }

    public void run(){
        ControlMethod method = this.controlMethod;
        if(method == ControlMethod.PERCENT_OUTPUT){
            talon.set(ControlMode.PercentOutput, powerOutput);
        }
        else if(method == ControlMethod.HOLDING){
            talon.set(ControlMode.Velocity, target);
        }
        else if(method == ControlMethod.SPIN_UP){
            talon.set(ControlMode.Velocity, target);
        }

    }

    public void configureOutputs(){
        talon.configNominalOutputForward(0, 0);
		talon.configNominalOutputReverse(0, 0);
		talon.configPeakOutputForward(1, 0);
        talon.configPeakOutputReverse(-1, 0);
    }

    public void setPIDF(double kP, double kI, double kD, double kF){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
        TalonFuncs.setPIDFConstants(0, talon, kP, kI, kD, kF);
    }

    public boolean onTarget(){
        return Math.abs(this.getCurrentRawSpeed() - target) < threshold;
    }

    public void setOutputPower(double power){this.powerOutput = power;}

    public void setkF(double kF){this.kF = kF;}

    public double getOutputVoltage(){
        return talon.getMotorOutputVoltage();
    }

    public void setTargetRpm(double rpm){this.target = rpm * 1.7067;}

    public void setControlMethod(ControlMethod method){
        this.controlMethod = method;
        if(method == ControlMethod.HOLDING){
            setPIDF(0,0,0,kF);
        }
    }

    public double computekF(double nativeUnits){
        return 0; // insert regression model
    }

    public double getCurrentRawSpeed(){return talon.getSelectedSensorVelocity(0);}

    public void setTargetRawSpeed(double speed){this.target = speed;}

    public void percentOutput(){
        talon.set(ControlMode.PercentOutput,powerOutput);
    }

    public void off(){
        talon.set(ControlMode.PercentOutput, 0);
    }

    public double getkP(){return kP;}
    public double getkI(){return kI;}
    public double getkD(){return kD;}
    public double getkF(){return kF;}

    public double getD() {return d;}
    public double getA() {return a;}
    public double getAlpha() {return alpha;}
    public double getBeta() {return beta;}
    public double getV0() {return v0;}

    public TalonFX getShooterTalon() {return talon;}

}