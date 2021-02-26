package example.graphql

import example.graphql.model.Person
import example.graphql.model.PersonData
import example.graphql.service.PeopleService
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@ApplicationScoped
@Path("/")
class Client(private val peopleService: PeopleService) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    fun hello() = "Hello"

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/person")
    fun person(): Person {
        return peopleService.getPerson("111111-9999")
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create-person")
    fun createPerson(): Person {
        val personData = PersonData(firstNames = "Kalervo", lastName = "Jankko")
        return peopleService.createPerson(personData)
    }
}