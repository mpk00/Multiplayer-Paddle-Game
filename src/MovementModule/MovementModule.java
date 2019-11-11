package MovementModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import brick.*;

public class MovementModule implements IUpdate, KeyListener, ActionListener
{
    public Gameobject gameobject;

    public MovementModule(Gameobject gameobject)
    {
        this.gameobject = gameobject;
    }

    @Override
    public void update(float deltaTime)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        processKeyEvent(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        processKeyEvent(e , false);
    }

    public synchronized void processKeyEvent(KeyEvent e, boolean down) {
        if(down) {
            processKeyPressed(e);
        }
        else {
            processKeyReleased(e);
        }
    }

    public void processKeyPressed(KeyEvent e) {

    }

    public void processKeyReleased(KeyEvent e) {

    }
}