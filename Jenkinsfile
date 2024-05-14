pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from version control
                git 'your_repository_url'
            }
        }
        stage('Run Tests') {
            steps {
                // Run your tests
                sh 'mvn test' // Assuming you're using Maven for testing
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build Docker image
                script {
                    docker.build('your_image_name:latest', '-f Dockerfile .') // Replace with your Dockerfile path
                }
            }
        }
        stage('Publish Docker Image') {
            steps {
                // Publish Docker image to a registry (optional)
                script {
                    docker.withRegistry('https://your.registry.com', 'your_registry_credentials') {
                        docker.image('your_image_name:latest').push('latest')
                    }
                }
            }
        }
    }
}
