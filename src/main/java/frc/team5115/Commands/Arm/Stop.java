package frc.team5115.Commands.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team5115.Subsystems.*;

public class Stop extends CommandBase{
    private final Arm arm;

    public Stop(Arm bunny) {
        arm = bunny;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(arm);
    }

    public void initialize() {
        arm.stop();
      }
    
    public boolean isFinished() {
        return false;
      }

}
