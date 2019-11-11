package brick;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.Timer;
import javax.swing.JPanel;
import MovementModule.*;

public class Gameplay extends JPanel implements IUpdate, KeyListener, ActionListener {

	private boolean play;
	private int score;
	private int totalBricks;
	private Timer timer;
	private int delay = 8;

	private ArrayList<Player> players;
	private ArrayList<Ball> balls;
	private ArrayList<Gameobject> gameobjects; // players and balls

	private MapGenerator mapGen;

	public static IntVector2 baseSpeed = new IntVector2(1, 1);

	// Window dimensions
	public static IntVector2 dim = new IntVector2(1500, 800);

	public static int quit = 0;

	// =====================================================================================================

	public Gameplay() {
		reset();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public List<Ball> getBalls() {
		return Collections.unmodifiableList(balls);
	}

	public List<Gameobject> getGameobjects() {
		return Collections.unmodifiableList(gameobjects);
	}

	public MapGenerator getMapGen() {
		return mapGen;
	}

	public void addScore(int s) {
		score += s;
	}

	public void decrementBricks() {
		totalBricks--;
	}

	public void reset() {

		// Generate map
		IntVector2 rowsAndColumns = new IntVector2(15, 7);
		IntVector2 brickDimensions = new IntVector2(1300 / rowsAndColumns.y, 550 / rowsAndColumns.x);
		IntVector2 upperLeftCorner = new IntVector2(80, 50);
		mapGen = new MapGenerator(rowsAndColumns, brickDimensions, upperLeftCorner);
		System.out.println("Generating map");

		
		// Initialize players
		Player player1 = new Player(this);
		Player player2 = new Player(this);
		player1.position = new IntVector2(310, dim.y - 50);
		player2.position = new IntVector2(910, dim.y - 50);
		player1.movementModule = new KeyboardMovementModule(player1, KeyEvent.VK_A, KeyEvent.VK_D, 500);
		player2.movementModule = new KeyboardMovementModule(player2, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, 500);
		players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);


		// Initialize balls
		Ball ball1 = new Ball(this);
		Ball ball2 = new Ball(this);
		ball1.position = new IntVector2(350, dim.y - 150);
		ball2.position = new IntVector2(950, dim.y - 150);
		BallMovementModule bm1 = new BallMovementModule(ball1);
		BallMovementModule bm2 = new BallMovementModule(ball2);
		bm1.direction = new IntVector2(-1, -2);
		bm2.direction = new IntVector2(-1, -2);
		bm1.baseSpeed = baseSpeed;
		bm2.baseSpeed = baseSpeed;
		ball1.movementModule = bm1;
		ball2.movementModule = bm2;
		balls = new ArrayList<Ball>();
		balls.add(ball1);
		balls.add(ball2);


		// Initialize gameobjects
		gameobjects = new ArrayList<Gameobject>();
		players.forEach(gameobjects::add);
		balls.forEach(gameobjects::add);

		play = true;
		score = 0;
		totalBricks = 105;
	}

	public void paint(Graphics g) {
		// for the background
		g.setColor(Color.black);
		g.fillRect(0, 0, dim.x, dim.y);

		// for drawing map tiles
		mapGen.draw((Graphics2D) g);

		// game title
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("Beta Version 0.2", 10, 30);

		// for the borders
		g.setColor(Color.green);
		g.fillRect(0, 0, 3, dim.y);
		g.fillRect(0, 0, dim.x, 3);
		g.fillRect(dim.x - 8, 0, 3, dim.y);

		// for displaying the score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("ego size: " + score, dim.x - 200, 30);

		// for players and balls
		gameobjects.forEach(go -> go.paint(g));

		// Check if all bricks are destroyed
		checkWin(g);

		// Check if ball dropped
		checkGameOver(g);

		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();

		if (play) {
			float deltaTime = timer.getDelay() / 1000.0f;
			update(deltaTime);
		}

		repaint();
	}

	private void checkWin(Graphics g) {
		// if and when game is finished/won
		if (totalBricks == 0) {
			stopGame();

			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Congrats. Press Enter to Restart", 230, 350);

		}
	}

	private void checkGameOver(Graphics g) {
		// if and when game is over a ball is dropped
		boolean outOfBounds = Any(balls, ball -> ball.position.y > 765);

		if (outOfBounds) {
			stopGame();

			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Game Over, Score: " + score, 625, 350);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 640, 400);
		}
	}

	/**
	 * Check if any elements satisfy a condition
	 * @param list
	 * @param func
	 * @return true if 
	 */
	private <T> boolean Any(List<T> list, Predicate<T> func) {
		for(T obj : list) {
			if(func.test(obj)) {
				return true;
			}
		}
		return false;
	}

	private void stopGame() {
		play = false;
		balls.forEach(ball -> ball.movementModule.direction.resetToZero());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gameobjects.forEach(go -> go.keyPressed(e));

		// restarting the game by pressing enter
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				reset();
				repaint();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}

		System.out.print("x");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gameobjects.forEach(go -> go.keyReleased(e));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		gameobjects.forEach(go -> go.keyTyped(e));
	}

	@Override
	public void update(float deltaTime) {
		gameobjects.forEach(go -> go.update(deltaTime));
	}

}
