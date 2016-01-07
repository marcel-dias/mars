package com.marceldias.mars.entity;

import java.util.ArrayList;
import java.util.List;

import com.marceldias.mars.exception.InvalidActionException;

/**
 * Action represents valid inputs to the robot.
 * Each action send a instruction to the robot
 *
 * {@link Action#M} = Move ahead
 * {@link Action#R} = Turn RIGHT
 * {@link Action#L} = Turn LEFT
 *
 * Created by marceldias on 1/7/16.
 */
public enum Action {

    M("MOVE") {
        public void execute(Robot robot) {
            robot.move();
        }
    },
    R("RIGHT") {
        public void execute(Robot robot) {
            robot.turn(Side.RIGHT);
        }
    },
    L("LEFT") {
        public void execute(Robot robot) {
            robot.turn(Side.LEFT);
        }
    };


    Action(String description) {
    }

    public static List<Action> fromString(String actions) {
        List<Action> actionList = new ArrayList<>();
        for (char action : actions.toCharArray()) {
            try {
                actionList.add(Action.valueOf("" + action));
            } catch (IllegalArgumentException e) {
                throw new InvalidActionException(action + " is not a valid input The valid ones are M, R, L.");
            }
        }
        return actionList;
    }

    public abstract void execute(Robot robot);
}
