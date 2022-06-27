package br.com.fiap.pacman;

public class Booster extends Item {
	private int turns = 50;
	
	public Booster(int posX, int posY) {
		super(posX, posY);
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}
}