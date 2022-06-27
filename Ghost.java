package br.com.fiap.pacman;
import java.lang.Math;

public class Ghost extends CanMove {
	private int direction;
	private double random;
	
	public Ghost(int posX, int posY, int direction) {
		super(posX, posY);
		setDirection(direction);
	}
	
	public void randomDirection() {
		random = Math.random();
		
		if (random < 0.25) {
			setDirection(0);
		}
		
		if (random > 0.25 && random < 0.5) {
			setDirection(90);
		}
		
		if (random > 0.5 && random < 0.75) {
			setDirection(180);
		}
		
		if (random > 0.75) {
			setDirection(270);
		}
	}
	
	@Override
	public boolean isMoving() {
		if (getY() - 1 < 0 && getDirection() == 0) {
			return false;
		}
		
		if (getX() + 1 > getScreenSize() && getDirection() == 90) {
			return false;
		}
		
		if (getY() + 1 > getScreenSize() && getDirection() == 180) {
			return false;
		}
			 
		if (getX() - 1 < 0 && getDirection() == 270) {
			return false;
		}
		
		return true;
	}
	
	public void moving() {
		if (isMoving() == true) {
			if (getDirection() == 0) {
				setY(getY() - 50);
			}
				
			if (getDirection() == 90) {
				setX(getX() + 50);
			}
				
			if (getDirection() == 180) {
				setY(getY() + 50);
			}
				
			if (getDirection() == 270) {
				setX(getX() - 50);
			}
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		if (direction == 0 || direction == 90 || direction == 180 || direction == 270) this.direction = direction;
	}
	
	public double getRandom() {
		return random;
	}
}