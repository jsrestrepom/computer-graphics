package co.edu.eafit.dis.asteroids;

import co.edu.eafit.dis.core.DrawService;
import co.edu.eafit.dis.core.LineClippingService;
import co.edu.eafit.dis.core.TransformationService;
import co.edu.eafit.dis.core.transformations.ReflectionTransformation;
import co.edu.eafit.dis.core.transformations.TranslationTransformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas
{
    private static TransformationRepository aTransformationRepository;
    private BufferStrategy strategy;
    private boolean gameRunning = true;
    private ArrayList entities = new ArrayList();
    private Spaceship ship;
    private Integer score;
    private final int FRONTERA_DERECHA = 100;
    private final static int WIDTH = 500;
    private final static int HEIGHT = 700;
    private double moveSpeed = 300;
    private boolean leftPressed;
    private boolean rightPressed;

    public Game(TransformationRepository anTransformationRepository) {
        JFrame frame = new JFrame("practica - Asteroids Game 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        setBounds(0, 0, WIDTH, HEIGHT);
        panel.add(this);
        setIgnoreRepaint(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.setVisible(true);
        addKeyListener(new KeyInputHandler());
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        initEntities();
    }

    public static void main(String[] args) {
        aTransformationRepository = new TransformationRepository(WIDTH, HEIGHT);
        Game g = new Game(aTransformationRepository);
        g.gameLoop();
    }

    private void gameLoop() {
        long lastLoopTime = System.currentTimeMillis();
        while (gameRunning)
        {
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            pintarAmbiente(g);
            for (int i = 0; i < entities.size(); i++)
            {
                Entity entity = (Entity) entities.get(i);
                entity.move(delta);
            }
            for (int i = 0; i < entities.size(); i++)
            {
                Entity entity = (Entity) entities.get(i);
                entity.draw(g);
            }
            g.dispose();
            strategy.show();
            if ((leftPressed) && (!rightPressed))
            {
                ship.moveTo(Control.LEFT);
            }
            else if ((rightPressed) && (!leftPressed))
            {
                ship.moveTo(Control.RIGHT);
            }
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                System.out.println(e.toString());
                System.exit(0);
            }
        }
    }

    private void pintarAmbiente(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.drawString("SCORE", FRONTERA_DERECHA / 4, 20);
        g2d.drawString(score.toString(), FRONTERA_DERECHA / 4, 40);
    }

    private void initEntities() {
        score = 0;
        ship = new Spaceship();
        ship.create(aTransformationRepository);
        entities.add(ship);
    }

    private class KeyInputHandler extends KeyAdapter
    {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                rightPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                rightPressed = false;
            }
        }

        public void keyTyped(KeyEvent e) {
            // if we hit escape, then quit the game
            if (e.getKeyChar() == 27)
            {
                System.exit(0);
            }
        }
    }

}
