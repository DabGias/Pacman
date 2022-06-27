package br.com.fiap.pacman;

public class Item extends GameObject {
	private boolean visible;
	
	public Item(int posX, int posY) {
		super(posX, posY);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}