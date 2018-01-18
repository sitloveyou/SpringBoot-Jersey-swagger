package org.unreal.draft.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "csdn_data")
class CsdnModel (@Id @GeneratedValue val id: Long, val title: String,
                 val url: String, val user_date:String, val img_link:String,
                 val content:String, val news_type:String,val degree:String) {
    constructor() :this(
            id = 0,
            title = "",
            url = "",
            user_date = "",
            img_link = "",
            content = ""
            ,news_type = "",
            degree = ""
    )
}