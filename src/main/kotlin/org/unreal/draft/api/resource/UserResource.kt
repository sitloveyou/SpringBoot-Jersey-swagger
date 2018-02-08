package org.unreal.draft.api.resource

import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import org.unreal.draft.dao.UserDao
import org.unreal.draft.model.UserModel
import javax.ws.rs.*
import javax.ws.rs.core.MediaType



@Api(value = "UserResource", description = "Sample hello world swagger service")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("user")
class UserResource {

    @Autowired
    private  var userDao: UserDao ?= null

    @ApiOperation(value = "getUser", notes = "获取用户")
    @Path("/getUser")
    @POST
    @ApiParam(value="userName",name = "用户名" )
    //@FormParam("userName")
    @ApiImplicitParam(name = "userName",value = "用户名", required =true, dataType ="String")
    fun getUser(@RequestBody userName:String): UserModel? {
        println("-------请求参数:$userName")
        return userDao?.findByUserName(userName )
    }
    @ApiOperation(value = "getUserList" , notes =  "获取全部用户")
    @Path("/getUserList")
    @GET
    fun getUserList():List<UserModel>?{
        return userDao?.findAll()
    }
}