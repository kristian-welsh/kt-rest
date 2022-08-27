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
		endpoint.get({ Response.response200(Character("steve")) })

		assertEquals(endpoint.recieveGet()?.data?.name, "steve")
	}

	@Test fun endpoint_responds_to_POST_request() {
		endpoint.post({ Response.response201("arbitrary string") })

		assertEquals(endpoint.recievePost()?.data, "arbitrary string")
	}

	@Test fun endpoint_responds_to_DELETE_request() {
		endpoint.delete({ Response.response204() })

		assertEquals(endpoint.recieveDelete().body, "")
	}
}

