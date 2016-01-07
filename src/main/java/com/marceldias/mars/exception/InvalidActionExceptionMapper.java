package com.marceldias.mars.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by marceldias on 1/7/16.
 */
@Provider
public class InvalidActionExceptionMapper implements ExceptionMapper<InvalidActionException> {

    @Override
    public Response toResponse(InvalidActionException exception) {
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN_TYPE).entity(exception.getMessage()).build();
    }
}
