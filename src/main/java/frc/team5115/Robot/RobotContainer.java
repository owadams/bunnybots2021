package frc.team5115.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.team5115.Commands.Auto.DriveForward;
import frc.team5115.Subsystems.*;
import static frc.team5115.Constants.*;
import frc.team5115.Robot.*;

public class RobotContainer {

    public Drivetrain drivetrain;
    public final BunnyManipulator bunny = new BunnyManipulator();
    public final DriveForward DriveForward = new DriveForward(drivetrain);
    public final Joystick joy = new Joystick(0);
    public final Arm arm = new Arm();


    public RobotContainer() {
        drivetrain = new Drivetrain(this);
        configureButtonBindings();
    }

    private void configureButtonBindings() {
       // new JoystickButton( joy, BUNNY_UP_BUTTON_ID).whileHeld(new InstantCommand(bunny::moveforward)).whenReleased(new InstantCommand(bunny::stop));
       // new JoystickButton(joy, BUNNY_DOWN_BUTTON_ID).whileHeld(new InstantCommand(bunny::moveBackward)).whenReleased(new InstantCommand(bunny::stop));

       new JoystickButton( joy, BUNNY_UP_BUTTON_ID).whileHeld(new InstantCommand(arm::moveUp)).whenReleased(new InstantCommand(arm::stop));
       new JoystickButton( joy, BUNNY_DOWN_BUTTON_ID).whileHeld(new InstantCommand(arm::moveDown)).whenReleased(new InstantCommand(arm::stop));
  
       //drivetrain.setDefaultCommand(new driveDefaultCommand(drivetrain, joy).perpetually());

    }

   static class driveDefaultCommand extends CommandBase {
        Drivetrain drivetrain;
        Joystick joy;

        public driveDefaultCommand(Drivetrain drivetrain, Joystick joystick) {
            addRequirements(drivetrain);
            this.drivetrain = drivetrain;
            joy = joystick;
        }

        @Override
        public void execute() {
            if(MECANUM){
                drivetrain.MecanumSimpleDrive(joy.getRawAxis(JOY_X_AXIS_ID), joy.getRawAxis(JOY_Y_AXIS_ID), joy.getRawAxis(JOY_Z_AXIS_ID));
            }
            else{
                drivetrain.TankDrive(joy.getRawAxis(PILOT_X_AXIS_ID), joy.getRawAxis(PILOT_Y_AXIS_ID),1);
            }
        }
    }

    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return DriveForward;
    }
    public void startTeleop(){
            System.out.println("Starting teleop");
        }

}