package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.DigitalInput;


public class Arm extends SubsystemBase {
    TalonSRX arm;
   // public static DigitalInput outLimit;
   // public static DigitalInput inLimit;

    public Arm(){
        arm = new TalonSRX(BUNNY_MOTOR_ID);
      //  outLimit = new DigitalInput(1);
      //  inLimit = new DigitalInput(0);
    }

    public void moveUp(){
        arm.set(ControlMode.PercentOutput, .5);
        System.out.println("moving up!!");
        
    }

    public void stop() {
        arm.set(ControlMode.PercentOutput, 0);
    }
/*
    public void upLimit(){
        if (outLimit.get())
        {
            arm.set(ControlMode.PercentOutput, 0);
            System.out.println("top switch on");
        }
        else{
            arm.set(ControlMode.PercentOutput, .25);
        //System.out.println("rotating");}
    }
}

    public void downLimit(){
        if (inLimit.get())
        {
            arm.set(ControlMode.PercentOutput, 0);
            System.out.println("bottom switch on");
        }
        else{
            arm.set(ControlMode.PercentOutput, -.25);
        //System.out.println("rotating");}
    }

    }
*/
    public void moveDown(){
        arm.set(ControlMode.PercentOutput, -1);
        System.out.println("moving down!!");
    }
}



