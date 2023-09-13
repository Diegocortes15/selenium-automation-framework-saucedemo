pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        allure 'ALLURE_HOME'
    }
    stages {
        stage('Verify tooling') {
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
        stage('Start container') {
            steps {
                bat 'docker-compose -f docker/docker-compose.yml up -d'
                bat 'docker-compose ps'
            }
        }
        stage('E2E Tests') {
            steps {
                bat 'mvn clean verify'
            }
        }
        stage('E2E Tests') {
            steps {
                bat 'mvn clean verify'
            }
        }
        post {
            always {
                bat 'docker-compose -f docker/docker-compose.yml down'
            }
        }
    }
}