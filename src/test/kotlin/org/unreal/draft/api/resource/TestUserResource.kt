package org.unreal.draft.api.resource

import org.json.JSONArray
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class TestUserResource {


    private val restTemplate = TestRestTemplate()
    @Test
    fun testGetUser(){
        val entity = restTemplate.getForEntity(
                "http://localhost:8080/user",
                String::class.java)
        println("entity = ${entity.body}")
        Assert.assertEquals(entity.statusCode , HttpStatus.OK)
    }
}

