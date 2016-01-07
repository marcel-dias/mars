package com.marceldias.mars.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Robot have a starting position pointing to (0, 0, N)
 *
 * The robot can receive instructions to {@link Robot#move} ahead according to the direction in his position.
 * The robot can receive instructions to {@link Robot#turn(Side)} Right or Left and modify the direction of the robot
 * face
 *
 * Created by marceldias on 1/7/16.
 */
public class Robot implements Serializable {

    private Position position = new Position();

    /**
     * Move the robot ahead according to the direction
     */
    public void move() {
        if (position.getDiretion() == Direction.N) {
            position.incrementY();
        } else if (position.getDiretion() == Direction.S) {
            position.decrementY();
        } else if (position.getDiretion() == Direction.W) {
            position.decrementX();
        } else if (position.getDiretion() == Direction.E) {
            position.incrementX();
        }
    }

    /**
     * Turn the robot to the {@link Side#RIGHT} or {@link Side#LEFT} side.
     * Turn to Right or Left will only modify the direction of the robot face
     * @param side
     */
    public void turn(Side side) {
        Integer directionId = position.getDiretion().getId();
        if (Side.LEFT == side) {
            directionId--;
        } else {
            directionId++;
        }
        if (directionId < 0) {
            directionId = Direction.S.getId();
        }
        if (directionId > 3) {
            directionId = Direction.W.getId();
        }
        position.setDiretion(Direction.getById(directionId));
    }

    /**
     * Executes a list of action to move or turn the robot in the terrain
     *
     * @param actionList
     */
    public void execute(List<Action> actionList) {
        for (Action action : actionList) {
            action.execute(this);
        }
    }

    public Position getPosition() {
        return position;
    }
}
