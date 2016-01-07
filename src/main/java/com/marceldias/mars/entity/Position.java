package com.marceldias.mars.entity;

import java.io.Serializable;

/**
 * Position represents the cartesian point where the robot is
 * and the direction of the robot face
 *
 * The default values are x = 0, y = 0, direction = Direction.N ("North")
 *
 * Created by marceldias on 1/7/16.
 */
public class Position implements Serializable {

    private Integer x = 0;
    private Integer y = 0;
    private Direction diretion = Direction.N;

    public Position() {
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Integer x, Integer y, Direction direction) {
        this(x, y);
        this.diretion = direction;
    }

    /**
     * Increments the X coordinate and validate the position in the {@link Terrain#validate}
     */
    public void incrementX() {
        x++;
        Terrain.validate(this);
    }

    /**
     * Decrements the X coordinate and validate the position in the {@link Terrain#validate}
     */
    public void decrementX() {
        x--;
        Terrain.validate(this);
    }

    /**
     * Increments the Y coordinate and validate the position in the {@link Terrain#validate}
     */
    public void incrementY() {
        y++;
        Terrain.validate(this);
    }

    /**
     * Decrements the Y coordinate and validate the position in the {@link Terrain#validate}
     */
    public void decrementY() {
        y--;
        Terrain.validate(this);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDiretion() {
        return diretion;
    }

    public void setDiretion(Direction diretion) {
        this.diretion = diretion;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + diretion + ")";
    }
}
