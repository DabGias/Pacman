package br.com.fiap.pacman;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.util.concurrent.ThreadLocalRandom;

public class Game extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
//	private int randomNumXBomb;
//	private int randomNumYBomb;
//	private int randomNumXBooster;
//	private int randomNumYBooster;
	private Player player = new Player(50, 50, 180);
	private Ghost ghost1 = new Ghost(0,0,0);
	private Ghost ghost2 = new Ghost(500,0,0);
	private Ghost ghost3 = new Ghost(0,500,0);
	private Ghost ghost4 = new Ghost(500,500,0);
	private Bomb bomb = new Bomb(100, 100);
	private Booster booster = new Booster(400, 400);

	private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
	private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
	private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

	private final int SCREENSIZE = 600;
	private int speed = 100;
	
	public static void main(String[] args) {
		new Game().init();
	}

	private void init() {
		setLayout(null);
		player.setScreenSize(SCREENSIZE);
		player.setLife(15);

		ghost1.setScreenSize(SCREENSIZE);
		ghost2.setScreenSize(SCREENSIZE);
		ghost3.setScreenSize(SCREENSIZE);
		ghost4.setScreenSize(SCREENSIZE);
		
		bomb.setVisible(true);
		booster.setVisible(true);
		
		add(imgPlayer);
		add(imgGhost1);
		add(imgGhost2);
		add(imgGhost3);
		add(imgGhost4);
		add(imgBomb);
		add(imgBooster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {
		
		updateLocation(imgPlayer, player);
		updateLocation(imgGhost1, ghost1);
		updateLocation(imgGhost2, ghost2);
		updateLocation(imgGhost3, ghost3);
		updateLocation(imgGhost4, ghost4);
		updateLocation(imgBomb, bomb);
		updateLocation(imgBooster, booster);
		setTitle("Life: " + player.getLife());
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void updateLocation(JLabel label, GameObject object) {
		label.setBounds(object.getX(), object.getY(), 50, 50);
		ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
        if (object instanceof Item) {
        	 Item item = (Item) object;
        	 label.setVisible(item.isVisible());
        }
	}

	private void run() {
		while (player.getLife() > 0) {
//			randomNumXBomb = ThreadLocalRandom.current().nextInt(1, 100 + 1);
//			randomNumYBomb = ThreadLocalRandom.current().nextInt(1, 100 + 1);
//			randomNumXBooster = ThreadLocalRandom.current().nextInt(1, 100 + 1);
//			randomNumYBooster = ThreadLocalRandom.current().nextInt(1, 100 + 1);
			
			player.isMoving();
			player.moving();
			
			ghost1.randomDirection();
			ghost1.isMoving();
			ghost1.moving();
			
			ghost2.randomDirection();
			ghost2.isMoving();
			ghost2.moving();
			
			ghost3.randomDirection();
			ghost3.isMoving();
			ghost3.moving();
			
			ghost4.randomDirection();
			ghost4.isMoving();
			ghost4.moving();
			
			if (ghost1.getX() == player.getX() && ghost1.getY() == player.getY() && player.isInvencible() == false) {
				player.setLife(player.getLife() - 1);
			}
			
			if (ghost2.getX() == player.getX() && ghost2.getY() == player.getY() && player.isInvencible() == false) {
				player.setLife(player.getLife() - 1);
			}

			if (ghost3.getX() == player.getX() && ghost3.getY() == player.getY() && player.isInvencible() == false) {
				player.setLife(player.getLife() - 1);
			}
			
			if (ghost4.getX() == player.getX() && ghost4.getY() == player.getY() && player.isInvencible() == false) {
				player.setLife(player.getLife() - 1);
			}
			
			if (bomb.getX() == player.getX() && bomb.getY() == player.getY() && bomb.isVisible() == true && player.isInvencible() == false) {
				player.setLife(player.getLife() - 1);
				bomb.setVisible(false);
			
				
//				if (randomNumXBomb < 20) bomb.setX(100);
//				if (randomNumXBomb > 20 && randomNumXBomb < 40) bomb.setX(200);
//				if (randomNumXBomb > 40 && randomNumXBomb < 60) bomb.setX(300);
//				if (randomNumXBomb > 60 && randomNumXBomb < 80) bomb.setX(400);
//				if (randomNumXBomb > 80) bomb.setX(500);
//				
//				if (randomNumYBomb < 20) bomb.setY(100);
//				if (randomNumYBomb > 20 && randomNumYBomb < 40) bomb.setY(200);
//				if (randomNumYBomb > 40 && randomNumYBomb < 60) bomb.setY(300);
//				if (randomNumYBomb > 60 && randomNumYBomb < 80) bomb.setY(400);
//				if (randomNumYBomb > 80) bomb.setY(500);
			}
			
			if (booster.getX() == player.getX() && booster.getY() == player.getY() && booster.isVisible() == true) {
				player.setInvencible(true);
				booster.setVisible(false);
				
//				if (randomNumXBooster < 20) booster.setX(100);
//				if (randomNumXBooster > 20 && randomNumXBooster < 40) booster.setX(200);
//				if (randomNumXBooster > 40 && randomNumXBooster < 60) booster.setX(300);
//				if (randomNumXBooster > 60 && randomNumXBooster < 80) booster.setX(400);
//				if (randomNumXBooster > 80) booster.setX(500);
//				
//				if (randomNumYBooster < 20) booster.setY(100);
//				if (randomNumYBooster > 20 && randomNumYBooster < 40) booster.setY(200);
//				if (randomNumYBooster > 40 && randomNumYBooster < 60) booster.setY(300);
//				if (randomNumYBooster > 60 && randomNumYBooster < 80) booster.setY(400);
//				if (randomNumYBooster > 80) booster.setY(500);
			}
			
			if (booster.getTurns() > 0 && player.isInvencible() == true) {
				booster.setTurns(booster.getTurns() - 1);
			}
			
			if (booster.getTurns() == 0) {
				player.setInvencible(false);
			}
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '8' || c == 'w') player.setDirection(0);	
		if (c == '6' || c == 'd') player.setDirection(90);	
		if (c == '2' || c == 's') player.setDirection(180);	
		if (c == '4' || c == 'a') player.setDirection(270);	
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}	
}