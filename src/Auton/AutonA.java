package Auton;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AutonA {
	private static double accelerationX;
	private static double accelerationY;
	private static double velocityX=0;
	private static double velocityY=0;
	private static double positionX=0;
	private static double positionY=0;
	private static Timer distanceTimer = new Timer();
	private static BuiltInAccelerometer a = new BuiltInAccelerometer();
	private static double time;
	double[] xPositions = {}; //different positions we have to reach
	double[] yPositions = {};
	double stage = 0;
	public static void update(){
		
	}
	public static void DFromA(){
		
		
			
			time = distanceTimer.get();
			positionX+=velocityX*time + (.5*a.getX()*Math.pow(time, 2));
			positionY+=velocityY*time + (.5*a.getY()*Math.pow(time, 2));
			velocityX+=a.getX()*time;
			velocityY+=a.getY()*time;
			
		
	}
}
