pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        allure 'ALLURE_HOME'
    }

    stages {
        stage('Verify tooling') {
            steps {
                script {
                    bat "docker version"
                    bat "docker info"
                    bat "docker compose version"
                    bat "java --version"
                    bat "mvn --version"
                    bat "allure --version"
                }
            }
        }

        stage('Start container') {
            steps {
                script {
                    bat "docker-compose -f docker/docker-compose.yml up -d"
                    bat "docker-compose ls"
                }
            }
        }

        stage('E2E tests') {
            steps {
                script {
                    bat "mvn clean verify"
                }
            }
            post {
                always {
                    script {
                        echo 'Stop container'
                        bat "docker-compose -f docker/docker-compose.yml down"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Publish Artifacts'
            script {
                echo 'Publish Allure Report'
                bat "allure generate target/allure-results --clean"
                allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'target/allure-results']]
            }
            script {
                echo 'Publish Junit Report'
                junit '**/surefire-reports/junitreports/TEST-*.xml'
            }
            script {
                echo 'Publish Test Logs'
                archiveArtifacts artifacts: 'target/logger.log', fingerprint: true
            }
        }
    }
}