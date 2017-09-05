package org.unreal.draft.api.resource

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
interface UserResource {

    @GET
    fun getUser(): List<String>

    @POST
    fun saveUser(
            @FormParam("name") name: String,
            @FormParam("idCard") idCard: String)

}