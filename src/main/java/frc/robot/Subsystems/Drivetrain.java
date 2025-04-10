package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final TalonSRX frontright = new TalonSRX(18);
    private final TalonSRX backright = new TalonSRX(13);
    private final TalonSRX backleft = new TalonSRX(17);
    private final TalonSRX frontleft = new TalonSRX(15);

    public Drivetrain () {
        frontright.setInverted(false);
        backright.setInverted(true);
        backleft.setInverted(false);
        frontleft.setInverted(true);
    }

    public void driveMecanum( double xIn, double yIn, double rotIn) {
        double xSpeed = 0;
        double ySpeed = 0;
        double rotSpeed = 0;

        if (Math.abs(xIn) >= 0.1) {
            xSpeed = Math.pow(xIn, 3);
        }
        if (Math.abs(yIn) >= 0.1) {
            ySpeed = Math.pow(yIn, 3);
        }
        if (Math.abs(rotIn) >= 0.1) {
            rotSpeed = Math.pow(rotIn, 3);
        }

        frontright.set(TalonSRXControlMode.PercentOutput, xSpeed + ySpeed + rotSpeed);
        backright.set(TalonSRXControlMode.PercentOutput, xSpeed + ySpeed - rotSpeed);
        backleft.set(TalonSRXControlMode.PercentOutput, xSpeed - ySpeed + rotSpeed);
        frontleft.set(TalonSRXControlMode.PercentOutput, xSpeed - ySpeed - rotSpeed);
    }
}
