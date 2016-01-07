package com.marceldias.mars.entity;

import java.io.Serializable;

import com.marceldias.mars.exception.InvalidActionException;

/**
 * Terrain represents the area where the robot will explore.
 *
 * {@link Terrain#MIN_POSITION} is the minimum position to x and y coordinates
 * {@link Terrain#MAX_POSITION} is the maximum position to x and y coordinates
 *
 * Created by marceldias on 1/7/16.
 */
public abstract class Terrain implements Serializable {

    private static Integer MIN_POSITION = 0;
    private static Integer MAX_POSITION = 4;

    /**
     * {@link Terrain#validate} validates if a Position are inside the terrain.
     *
     * @param position
     */
    public static void validate(Position position) {
        if (position.getX() < MIN_POSITION || position.getX() > MAX_POSITION || position.getY() < MIN_POSITION || position.getY() > MAX_POSITION) {
            throw new InvalidActionException("The robot cannot move to terrain outside!");
        }
    }

}
