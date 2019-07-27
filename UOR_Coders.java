
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * ASD - a robot by (your name here)
 */
public class UORcoder extends AlphaBot
{
	/**
	 * run: ASD's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public double getDistance()	
	{
		return 2.0;
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		if (getDistance() <100)
		{
			fire(3);
		}
		else
		{
			fire(1);
		}
		
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent event) {
		// Replace the next line with any behavior you would like
		out.println("Ouch, I hit a wall bearing "+event.getBearing()+"degrees.");
		back(20);
	}	
	public void setColors(Color bodyColor,
                      Color gunColor,
                      Color radarColor){}
				                      
}
