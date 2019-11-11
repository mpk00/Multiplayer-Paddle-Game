package MovementModule;

import java.awt.Rectangle;

import brick.Gameobject;
import brick.Gameplay;
import brick.IntVector2;
import brick.MapGenerator;
import brick.Player;

public class BallMovementModule extends MovementModule {
    public MapGenerator map;
    public IntVector2 direction;
    public IntVector2 velocity;
    public IntVector2 baseSpeed;

    public BallMovementModule(Gameobject gameobject) {
        super(gameobject);
        this.direction = IntVector2.zero;
        this.velocity = IntVector2.zero;
        this.baseSpeed = IntVector2.zero;
    }

    private void updateBallPositions() {
        velocity = IntVector2.mult(baseSpeed, direction);
        applyVelocity();
    }

    private void applyVelocity() {
        gameobject.position.add(velocity);
    }

    private void bounceOffWalls() {
        if (gameobject.position.x < 0 || gameobject.position.x > 1490) {
            direction.flipX();
        }

        if (gameobject.position.y < 0) {
            direction.flipY();
        }
    }

    private void bounceOffPaddles() {
        Rectangle col = gameobject.getRect();
        for (Player player : gameobject.gameplay.getPlayers()) {
            Rectangle paddleRect = new Rectangle(player.position.x, 750, 100, 8);
            if (col.intersects(paddleRect)) {
                direction.flipY();
                break;
            }
        }
    }

    private void bounceOffBricks() {
        MapGenerator mapGen = gameobject.gameplay.getMapGen();
        IntVector2 brickDim = mapGen.getBrickDimensions();
        Rectangle ballRect = gameobject.getRect();

        IntVector2 collidedBrick = mapGen.firstBrickWhere(coord -> mapGen.getBrickValue(coord) > 0
                && ballRect.intersects(mapGen.getBrickRect(coord)));

        if (collidedBrick != null) {
            System.out.println("collided with brick");
            hitBrick(mapGen, collidedBrick);
        }
    }

    private void hitBrick(MapGenerator map, IntVector2 coord) {
        Rectangle brickRect = map.getBrickRect(coord);
        map.setBrickValue(0, coord);
        gameobject.gameplay.decrementBricks();
        gameobject.gameplay.addScore(5);

        if (gameobject.position.x + 19 <= brickRect.x || gameobject.position.x + 1 >= brickRect.x + brickRect.width) {
            direction.flipX();
        } else {
            direction.flipY();
        }
    }

    @Override
    public void update(float deltaTime) {
        // Update direction of balls based on paddle collision
        bounceOffPaddles();

        // Peform brick operations
        bounceOffBricks();

        // Update position of balls based on velocity
        updateBallPositions();

        // Update direction of balls based on wall collision
        bounceOffWalls();
    }
}