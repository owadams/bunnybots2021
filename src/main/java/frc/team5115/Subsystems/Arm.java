package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;


public class Arm extends SubsystemBase {
    TalonSRX arm;
    double idleSpeed = .15;
    Timer timer = new Timer();
   // public static DigitalInput outLimit;
   // public static DigitalInput inLimit;

    public Arm(){
        arm = new TalonSRX(BUNNY_MOTOR_ID);
      //  outLimit = new DigitalInput(1);
      //  inLimit = new DigitalInput(0);
    }

    public void moveUp(){
       /* timer.start();
        if(timer.get() > 1.5){
            arm.set(ControlMode.PercentOutput, idleSpeed);
        System.out.println("idle");
        }*/
        arm.set(ControlMode.PercentOutput, 1);
        System.out.println("moving up!!");
        
    }

    public void idle(){
        arm.set(ControlMode.PercentOutput,idleSpeed); 
    }


    public void moveDown(){
        arm.set(ControlMode.PercentOutput, -0.3);
        System.out.println("moving down!!");
    }

    public void stop() {
        arm.set(ControlMode.PercentOutput, 0);
    }
/*
    public void moveUpWithLimit(){
        if (outLimit.get())
        {
            arm.set(ControlMode.PercentOutput, 0);
            System.out.println("top switch on");
        }
        else{
            arm.set(ControlMode.PercentOutput, .25);
        //System.out.println("moving up");}
    }
}

    public void moveDownWithLimit(){
        if (inLimit.get())
        {
            arm.set(ControlMode.PercentOutput, 0);
            System.out.println("bottom switch on");
        }
        else{
            arm.set(ControlMode.PercentOutput, -.25);
            System.out.println("moving down");}
    }

    }
*/
    
}



