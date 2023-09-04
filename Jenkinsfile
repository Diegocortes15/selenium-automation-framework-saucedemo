pipeline {
    agent any

    tool {
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                git branch: 'develop', url: 'https://github.com/Diegocortes15/selenium-automation-framework-saucedemo'
                bat "mvn clean verify"
            }
        }

        stage('reports') {
            steps {
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
            }
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}