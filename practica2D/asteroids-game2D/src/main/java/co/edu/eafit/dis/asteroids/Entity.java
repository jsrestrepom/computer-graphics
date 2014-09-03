package co.edu.eafit.dis.asteroids;

import java.awt.*;

public abstract class Entity
{
    protected double x;
    protected double y;
    protected Object sprite;
    protected double dx;
    protected double dy;

    public void setHorizontalMovement(double dx) {
        this.dx = dx;
    }

    public void move(long delta) {
        x += (delta * dx) / 1000;
    }

    public abstract void draw(Graphics2D g);

}
