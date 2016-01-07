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
public class ActionTest {

    Robot robot;

    @Before
    public void setUp() {
        robot = new Robot();
    }

    @Test
    public void testMoveExecution() {
        Position expected = new Position(0, 1);
        Action.M.execute(robot);
        Assert.assertThat(robot.getPosition().toString(), Is.is(expected.toString()));
    }

    @Test(expected = InvalidActionException.class)
    public void testMoveToTerrainOutside() {
        Action.M.execute(robot);
        Action.M.execute(robot);
        Action.M.execute(robot);
        Action.M.execute(robot);
        Action.M.execute(robot);
    }

    @Test
    public void testTurnRightExecution() {
        Position expected = new Position(0, 0, Direction.E);
        Action.R.execute(robot);
        Assert.assertThat(robot.getPosition().toString(), Is.is(expected.toString()));
    }

    @Test
    public void testTurnLeftExecution() {
        Position expected = new Position(0, 0, Direction.W);
        Action.L.execute(robot);
        Assert.assertThat(robot.getPosition().toString(), Is.is(expected.toString()));
    }

    @Test
    public void testValidFromStringActions() {
        List<Action> expected = Arrays.asList(new Action[]{Action.M, Action.M, Action.M});
        List<Action> actionList = Action.fromString("MMM");
        Assert.assertThat(actionList.size(), Is.is(3));
        Assert.assertThat(actionList, Is.is(expected));
    }

    @Test(expected = InvalidActionException.class)
    public void testInvalidFromStringActions() {
        Action.fromString("MMMA");
    }

}
