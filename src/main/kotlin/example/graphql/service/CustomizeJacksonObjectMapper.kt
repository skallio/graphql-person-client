package fi.digione.schoolmanagement.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

@Singleton
class CustomizeJacksonObjectMapper : ObjectMapperCustomizer {
    override fun customize(objectMapper: ObjectMapper) {
        objectMapper.registerModules(
            ParameterNamesModule(),
            JavaTimeModule(),
            KotlinModule(),
        )
    }
}
