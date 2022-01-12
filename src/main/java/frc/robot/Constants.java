// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // enums are a data structure primarilly used for constants
    public static enum CanIds {
        
        //to add a motor's can id: motorName(canId),
        // motor1(5),
        // motor2(3),
        // motorX(x)...

        cameraServo(1), // fix this

        // 2020 robot constants
        leftFalcon1(5),
        rightFalcon1(2),
        leftFalcon2(4),
        rightFalcon2(3),
        loaderFalcon(10),
        intakeVictor(11),
        revolverVictor(12),
        climberFalcon(13),
        shooterFalcon(14), 
        hoodVictor(40), 
        ;

        public final int id;

        private CanIds(int id) {
            this.id = id;
        }

    }

    public static class LimelightConstants {
        public static double kTargetHeight = 2.6416;
        public static double kCameraHeight = 0.8128;
        public static double theta = 30.0;
        public static double m = 1.0;
        public static double n = 0.48;
        public static double r1 = 0.37;
        public static double g = -9.8;

        public static double d = (kTargetHeight-kCameraHeight)/Math.tan(Math.toRadians(theta));
        public static double b = ((kTargetHeight-kCameraHeight)*((-Math.pow(d,2)*n)-(2*d*m*r1)+(Math.pow(m,2)*Math.pow(r1,2))))
                                /((d*m*r1)*((m*r1)-d));
        public static double a = (((kTargetHeight-kCameraHeight)*(1+n))-(b*(d-(m*r1))))/(Math.pow((d-(m*r1)),2));
        public static double alpha = Math.atan((b-Math.tan(Math.toRadians(theta)))/(1+(b*Math.tan(Math.toRadians(theta)))));

        public final double val;
        private LimelightConstants(double val) {
            this.val = val;
        }

    }

    public static double[][] kSpeedToFf = {
        {1000, .09},
        {2000, .065},
        {3000, .0575},
        {4000, .0545},
        {5000, .0525},
        {6000, .051},
        {7000, .0505},
        {8000, .0495},
        {9000, .049},
        {10000, .0485},
        {11000, .0482},
        {12000, .0478},
        {13000, .0475},
        {14000, .0474},
        {15000, .0474},
        {16000, .0474},
        {17000, .0472},
        {18000, .047},
        {19000, .047},
        {20000, .047},
        {21000, .0472},
        {22000, .0472},
    };           
    

}
