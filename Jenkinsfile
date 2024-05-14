pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control
                git 'https://github.com/ishimweeli/spring-boot-todoapp.git'
            }
        }
        stage('Build') {
            steps {
                // Build your project, skipping tests
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                // Run your tests
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build Docker image
                sh 'docker build -t todoApp .'
            }
        }
    }
}
