pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        allure 'ALLURE_HOME'
    }
    stages {
        stage("verify tooling") {
            steps{
                bat '''
                    docker version
                    docker info
                    docker compose version
                    java --version
                    mvn --version
                    allure --version
                '''
            }
        }
    }
}