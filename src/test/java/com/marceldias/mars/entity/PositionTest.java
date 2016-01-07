package com.marceldias.mars.entity;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.marceldias.mars.exception.InvalidActionException;

/**
 * Created by marceldias on 1/7/16.
 */
public class PositionTest {

    Position position;

    @Before
    public void setUp() {
        position = new Position();
    }

    @Test
    public void testXincrement() {
        Integer expeted = position.getX() + 1;
        position.incrementX();
        Assert.assertThat(position.getX(), Is.is(expeted));
    }

    @Test
    public void testXincrementTwice() {
        Integer expeted = position.getX() + 2;
        position.incrementX();
        position.incrementX();
        Assert.assertThat(position.getX(), Is.is(expeted));
    }

    @Test(expected = InvalidActionException.class)
    public void testXdecrementFromStartPosition() {
        position.decrementX();
    }

    @Test
    public void testXdecrementFromMiddlePosition() {
        position = new Position(2, 2);
        Integer expected = position.getX() - 1;
        position.decrementX();
        Assert.assertThat(position.getX(), Is.is(expected));
    }

    @Test
    public void testYincrement() {
        Integer expeted = position.getY() + 1;
        position.incrementY();
        Assert.assertThat(position.getY(), Is.is(expeted));
    }

    @Test
    public void testYincrementTwice() {
        Integer expeted = position.getY() + 2;
        position.incrementY();
        position.incrementY();
        Assert.assertThat(position.getY(), Is.is(expeted));
    }

    @Test(expected = InvalidActionException.class)
    public void testYdecrementFromStartPosition() {
        position.decrementY();
    }

    @Test
    public void testYdecrementFromMiddlePosition() {
        position = new Position(2, 2);
        Integer expected = position.getY() - 1;
        position.decrementY();
        Assert.assertThat(position.getY(), Is.is(expected));
    }

    @Test
    public void testToString() {
        Position expected = new Position();
        Assert.assertThat(position.toString(), Is.is(expected.toString()));
    }

}
