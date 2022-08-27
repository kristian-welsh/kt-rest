package rest.framework

import kotlin.test.*

class Character(name: String) {
	val name = name
	get() = field
}

class EndpointTest {

	@Test fun endpoint_responds_to_GET_request() {
		val endpoint = Endpoint<Character>("character")

		endpoint.get({ Response.response200(Character("steve")) })

		assertEquals(endpoint.recieveGet()?.data?.name, "steve")
	}

	@Test fun endpoint_responds_to_POST_request() {
		val endpoint = Endpoint<Character>("character")

		endpoint.post({ Response.response201("arbitrary string") })

		assertEquals(endpoint.recievePost()?.data, "arbitrary string")
	}

	@Test fun endpoint_responds_to_DELETE_request() {
		val endpoint = Endpoint<Character>("character")

		endpoint.delete({ Response.response204() })

		assertEquals(endpoint.recieveDelete()?.body, "")
	}
}

