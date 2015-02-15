package web.resources;

import com.sun.jersey.api.NotFoundException;
import com.yammer.metrics.annotation.Timed;
import common.Constants;
import common.ValidationResult;
import common.ValidationResultType;
import service.StaffService;
import web.resources.dto.StaffInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/staffs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StaffResource {

    StaffService staffService = new StaffService();

    public StaffResource() {
    }

    //TODO: implement projection
    @GET
    @Timed
    @Path("/{id}")
    public Response getStaff(@PathParam("id") Integer staffId) {
        System.out.println(staffId);
        try {
            StaffInfo staffInfo = staffService.getStaff(staffId);
            return Response.ok().entity(staffInfo).build();
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
    public Response getStaffs(@QueryParam("q") String query,
                              @DefaultValue(Constants.offset) @QueryParam("offset") Integer offset,
                              @DefaultValue(Constants.limit) @QueryParam("limit") Integer limit) {
        return Response.ok().build();
    }

    //See if this can be done :/
//    @GET
//    @Timed
//    @Path("/what/the/f")
//    public Response getStaffs2(@QueryParam("active") Boolean active, @QueryParam("firstname") String firstName,
//                               @QueryParam("lastname") String lastName, @QueryParam("timestamp") String timeStamp,
//                               @DefaultValue(Constants.offset) @QueryParam("offset") Integer offset,
//                               @DefaultValue(Constants.limit) @QueryParam("limit") Integer limit) {
//        return Response.ok().build();
//    }


    @GET
    @Timed
    @Path("/{id}/names")
    public Response getStaffName(@PathParam("id") Integer staffId) {
        System.out.println(staffId);
        try {
            StaffInfo staffInfo = staffService.getStaff(staffId);
            return Response.ok().entity(staffInfo.getStaff().getData().getName()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Constants.notFound).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    //TODO: need to think about pictures
//    @GET
//    @Timed
//    @Path("/{id}/pictures")
//    public Response getStaffPicture(@PathParam("id") Integer staffId) {
//        System.out.println(staffId);
//        try {
//            StaffInfo staffInfo = staffService.getStaff(staffId);
//            return Response.ok().entity(staffInfo.getPicture()).build();
//        } catch (Exception e) {
//            return Response.serverError().build();
//        }
//    }

    @POST
    @Timed
    @Path("/")
    public Response postStaff(StaffInfo staffInfo) {
        try {
            ValidationResult validationResult = staffService.createStaff(staffInfo);
            if(validationResult.getValidationResultType() == ValidationResultType.success) {
                Integer staffId = (Integer) validationResult.getEntity();
                return Response.ok().entity(staffId).build();
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
    public Response updateStaffUsingPost(StaffInfo staffInfo) {
        try {
            ValidationResult validationResult = staffService.updateStaff(staffInfo);
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
    @Path("/staffs/{id}")
    public Response deleteStaff(@PathParam("id") String staffId) {
        return Response.noContent().build();
    }

}
