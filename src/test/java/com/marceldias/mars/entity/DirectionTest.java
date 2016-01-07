package com.marceldias.mars.entity;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marceldias on 1/7/16.
 */
public class DirectionTest {

    @Test
    public void testValidGetById() {
        Direction west = Direction.getById(Direction.W.getId());
        Assert.assertThat(west, Is.is(Direction.W));
    }

    @Test
    public void testInvalidGetById() {
        Direction invalid = Direction.getById(5);
        Assert.assertNull(invalid);
    }
}
