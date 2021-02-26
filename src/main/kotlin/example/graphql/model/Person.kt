package example.graphql.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(
    val firstNames: String,
    val lastName: String,
    val ssn: String
)

data class PersonData(
    var firstNames: String = "",
    var lastName: String = "",
)
