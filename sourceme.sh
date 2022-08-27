function v() {
	cd ./app/src/
	vim test/kotlin/rest/framework/*.kt main/kotlin/rest/framework/*.kt
}

function test() {
	./gradlew test --stacktrace 2>&1 | less
}

function reauth() {
	# start ssh agent in background
	eval $(ssh-agent -s)
	# tell it about my github identity (key ilnked to github account)
	ssh-add ~/.ssh/github-keypair
}
