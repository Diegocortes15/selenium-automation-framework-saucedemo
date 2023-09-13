pipeline {
    agent any

    tool {
        maven 'MAVEN_HOME'
        java 'JAVA_HOME'
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