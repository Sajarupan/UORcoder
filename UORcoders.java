import robocode.*;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import robocode.ScannedRobotEvent;
import java.awt.*;

public class UORcoders extends CharlieBot
{
	boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move
	int dist = 80;
	int turnCounter;
	int turnDirection = 1;
	double degree;
	boolean movingForward;
	public void run() {
		// Set colors
		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.orange);
		setBulletColor(Color.cyan);
		setScanColor(Color.cyan);
		
		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		// Initialize peek to false
		peek = false;
		while (true)  {
			turnGunRight(10);
		}

	}

	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(10000);
		} // else he's in back of us, so set ahead a bit.
		else {
			ahead(10000);
		}
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(300);
		}
		if (e.isMyFault()) {
			turnRight(10);
		}
	}

	public void onRobotDetected(ScannedRobotEvent e)
	 {
		
		if (e.getDistance() < 200 && getEnergy() > 100) {
			fire(3000);
			turnRight(10);
		} 
		else {
			fire(1000);
			back(10000);
		}
		scan();
	}
	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

		ahead(dist);
		dist *= -1;
		scan();
	}

	public void onHitRobot1(HitRobotEvent e) {
        double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());

        turnGunRight(turnGunAmt);
        fire(30);
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} 
		else {
			ahead(100);
    	}

	}
	
	
}