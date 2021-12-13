package frc.team5115.Subsystems;

import static frc.team5115.Constants.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/Servo.html

import edu.wpi.first.wpilibj.DigitalInput;

public class BunnyManipulator {
   private TalonSRX bunnyMotor; 
   public static DigitalInput topLimit;
   public static DigitalInput bottomLimit;

    public BunnyManipulator(){
        bunnyMotor = new TalonSRX(BUNNY_MOTOR_ID);
        topLimit = new DigitalInput(0);
        bottomLimit = new DigitalInput(1);
    }

    public void moveforward(){
        bunnyMotor.set(ControlMode.PercentOutput, .05);
        System.out.println("rotating");
    }

    public void moveBackward(){
        bunnyMotor.set(ControlMode.PercentOutput, -.05);
    }

    public void rotateClockwise(){
        if (topLimit.get())
        {
            bunnyMotor.set(ControlMode.PercentOutput, 0);
            System.out.println("top switch on");
        }
        else{
            bunnyMotor.set(ControlMode.PercentOutput, .05);
        //System.out.println("rotating");}
    }
}

    public void rotateCounter(){
        if (bottomLimit.get())
        {
            bunnyMotor.set(ControlMode.PercentOutput, 0);
            System.out.println("bottom switch on");
        }
        else{
            bunnyMotor.set(ControlMode.PercentOutput, .05);
            System.out.println("rotating the otherway");
        }
        
    }

    public void stop(){
        bunnyMotor.set(ControlMode.PercentOutput, 0);
    }

}


