package rest.framework

import kotlin.test.*

class Character(name: String) {
	val name = name
	get() = field
}

class EndpointTest {

	lateinit var endpoint: Endpoint<Character>

	@BeforeTest fun setup() {
		endpoint = Endpoint("character")
	}

	@Test fun endpoint_responds_to_GET_request() {
		val char = Character("steve")
		endpoint.get({ Response.response200(char) })

		assertEquals(endpoint.recieveGet().payload, char)
	}

	@Test fun endpoint_responds_to_POST_request() {
		endpoint.post({ Response.response201("arbitrary string") })

		assertEquals(endpoint.recievePost().payload, "arbitrary string")
	}

	@Test fun endpoint_responds_to_DELETE_request() {
		endpoint.delete({ Response.response204() })

		assertEquals(endpoint.recieveDelete().body(), "")
	}
}

