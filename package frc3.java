package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

public class Robot extends TimedRobot {

    
    private PWMVictorSPX intakeMotor;
    private PWMVictorSPX feederMotor;
    private Joystick joystick;

   
    private DigitalInput intakeSensor;

    @Override
    public void robotInit() {
       
        intakeMotor = new PWMVictorSPX(0); 
        feederMotor = new PWMVictorSPX(1); 

        
        joystick = new Joystick(0);

        
        intakeSensor = new DigitalInput(0);
    }

    @Override
    public void teleopPeriodic() {
        intakingCommand();
    }

    public void intakingCommand() {
        boolean sensorState = intakeSensor.get(); 

        
        if (joystick.getRawButton(1)) { 
            if (!sensorState) { 
                intakeMotor.set(1.0); 
            } else {
                intakeMotor.set(0.0); 
            feederMotor.set(0.7);
        } else if (joystick.getRawButton(2)) { 
            intakeMotor.set(-1.0); 
            feederMotor.set(-0.7); 
            
            intakeMotor.set(0.0);
            feederMotor.set(0.0);
        }
    }
}
