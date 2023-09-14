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

        stage('Publish Artifacts') {
            steps {
                script {
                    echo 'Publish Allure Report'
                    bat "allure generate target/allure-results --clean"
                    archiveArtifacts artifacts: 'allure-report', fingerprint: true
                    allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'target/allure-results']]
                }
                script {
                    echo 'Publish Junit Report'
                    archiveArtifacts artifacts: '**/surefire-reports/testng-results.xml', fingerprint: true
                }
                script {
                    echo 'Publish Test Logs'
                    archiveArtifacts artifacts: 'target/logger.log', fingerprint: true
                }
            }
        }
    }

    post {
        failure {
            emailext(
                subject: "❌ Jenkins Pipeline Failed: \${JOB_NAME}",
                body: """
                    <html>
                    <head>
                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f2f2f2;
                                margin: 0;
                                padding: 20px;
                            }
                            .container {
                                background-color: #fff;
                                padding: 20px;
                                border-radius: 5px;
                                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                            }
                            .header {
                                background-color: #e74c3c;
                                color: #fff;
                                padding: 10px;
                                text-align: center;
                                border-radius: 5px 5px 0 0;
                            }
                            .content {
                                padding: 20px;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <div class="header">
                                <h1>❌ Jenkins Pipeline Failed</h1>
                            </div>
                            <div class="content">
                                <p>The Jenkins pipeline for <strong>\${JOB_NAME}</strong> has failed.</p>
                                <p>Build URL: <a href="\${BUILD_URL}">\${BUILD_URL}</a></p>
                                <p>Error Details:</p>
                                <pre>\${BUILD_LOG, maxLines=100, escapeHtml=false}</pre>
                            </div>
                        </div>
                    </body>
                    </html>
                    """,
                to: "cortesroadiegoalejandro@gmail.com",
                replyTo: "",
                mimeType: 'text/html'
            )
        }
    }
}