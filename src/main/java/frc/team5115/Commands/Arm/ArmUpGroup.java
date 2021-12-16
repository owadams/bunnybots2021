package frc.team5115.Commands.Arm;
import frc.team5115.Subsystems.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ArmUpGroup extends SequentialCommandGroup{
    private final Arm arm;

    public ArmUpGroup(Arm bunny) {
        arm = bunny;
        addCommands(
            new RaceGroup(arm),
            new Idle(arm));
    }
}
