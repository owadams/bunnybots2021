package frc.team5115.Robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team5115.Subsystems.*;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Robot extends TimedRobot {
    private Command autoCommand;
    private RobotContainer robotContainer;
    private Drivetrain drivetrain;



   
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        drivetrain = new Drivetrain(robotContainer);

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
     //  autoCommand = robotContainer.getAutonomousCommand();
        
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
      //  drivetrain.setDefaultCommand(new InstantCommand(drivetrain::autodrive)).perpetually());
           drivetrain.autodrive();
      
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
