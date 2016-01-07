package com.marceldias.mars.entity;

/**
 * Direction represents the compass directions
 *
 * {@link Direction#W} = West
 * {@link Direction#N} = North
 * {@link Direction#E} = East
 * {@link Direction#W} = South
 *
 * Created by marceldias on 1/7/16.
 */
public enum Direction {

    W(0, "WEST"),
    N(1, "NORTH"),
    E(2, "EAST"),
    S(3, "SOUTH");

    private Integer id;

    Direction(Integer id, String description) {
        this.id = id;
    }

    public static Direction getById(Integer id) {
        if (id != null) {
            for (Direction direction : values()) {
                if (id.equals(direction.getId())) {
                    return direction;
                }
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }
}
