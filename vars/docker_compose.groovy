def call() {
    sh '''
    docker compose down || true
    docker compose up -d
    '''
}
