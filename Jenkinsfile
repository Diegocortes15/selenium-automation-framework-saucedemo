pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat "mvn clean verify"
            }
        }

        stage('Generate Allure Reports') {
            steps {
                bat 'allure generate target/allure-results -o target/allure-reports'
            }
        }

        stage('Publish Allure Reports') {
            steps {
                allure([includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]])
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/allure-reports', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}