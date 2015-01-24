
package org.usfirst.frc.team245.robot;

import Auton.AutonA;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

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
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	i=0;
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
