package brick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MapGenerator {

	private int map[][];
	private IntVector2 brickDim;
	private IntVector2 ULCorner;

	public MapGenerator(IntVector2 rowsAndColumns, IntVector2 brickDimensions, IntVector2 upperLeftCorner) {
		int row = rowsAndColumns.x;
		int col = rowsAndColumns.y;

		this.brickDim = brickDimensions;
		this.ULCorner = upperLeftCorner;

		map = new int[row][col];
		forEachBrick(c -> setBrickValue(1, c));
	}

	public void draw(Graphics2D g) {
		forEachBrick(c -> {
			if (getBrickValue(c) > 0) {
				Rectangle rect = getBrickRect(c);

				g.setColor(Color.blue);
				g.fill(rect);

				g.setStroke(new BasicStroke(3));
				g.setColor(Color.black);
				g.draw(rect);
			}
		});
	}

	public void setBrickValue(int value, IntVector2 coord) {
		map[coord.x][coord.y] = value;
	}

	public int getBrickValue(IntVector2 coord) {
		return map[coord.x][coord.y];
	}

	public IntVector2 getBrickDimensions() {
		return brickDim.copy();
	}

	public Rectangle getBrickRect(IntVector2 coord) {
		int brickX = coord.y * brickDim.x + ULCorner.x;
		int brickY = coord.x * brickDim.y + ULCorner.y;
		return new Rectangle(brickX, brickY, brickDim.x, brickDim.y);
	}

	/**
	 * Iterate through each brick until the condition is true
	 * 
	 * @param coord condition
	 */
	public IntVector2 firstBrickWhere(Predicate<IntVector2> coord) {
		IntVector2 coordinates;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				coordinates = new IntVector2(i, j);
				if (coord.test(coordinates)) {
					return coordinates;
				}
			}
		}
		return null;
	}

	/**
	 * Iterate through every brick
	 * @param coord
	 */
	public void forEachBrick(Consumer<IntVector2> coord) {
		IntVector2 coordinates;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				coordinates = new IntVector2(i, j);
				coord.accept(coordinates);
			}
		}
	}
}
