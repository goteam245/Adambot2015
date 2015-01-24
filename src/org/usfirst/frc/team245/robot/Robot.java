
package org.usfirst.frc.team245.robot;

import Auton.AutonA;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    CANTalon rightFrontDrive;
    CANTalon rightRearDrive;
	double rightFrontSpeed;
	double rightRearSpeed;
	    
	CANTalon leftFrontDrive;
	CANTalon leftRearDrive;
	double leftFrontSpeed;
	double leftRearSpeed;
    Joystick joy = new Joystick(1);
	public static Gyro gyro;
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	rightFrontDrive = new CANTalon(0); //temporary values until I/O finished
    	rightRearDrive = new CANTalon(1);
    	leftFrontDrive = new CANTalon(2);
    	leftRearDrive = new CANTalon(3); 
    	joy = new Joystick(1);

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	AutonA.update();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        try{
        	Teleop.doWerk();
        }
        catch(Exception e){
        	
        }

        	double channel2 = Gamepad.primary.getRightX();
        	double channel3 = -Gamepad.primary.getLeftY();
        	double channel4 = 0.75*Gamepad.primary.getLeftX();
        	//channel4*=3;
        	
        	//System.out.println(channel2);
        	SmartDashboard.putNumber("channel2", channel2);
        	SmartDashboard.putDouble("channel3", channel3);
        	SmartDashboard.putDouble("channel4", channel4);
        	SmartDashboard.putNumber("Gyro", gyro.getRate());
        	
        	//setting net direction of travel		
            rightFrontSpeed = channel3 - channel2 - channel4;
            rightRearSpeed = channel3 - channel2 + channel4;
            leftFrontSpeed = channel3 + channel2 + channel4;
            leftRearSpeed = channel3 + channel2 - channel4;
            SmartDashboard.putDouble("test", rightFrontSpeed);
            rightFrontSpeed = restrict(rightFrontSpeed);
            rightRearSpeed = restrict(rightRearSpeed);
            leftFrontSpeed = restrict(leftFrontSpeed);
            leftRearSpeed = restrict(leftRearSpeed);
            
        	rightFrontDrive.set(rightFrontSpeed);
            rightRearDrive.set(rightRearSpeed);
            leftFrontDrive.set(-leftFrontSpeed);
            leftRearDrive.set(-leftRearSpeed);
            
            
        }

    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    
    public double restrict(double x){
    	return Math.max(Math.min(1, x), -1);
    }
}
