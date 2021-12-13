package frc.team5115.Robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static frc.team5115.Constants.*;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Robot extends TimedRobot {
    private Command autoCommand;
    private RobotContainer robotContainer;

    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

   
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        frontLeft = new TalonSRX(FRONT_LEFT_MOTOR_ID);
        frontRight = new TalonSRX(FRONT_RIGHT_MOTOR_ID);
        backLeft = new TalonSRX(BACK_LEFT_MOTOR_ID);
        backRight = new TalonSRX(BACK_RIGHT_MOTOR_ID);
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
       autoCommand = robotContainer.getAutonomousCommand();
        
/*
        // schedule the autonomous command (example)
        if (autoCommand != null) {
            robotContainer.locationator.setAngleAndLocation(90, startingConfiguration.getX(), 30);
            autoCommand.schedule();
            System.out.println("Scheduling auto command");
        } else System.out.println("Boy you better fix this bitch-ass problem your auto code done broke you a little shit cuz you code sum dumb shit you dumbass it caint find no code.");
        //CommandScheduler.getInstance().enable();
    }
    */
}




        public void autonomousPeriodic() {
           robotContainer.getAutonomousCommand();
      
        }

        public void teleopInit () {
            
            if (autoCommand != null) {
                autoCommand.cancel();
            }

            robotContainer.startTeleop();
        }


        /**
         * This function is called periodically during operator control.
         */

        public void teleopPeriodic () {
        }


        public void testInit () {
            // Cancels all running commands at the start of test mode.
            CommandScheduler.getInstance().cancelAll();
        }

        /**
         * This function is called periodically during test mode.
         */

        public void testPeriodic () {
        }

        public void practiceInit(){
            if (autoCommand != null) {
                autoCommand.cancel();
            }

            robotContainer.startTeleop();
        }

        public void practicePeriodic(){}
    }
