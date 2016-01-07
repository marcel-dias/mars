package com.marceldias.mars.entity;

import org.junit.Test;

import com.marceldias.mars.exception.InvalidActionException;

/**
 * Created by marceldias on 1/7/16.
 */
public class TerrainTest {

    @Test
    public void testValidPosition() {
        Position position = new Position();
        Terrain.validate(position);
    }

    @Test(expected = InvalidActionException.class)
    public void testInvalidPosition() {
        Position position = new Position(5, 0);
        Terrain.validate(position);
    }
}
