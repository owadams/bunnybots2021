package frc.team5115.Commands.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.*;

public class MoveUp extends CommandBase{
    private final Arm arm;

    public MoveUp(Arm bunny) {
        arm = bunny;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(arm);
    }

    public void initialize() {
        arm.moveUp();
      }
    
    public boolean isFinished() {
        return false;
      }

}