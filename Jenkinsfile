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
                bat 'docker-compose ls'
            }
        }
        stage('E2E tests') {
            steps {
                bat 'mvn clean verify'
            }
            post {
                always {
                    echo 'Stop container'
                    bat 'docker-compose -f docker/docker-compose.yml down'
                }
            }
        }
        stage('Publish Allure Report') {
            steps {
                bat 'allure generate target/allure-results --clean'
                allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'allure-results']]
            }
        }
        stage('Publish Junit Report') {
            steps {
                archiveArtifacts artifacts: '**/surefire-reports/junitreports/TEST-*.xml', fingerprint: true
            }
        }
        stage('Publish Test Logs') {
            steps {
                archiveArtifacts artifacts: 'target/logger.log', fingerprint: true
            }
        }
    }
}