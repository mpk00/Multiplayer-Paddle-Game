package brick;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import MovementModule.BallMovementModule;
import MovementModule.MovementModule;

public class Ball extends Gameobject {

    public BallMovementModule movementModule;

    public Ball(Gameplay gameplay) {
        super(gameplay);
    }

    public Rectangle getRect() {
        return new Rectangle(position.x, position.y, 20, 20);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(position.x, position.y, 20, 20);
    }

    @Override
    public void update(float deltaTime) {
        movementModule.update(deltaTime);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movementModule.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        movementModule.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        movementModule.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        movementModule.keyReleased(e);
    }
}