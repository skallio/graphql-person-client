package example.graphql.service

import example.graphql.model.Person
import example.graphql.model.PersonData
import io.smallrye.graphql.client.typesafe.api.GraphQlClientApi
import io.smallrye.graphql.client.typesafe.api.GraphQlClientBuilder
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Name
import org.eclipse.microprofile.graphql.Query
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PeopleService(
    @ConfigProperty(name = "graphql.url")
    private val peopleApiUrl: String
) {

    var peopleApi: PeopleApi = GraphQlClientBuilder.newBuilder()
        .endpoint(peopleApiUrl)
        .build(PeopleApi::class.java)

    fun getPerson(ssn: String): Person = peopleApi.person(ssn)
    fun createPerson(person: PersonData): Person = peopleApi.createPerson(person)
}

@GraphQlClientApi
interface PeopleApi {
    @Query
    fun person(
        @Name("ssn") ssn: String,
    ): Person

    @Mutation(value = "createPerson")
    fun createPerson(
        @Name("personDetails") personDetails: PersonData
    ): Person
}
