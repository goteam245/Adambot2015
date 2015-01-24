package Interior;

public class Interior {
/**
*
* @param speed set the motor to this speed also do some current checking
*/

	public static void toggleRollers(int speed){ 
	
	}
	
	//sets the motor speeds of both arms
	public static void moveArm(double speed){
		
	}
	
	public static void toggleArm (boolean isCompressed) {
		//true = closed
		//false = open
		if (isCompressed) {
			//open Arms
		} else {
			//close Arms
		}
	}
	
	//clamps using the piston
	public static void toggleClamps(boolean isCompressed){
		//true = closed
		//false = open
		if (isCompressed) {
			//open clamps
		} else {
			//close clamps
		}
	}
	
	//releases the crates
	public static void release(){
		//need mechanism info
	}
	
	public static void liftAndLock () {
		//close arms
		//move arms up
		//close clamps
		//open arms
		//move arms down
	}
	
	public static void currentCheck () {
		
	}
	
}

