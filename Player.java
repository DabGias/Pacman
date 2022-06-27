package br.com.fiap.pacman;

public class Player extends CanMove {
	private int life;
	private int direction;
	private boolean invencible;
	
	public Player(int posX, int posY, int direction) {
		super(posX, posY);
		setDirection(direction);
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

	public void setDirection(int direction) {
		if (direction == 0 || direction == 90 || direction == 180 || direction == 270) this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getLife() {
		return life;
	}
	
	public boolean isInvencible() {
		return invencible;
	}
	
	public void setInvencible(boolean invencible) {
		this.invencible = invencible;
	}
}