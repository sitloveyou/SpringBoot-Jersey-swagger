package org.unreal.draft.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.unreal.draft.model.UserModel

@Repository
interface UserDao : JpaRepository<UserModel , Long>{

}