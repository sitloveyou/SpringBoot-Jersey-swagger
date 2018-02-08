package org.unreal.draft.api

import io.swagger.jaxrs.config.BeanConfig
import io.swagger.jaxrs.listing.ApiListingResource
import io.swagger.jaxrs.listing.SwaggerSerializers
import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.stereotype.Component
import org.springframework.util.ClassUtils
import java.nio.file.Path
import java.security.Provider
import javax.annotation.PostConstruct
import java.util.HashSet
import java.util.stream.Collectors


@Component
class JerseyConfigure : ResourceConfig() {

    @Value("\${spring.jersey.application-path:/}")
    private val apiPath: String? = null


    @PostConstruct
    fun init() {
        this.configureSwagger()
    }

    private fun configureSwagger() {
        // Available at localhost:port/api/swagger.json
        this.register(ApiListingResource::class.java)
        this.register(SwaggerSerializers::class.java)

        val config = BeanConfig()
        config.scan = true
        config.prettyPrint = true
        config.title = "Spring Boot + Jersey + Swagger Example"
        config.version = "v1"
        config.contact = "sodlinken@gmail.com"
        config.schemes = arrayOf("http", "https")
        config.basePath = this.apiPath
        config.resourcePackage = "org.unreal.draft.api.resource"

    }


    init {
        this.register(ApiListingResource::class.java)
        this.register(SwaggerSerializers::class.java)
        this.register(JacksonFeature::class.java)
        packages("org.unreal.draft.api.resource")
    }


}