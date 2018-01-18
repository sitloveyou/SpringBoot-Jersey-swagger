package org.unreal.draft.api.resource

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.unreal.draft.dao.CsdnDao
import org.unreal.draft.model.CsdnModel
import org.unreal.draft.util.ResponseData
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Api(value = "CsdnResource", description = "Sample hello world swagger service")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("news")
open class CsdnResource {
    @Autowired
    private var csdnDao:CsdnDao ?= null

    @ApiOperation(value = "getNews" , notes = "获取最新新闻")
    @Path("/getNews")
    @GET
    open fun getNews(): ResponseData {
        val list = csdnDao?.getDegree()
        if (list != null) {
            return ResponseData.ok().putDataValue("list", list)
        }else{
            return ResponseData.badRequest().putDataValue("list",null)
        }

    }
}