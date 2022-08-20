function v() {
	cd ./src/
	vim test/kotlinl/rest/framework/*.kt main/kotlin/rest/framework/rest/*.kt
}

function test() {
	./gradlew test --stacktrace 2>&1 | less
}
