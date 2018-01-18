package org.unreal.draft.api.resource

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.unreal.draft.dao.UserDao
import org.unreal.draft.model.UserModel
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Api(value = "UserResource", description = "Sample hello world swagger service")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("user")
open class UserResource {

    @Autowired
    private  var userDao: UserDao ?= null

    @ApiOperation(value = "getUser", notes = "获取用户",consumes="application/x-www-form-urlencoded")
    @Path("/getUser")
    @POST
    open fun getUser(@ApiParam(value="userName",name = "用户名" )
                         @FormParam("userName")userName: String): UserModel? {
        println("-------请求参数:$userName")
        return userDao?.findByUserName(userName )
    }
    @ApiOperation(value = "getUserList" , notes =  "获取全部用户")
    @Path("/getUserList")
    @GET
    open fun getUserList():List<UserModel>?{
        return userDao?.findAll()
    }
//    @ApiOperation(value = "saveUser", notes = "保存用户")
//    override fun saveUser(@ApiParam(value = "name", name = "姓名")
//                          @FormParam("name") name: String,
//                          @ApiParam(value = "idCard", name = "身份证号")
//                          @FormParam("idCard") idCard: String) {
//        userDao?.save(UserModel(userName = name, email = idCard))
//    }
}