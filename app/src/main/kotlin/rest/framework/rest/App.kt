/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package rest.framework

class Character(name: String) {
	val name = name
	get() = field
}

class Endpoint<T>(path: String){
	private val PATH_START = "root/"
	val path = PATH_START + path

	lateinit var lamb: ()->Response<T>?
	fun recieveGet(): Response<T>? {
		if(::lamb.isInitialized)
			return lamb()
		return null
	}
	fun get(lamb: ()->Response<T>? ) {
		this.lamb = lamb
	}
}

class WebClient {
	val fakeRequest = "GET /character/1\n\n"
	fun listen():Int? {
		return null
	}

	fun respond(response: Response<Any>?) {
		// 
	}

	fun stop() {

	}
}

class HttpMethods(string: String) {
	companion object {
		val get = HttpMethods("get")
	}
}

class Request(rawData: Int?) {
	val method:HttpMethods = HttpMethods.get
	val path:String = ""
	val pathParam: String? = ""
}

class Response<T>(public val char: T? = null) {
	companion object {
		fun <U> response201(message: U):Response<U>? {
			return Response(message)
		}
		fun <U> response200(character: U?):Response<U>? {
			return Response(character)
		}
	}
}

class WebServer(val path: String, val client: WebClient?) {
	private val endpoints:MutableMap<String, Endpoint<Any>> = mutableMapOf()

	fun start() {
		//val incoming = client?.listen()
		//val request = Request(incoming)
		//val response = responseFor<Character>(request)
		//client?.respond(response)
	}
	
	fun <T> responseFor(request: Request?): Response<T>? {
		return if(request != null) {
			val endpoint: Endpoint<T>? = endpoints.get(request.path) as Endpoint<T> 
			endpoint?.recieveGet()
			Response<T>(null)
		} else {
			null
		}
	}

	fun addEndpoint(endpoint: Endpoint<Character>) {
		endpoints.put(this.path + endpoint.path, endpoint as Endpoint<Any>)
	}
}

fun main() {
	val PATH_START = "/api/rest/v1.0/"
    val server = WebServer(PATH_START, null)//HttpWebClient("8585"))
	server.addEndpoint(Endpoint<Character>("character"))
	server.start()
}

