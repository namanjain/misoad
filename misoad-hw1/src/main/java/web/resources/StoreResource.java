package web.resources;

import com.sun.jersey.api.NotFoundException;
import com.yammer.metrics.annotation.Timed;
import common.Constants;
import common.ValidationResult;
import common.ValidationResultType;
import service.StoreService;
import utils.LinkUtils;
import web.resources.dto.StoreInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/stores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {

    StoreService storeService = new StoreService();

    public StoreResource() {
    }

    //TODO: implement projection
    @GET
    @Timed
    @Path("/{id}")
    public Response getStaff(@PathParam("id") Integer storeId) {
        System.out.println(storeId);
        try {
            StoreInfo storeInfo = storeService.getStore(storeId);
            return Response.ok().entity(storeInfo).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Constants.notFound).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    //TODO: implement this next
    @GET
    @Timed
    @Path("/")
    public Response getStores(@QueryParam("q") String query,
                              @DefaultValue(Constants.offset) @QueryParam("offset") Integer offset,
                              @DefaultValue(Constants.limit) @QueryParam("limit") Integer limit) {
        return Response.ok().build();
    }

    //TODO: implement projection as in granular level getters

    @POST
    @Timed
    @Path("/")
    public Response postStore(StoreInfo storeInfo) {
        try {
            ValidationResult validationResult = storeService.createStore(storeInfo);
            if(validationResult.getValidationResultType() == ValidationResultType.success) {
                Integer storeId = (Integer) validationResult.getEntity();
                return Response.created(new URI(LinkUtils.getStoreLink(storeId))).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(validationResult.getEntity()).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    //TODO: implement content not found
    //TODO: test if it only updates or creates as well
    @PUT
    @Timed
    @Path("/{id}")
    public Response updateStore(@PathParam("id") Integer storeId, StoreInfo storeInfo) {
        try {
            ValidationResult validationResult = storeService.updateStore(storeId, storeInfo);
            if(validationResult.getValidationResultType() == ValidationResultType.success) {
                return Response.noContent().build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(validationResult.getEntity()).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    //Should this return 404 content not found? It will take away its idempotency. I think I should not do it
    @DELETE
    @Timed
    @Path("/{id}")
    public Response deleteStore(@PathParam("id") Integer storeId) {
        try {
            storeService.deleteStore(storeId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
