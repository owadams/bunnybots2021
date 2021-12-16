package frc.team5115.Commands.Arm;
import frc.team5115.Subsystems.*;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class RaceGroup extends ParallelRaceGroup{
    private final Arm arm;
    double waittime = 1.3;

    public RaceGroup(Arm bunny){
        arm = bunny;

        addCommands(
            new RaceGroup(arm),
            new Idle(arm));
    }

}