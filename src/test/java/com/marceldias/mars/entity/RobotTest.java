package com.marceldias.mars.entity;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.marceldias.mars.exception.InvalidActionException;

/**
 * Created by marceldias on 1/7/16.
 */
public class RobotTest {

    private Robot robot;

    @Before
    public void setUp() {
        robot = new Robot();
    }

    @Test
    public void testTurnRight() {
        robot.turn(Side.RIGHT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.E));
    }

    @Test
    public void testTurnLeft() {
        robot.turn(Side.LEFT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.W));
    }

    @Test
    public void testTurnTwiceRight() {
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.S));
    }

    @Test
    public void testTurnTwiceLeft() {
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.S));
    }

    @Test
    public void testTurn3TimesRight() {
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.W));
    }

    @Test
    public void testTurn3TimesLeft() {
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.E));
    }

    @Test
    public void testTurn4TimesRight() {
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        robot.turn(Side.RIGHT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.N));
    }

    @Test
    public void testTurn4TimesLeft() {
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        robot.turn(Side.LEFT);
        Direction shouldBe = robot.getPosition().getDiretion();
        Assert.assertThat(shouldBe, Is.is(Direction.N));
    }

    @Test
    public void testMoveAhead() {
        Position expected = new Position(0, 1);
        robot.move();
        Position shouldBe = robot.getPosition();
        Assert.assertThat(shouldBe.toString(), Is.is(expected.toString()));
    }

    @Test
    public void testActionsExecution() {
        Position expected = new Position(0, 3);
        List<Action> actionList = Arrays.asList(new Action[]{Action.M, Action.M, Action.M});
        robot.execute(actionList);
        Position shouldBe = robot.getPosition();
        Assert.assertThat(shouldBe.toString(), Is.is(expected.toString()));
    }

    @Test
    public void testMoveToWest() {
        Position expected = new Position(1, 0, Direction.W);
        List<Action> actionList = Arrays.asList(new Action[]{Action.R, Action.M, Action.M, Action.R, Action.R, Action.M});
        robot.execute(actionList);
        Position shouldBe = robot.getPosition();
        Assert.assertThat(shouldBe.toString(), Is.is(expected.toString()));
    }

    @Test
    public void testMoveAheadTurnToRight() {
        Position expected = new Position(2, 0, Direction.S);
        List<Action> actionList = Arrays.asList(new Action[]{Action.M, Action.M, Action.R, Action.M, Action.M, Action.R, Action.M, Action.M});
        robot.execute(actionList);
        Position shouldBe = robot.getPosition();
        Assert.assertThat(shouldBe.toString(), Is.is(expected.toString()));
    }

    @Test
    public void testMoveAheadTurnToLeft() {
        Position expected = new Position(0, 2, Direction.W);
        List<Action> actionList = Arrays.asList(new Action[]{Action.M, Action.M, Action.L});
        robot.execute(actionList);
        Position shouldBe = robot.getPosition();
        Assert.assertThat(shouldBe.toString(), Is.is(expected.toString()));
    }

    @Test(expected = InvalidActionException.class)
    public void testInvalidActions() {
        List<Action> actionList = Arrays.asList(new Action[]{Action.M, Action.M, Action.M, Action.M, Action.M});
        robot.execute(actionList);
    }

}
