package com.federicovitale.demo;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Component
@Path("/api")
public class PersonController {
    @GET
    @Path("/hi/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hi(@PathParam("name") String name) {
        return Response.ok()
                .entity(String.format("Hi %s", name))
                .build();
    }

    @POST
    @Path("/read-file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readFile(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetails
    ) {
       return Response.ok()
               .entity(fileDetails)
               .build();
    }
}
