package org.unreal.draft.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "user")
data class UserModel(@Id @GeneratedValue val id: Long = 0, val name: String, val idCard: String)