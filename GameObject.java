package br.com.fiap.pacman;

public abstract class GameObject {
	private int posX;
	private int posY;
	private int SCREENSIZE;
	
	public GameObject(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setX(int posX) {
		this.posX = posX;
	}

	public int getX() {
		return posX;
	}
	
	public void setY(int posY) {
		this.posY = posY;
	}

	public int getY() {
		return posY;
	}

	public void setScreenSize(int screensize) {
		SCREENSIZE = screensize;
		
		if (getX() > SCREENSIZE) {
			setX(SCREENSIZE);
		}
		
		if (getY() > SCREENSIZE) {
			setY(SCREENSIZE);
		}
		
		if (getX() < 0) {
			setX(0);
		}
		
		if (getY() < 0) {
			setY(0);
		}
	}
	
	public int getScreenSize() {
		return SCREENSIZE;
	}
}