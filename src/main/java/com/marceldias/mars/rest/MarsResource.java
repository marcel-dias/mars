package com.marceldias.mars.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.marceldias.mars.entity.Action;
import com.marceldias.mars.entity.Robot;
import com.marceldias.mars.exception.InvalidActionException;

/**
 * Rest service to receive commands in a Mars Robot
 *
 * Methods:
 *
 * <code>
 * <br>
 * <br>POST   /mars/{actions : [MRL]+}
 * <br>
 * </code>
 *
 * Created by marceldias on 1/6/16.
 */
@Path("/mars")
public class MarsResource {

    @POST
    @Path("/{actions}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response move(@PathParam("actions") String actions) {
        if (actions == null || actions.isEmpty()) {
            throw new InvalidActionException("Action is Null or Empty!");
        }
        List<Action> actionList = Action.fromString(actions);
        Robot robot = new Robot();
        robot.execute(actionList);

        return Response.ok(robot.getPosition()).build();
    }

}
