package rest.framework

import kotlin.test.*

class Character(name: String) {
	val name = name
	get() = field
}

class EndpointTest {
	@Test fun endpoint_responds_with_get_lambda_Response() {
		val endpoint = Endpoint<Character>("character")
		endpoint.get({ Response.response200(Character("steve")) })

		assertNotNull(endpoint.recieveGet(), "get response was null")
		assertEquals(endpoint.recieveGet()?.data?.name, "steve")
	}
	@Test fun endpoint_responds_with_post_lambda_Response() {
		val endpoint = Endpoint<Character>("character")
		endpoint.post({ Response.response201("arbitrary string") })
		assertEquals(endpoint.recievePost()?.data, "arbitrary string")
	}
}

