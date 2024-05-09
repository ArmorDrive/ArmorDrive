pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world! I am here !!!!'
            }
        }
    }
}
