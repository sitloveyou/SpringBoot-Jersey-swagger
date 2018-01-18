package org.unreal.draft.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.unreal.draft.model.CsdnModel
import javax.transaction.Transactional

interface CsdnDao : JpaRepository<CsdnModel,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "SELECT * from csdn_data where degree = '1'", nativeQuery = true)
    fun getDegree(): List<CsdnModel>
}