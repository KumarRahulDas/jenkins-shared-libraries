def call(String Project, String ImageTag, String DockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhubcred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {

        sh """
        echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
        docker push ${DockerHubUser}/${Project}:${ImageTag}
        docker logout
        """
    }
}
