package brick;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import MovementModule.MovementModule;;

public class Player extends Gameobject {

    public Color paddleColor;
    public MovementModule movementModule;

    public Player(Gameplay gameplay) {
        super(gameplay);
        this.movementModule = new MovementModule(this);
    }

    public Player(IntVector2 position, Color paddleColor, MovementModule movementModule, Gameplay gameplay) {
        super(gameplay);
        this.position = position;
        this.paddleColor = paddleColor;
        this.movementModule = movementModule;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(paddleColor);
        g.fillRect(position.x, position.y, 100, 8);
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
        movementModule.keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        movementModule.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        movementModule.keyReleased(e);
    }

    @Override
    public Rectangle getRect(){
        // TODO
        return new Rectangle(0,0,0,0);
    }
}