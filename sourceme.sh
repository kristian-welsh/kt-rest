function v() {
	cd ./app/src/
	vim test/kotlin/rest/framework/*.kt main/kotlin/rest/framework/*.kt
}

function test() {
	./gradlew test --stacktrace 2>&1 | less
}
