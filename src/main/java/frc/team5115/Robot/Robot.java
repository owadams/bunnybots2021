package frc.team5115.Robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team5115.Subsystems.*;
import static frc.team5115.Constants.*;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
    private Command autoCommand;
    private RobotContainer robotContainer;
    private Drivetrain drivetrain;
    private Joystick joy;
   
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        drivetrain = new Drivetrain(robotContainer);
        joy = new Joystick(0);
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void autonomousInit() {}

    public void autonomousPeriodic() {
        drivetrain.autodrive();
    }

    public void teleopInit () {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
        robotContainer.startTeleop();
    }

    public void teleopPeriodic () {
        drivetrain.MecanumSimpleDrive(joy.getRawAxis(JOY_X_AXIS_ID), joy.getRawAxis(JOY_Y_AXIS_ID), joy.getRawAxis(JOY_Z_AXIS_ID));
    }


    public void testInit () {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    public void testPeriodic () {}

    public void practiceInit(){
        
        if (autoCommand != null) {
            autoCommand.cancel();
        }

        robotContainer.startTeleop();
    }

    public void practicePeriodic(){}
}
