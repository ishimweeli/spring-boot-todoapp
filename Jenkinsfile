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
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                // Run your tests
                bat 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build Docker image
                bat 'docker build -t todoapp .'
            }
        }
    }
}
