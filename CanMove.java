package br.com.fiap.pacman;

public abstract class CanMove extends GameObject {
	public CanMove(int posX, int posY) {
		super(posX, posY);
	}
	
	public boolean isMoving() {
		return false;
	}
}