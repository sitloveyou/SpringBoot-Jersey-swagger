package org.unreal.draft.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "user")
data class UserModel(@Id @GeneratedValue val id: Long, val userName: String,
                     val passWord: String,val email:String ,val profilePicture:String ,
                     val introduction:String ,val createTime:String ,val lastModifyTime:String ,
                     val outDate:String, val validataCode:String,val backgroundPicture:String ){
    constructor() : this(
            id = 0,
            userName = "",
            passWord = "",
            email = "",
            profilePicture = "",
            introduction = "",
            createTime = "",
            lastModifyTime = "",
            outDate = "",
            validataCode = "",
            backgroundPicture = ""
    )

}