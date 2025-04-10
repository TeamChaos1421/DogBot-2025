package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.deploy.animations;
import frc.robot.Subsystems.Leds;

public class LedCommand extends Command{
    private Leds sLeds;
    private int[][][] sAnimation;
    private Timer sTimer = new Timer();
    private int frameCount = 0;

    public LedCommand(Leds sLeds, int[][][] sAnimation) {
        this.sLeds = sLeds;
        this.sAnimation = sAnimation;
        addRequirements(sLeds);
    };

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }

    @Override
    public void initialize() {
        sTimer.reset();
        sTimer.start();
    }

    @Override
    public void execute() {
        if (sTimer.get() - Math.floor(sTimer.get()) > 0.5) {
            if(DriverStation.isDSAttached() == false) {
                sLeds.setFrame(animations.noComs[frameCount % animations.noComs.length]);
            } else {
                sLeds.setFrame(sAnimation[frameCount % sAnimation.length]);
            }
            frameCount++;
            sTimer.restart();
        }
    }
}
