package web.resources;

import com.yammer.metrics.annotation.Timed;
import common.Constants;
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

    @GET
    @Timed
    @Path("/{id}")
    public Response getStaff(@PathParam("id") Integer staffId) {
        System.out.println(staffId);
        try {
            StaffInfo staffInfo = staffService.getStaff(staffId);
            return Response.ok().entity(staffInfo).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Timed
    @Path("/")
    public Response getStaffs(@QueryParam("q") String query,
                              @DefaultValue(Constants.offset) @QueryParam("offset") Integer offset,
                              @DefaultValue(Constants.limit) @QueryParam("limit") Integer limit) {
        return Response.ok().build();
    }

    //See if this can be done :/
    @GET
    @Timed
    @Path("/what/the/f")
    public Response getStaffs2(@QueryParam("active") Boolean active, @QueryParam("firstname") String firstName,
                               @QueryParam("lastname") String lastName, @QueryParam("timestamp") String timeStamp,
                               @DefaultValue(Constants.offset) @QueryParam("offset") Integer offset,
                               @DefaultValue(Constants.limit) @QueryParam("limit") Integer limit) {
        return Response.ok().build();
    }


    @GET
    @Timed
    @Path("/staffs/{id}/names")
    public Response getStaffName(@PathParam("id") String staffId) {
        return Response.ok().build();
    }


    @GET
    @Timed
    @Path("/staffs/{id}/pictures")
    public Response getStaffPicture(@PathParam("id") String staffId) {
        return Response.ok().build();
    }

    @POST
    @Timed
    @Path("/staffs")
    public Response postStaff(StaffInfo staffInfo) {
        return Response.ok().build();
    }

    @POST
    @Timed
    @Path("/staffs/{id}")
    public Response updateStaffUsingPost(StaffInfo staffInfo) {
        return Response.ok().build();
    }

    @DELETE
    @Timed
    @Path("/staffs/{id}")
    public Response deleteStaff(@PathParam("id") String staffId) {
        return Response.noContent().build();
    }

}
