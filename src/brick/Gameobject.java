package brick;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameobject implements IUpdate, IPaint, KeyListener, ActionListener {
    
    public IntVector2 position;
    public Gameplay gameplay;

    public Gameobject(Gameplay gameplay) {
        this.position = IntVector2.zero;
        this.gameplay = gameplay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
	public void update(float deltaTime) {
		
    }
    
    public Rectangle getRect() {
        return new Rectangle(position.x, position.y, 0, 0);
    }
}