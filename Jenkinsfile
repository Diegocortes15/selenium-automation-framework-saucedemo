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
                    sh "docker version"
                    sh "docker info"
                    sh "docker compose version"
                    sh "java --version"
                    sh "mvn --version"
                    sh "allure --version"
                }
            }
        }

        stage('Start container') {
            steps {
                script {
                    sh "docker-compose -f docker/docker-compose.yml up -d"
                    sh "docker-compose ls"
                }
            }
        }

        stage('E2E tests') {
            steps {
                script {
                    sh "mvn clean verify"
                }
            }
            post {
                always {
                    script {
                        echo 'Stop container'
                        sh "docker-compose -f docker/docker-compose.yml down"
                    }
                }
            }
        }

        stage('Publish Artifacts') {
            steps {
                script {
                    echo 'Publish Allure Report'
                    sh "allure generate target/allure-results --clean"
                }
                script {
                    echo 'Publish Junit Report'
                    archiveArtifacts artifacts: '**/surefire-reports/junitreports/TEST-*.xml', fingerprint: true
                }
                script {
                    echo 'Publish Test Logs'
                    archiveArtifacts artifacts: 'target/logger.log', fingerprint: true
                }
            }
        }
    }
}