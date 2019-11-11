package MovementModule;

import java.awt.event.KeyEvent;
import brick.*;

public class KeyboardMovementModule extends MovementModule {
    public int leftKey;
    public int rightKey;
    public int speed;

    private boolean leftKeyPressed = false;
    private boolean rightKeyPressed = false;

    public KeyboardMovementModule(Gameobject gameobject, int leftKey, int rightKey, int speed) {
        super(gameobject);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.speed = speed;
    }

    @Override
    public void processKeyPressed(KeyEvent e) {

        if (e.getKeyCode() == rightKey) {
            rightKeyPressed = true;
        }
        else if (e.getKeyCode() == leftKey) {
            leftKeyPressed = true;
        }
    }

    @Override
    public void processKeyReleased(KeyEvent e) {

        if (e.getKeyCode() == rightKey) {
            rightKeyPressed = false;
        }
        else if (e.getKeyCode() == leftKey) {
            leftKeyPressed = false;
        }
    }

    @Override
    public void update(float deltaTime) {
        int desiredPosX = gameobject.position.x;

        int dx = Math.max(1, Math.round(speed * deltaTime));

        if(rightKeyPressed){
            desiredPosX += dx;
        }
        else if(leftKeyPressed) {
            desiredPosX -= dx;
        }

        gameobject.position.x = IntUtil.Clamp(desiredPosX, 10, 1385);
    }
}