package example.graphql.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.eclipse.microprofile.graphql.Input

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(
    val firstNames: String,
    val lastName: String,
    val ssn: String
)

@Input
data class PersonData(
    var firstNames: String = "",
    var lastName: String = "",
)
