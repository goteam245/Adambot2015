package Drive;


import edu.wpi.first.wpilibj.Gyro;
public class Drive {
	/**
	 * PRIMARILY FOR AUTON
	 * @param speeds gives the speeds to each motor in order, LF, RF, LR, RR
	 */
	

	
		public static double rightFrontSpeed;
		public static double rightRearSpeed;
		public static double leftFrontSpeed;
		public static double leftRearSpeed;
		public static Gyro gyro;
		
		Drive.update();
		public static void init(){
			
		}
		
		public static void drive(double rightXAxis, double leftXAxis, double leftYAxis){		
			calcMecanumRawSpeeds(rightXAxis, leftXAxis, leftYAxis);
		}
		
		private static void calcMecanumRawSpeeds(double rightXAxis, double leftXAxis, double leftYAxis ){
			rightFrontSpeed = leftYAxis - rightXAxis - leftXAxis;
	        rightRearSpeed = leftYAxis - rightXAxis + leftXAxis;
	        leftFrontSpeed = leftYAxis + rightXAxis + leftXAxis;
	        leftRearSpeed = leftYAxis + rightXAxis - leftXAxis;        
	        rightFrontSpeed = restrict(rightFrontSpeed);
	        rightRearSpeed = restrict(rightRearSpeed);
	        leftFrontSpeed = restrict(leftFrontSpeed);
	        leftRearSpeed = restrict(leftRearSpeed);
	        leftFrontSpeed = -leftFrontSpeed;
	        leftRearSpeed = -leftRearSpeed;
			
		}
		
		private static void gyroComp(){
			
		}
		
		
		public static double restrict(double x){
	    	return Math.max(Math.min(1, x), -1);
	    }
		
		public static void initGyro(){
			gyro.initGyro();
			gyro.reset();
		}
	

	public static void DriveSpeed(double[] speeds){
		//does any needed adjustments then sets motor values
		//first change
	}
	/**
	 * 
	 * @param input joystick values in order: LX, LY, RY
	 */
	public static void DriveControls(double[]input){
		
	}
}
