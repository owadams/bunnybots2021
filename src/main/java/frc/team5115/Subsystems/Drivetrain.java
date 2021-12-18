package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Robot.RobotContainer;

import static frc.team5115.Constants.*;

public class Drivetrain extends SubsystemBase{

    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    private double throttle;
    private boolean turbomode; 

    private double frontLeftSpeed;
    private double frontRightSpeed;
    private double backLeftSpeed;
    private double backRightSpeed;

    private double rightSpd;
    private double leftSpd;


    public Drivetrain(RobotContainer x) {
        turbomode = true; 
        throttle = 0.5;

        frontLeft = new TalonSRX(FRONT_LEFT_MOTOR_ID);
        frontRight = new TalonSRX(FRONT_RIGHT_MOTOR_ID);
        backLeft = new TalonSRX(BACK_LEFT_MOTOR_ID);
        backRight = new TalonSRX(BACK_RIGHT_MOTOR_ID);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    }

    public void stop() {
        TankDrive(0, 0, 0);
    }

    public void TankDrive(double x, double y, double throttle) { 
        leftSpd = (x-y) * throttle;
        rightSpd = (x+y) * throttle;

        frontLeft.set(ControlMode.PercentOutput, leftSpd);
        frontRight.set(ControlMode.PercentOutput, rightSpd);
        //backLeft.set(ControlMode.PercentOutput, leftSpd);
        //backRight.set(ControlMode.PercentOutput, rightSpd);
    }
    public void MecanumSimpleDrive(double y, double x, double z) {
        frontLeftSpeed = (-x + y + z);
        backLeftSpeed = (-x + y - z);
        frontRightSpeed = (x +  y + z);
        backRightSpeed = (x + y - z);
       /*
        frontLeftSpeed = (-y + x + z);
        backLeftSpeed = (-y + x - z);
        frontRightSpeed = (y +  x + z);
        backRightSpeed = (y + x - z);  */

            frontLeft.set(ControlMode.PercentOutput, frontLeftSpeed*throttle);
            frontRight.set(ControlMode.PercentOutput, frontRightSpeed*throttle);
            backLeft.set(ControlMode.PercentOutput, backLeftSpeed*throttle);
            backRight.set(ControlMode.PercentOutput, backRightSpeed*throttle);
        
    }

    public void autodrive(){
        System.out.println("STARTING AUTO DRIVE");
        frontLeft.set(ControlMode.PercentOutput, 0.14);
        frontRight.set(ControlMode.PercentOutput, -0.14);
        backLeft.set(ControlMode.PercentOutput, 0.14);
        backRight.set(ControlMode.PercentOutput, -0.14);
    }

    public void turnOnTurbo(){
        turbomode = true;
        throttle = 1;
    }
    public void turnOffTubo(){
        turbomode = false;
        throttle = 0.5;
        System.out.println("turbo mode off");
    }

    
}


