package org.unreal.draft.api.resource

import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.unreal.draft.dao.CsdnDao
import org.unreal.draft.model.CsdnModel
import org.unreal.draft.util.ResponseData
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Api(value = "CsdnResource", description = "Sample hello world swagger service")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("news")
class CsdnResource {
    @Autowired
    private var csdnDao:CsdnDao ?= null

    @ApiOperation(value = "getNews" , notes = "获取最新新闻")
    @Path("/getNews")
    @GET
    //@ApiImplicitParam(paramType = "path",name = "当前页码",value = "page", required =true, dataType ="String")
    fun getNews(@QueryParam("page") page:String): ResponseData {
        println("-------请求参数:$page")
        val list = csdnDao?.getDegree(page)
        if (list != null) {
            return ResponseData.ok().putDataValue("list", list)
        }else{
            return ResponseData.badRequest().putDataValue("list",null)
        }

    }
}