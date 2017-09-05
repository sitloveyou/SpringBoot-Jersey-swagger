package org.unreal.draft.api.resource.impl

import io.swagger.annotations.Api
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.unreal.draft.api.resource.UserResource
import org.unreal.draft.dao.UserDao
import org.unreal.draft.model.UserModel
import javax.ws.rs.Consumes
import javax.ws.rs.FormParam
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Api(value = "UserResource", description = "Sample hello world swagger service")
@Component
@Path("user")
class UserResourceImpl : UserResource {

    @Autowired
    private var userDao: UserDao? = null

    @ApiOperation(value = "getUser", notes = "获取用户")
    override fun getUser(): List<String> {
        return listOf("lincoln", "xiaoli")
    }

    @ApiOperation(value = "saveUser", notes = "保存用户")
    override fun saveUser(@ApiParam(value = "name", name = "姓名")
                          @FormParam("name") name: String,
                          @ApiParam(value = "idCard", name = "身份证号")
                          @FormParam("idCard") idCard: String) {
        userDao?.save(UserModel(name = name, idCard = idCard))
    }
}