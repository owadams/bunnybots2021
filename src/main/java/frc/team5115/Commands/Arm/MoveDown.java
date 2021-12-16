package frc.team5115.Commands.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.*;

public class MoveDown extends CommandBase{
    private final Arm arm;
    double speed = -0.45;

    public MoveDown(Arm bunny) {
        arm = bunny;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(arm);
    }

    public void initialize() {
        arm.moveDown();
      }
    
      public void execute() {
        arm.moveDown();
        speed = speed + 0.05;
      }
    
    public boolean isFinished() {
        if(speed == 0){
            return true;
        }
        else{
        return false;
      }
    }

}