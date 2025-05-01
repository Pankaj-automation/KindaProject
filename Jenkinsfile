pipeline {
    agent any

    tools {
        jdk 'a' // Match Jenkins' global tool configuration
        maven 'mvn' // Ensure you’ve set this up in Jenkins > Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Pankaj-automation/KindaProject'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
        }
    }
}
