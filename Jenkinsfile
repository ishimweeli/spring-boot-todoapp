pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                // Checkout your source code from version control
//             sh 'mvn clean install'
            sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
          sh 'docker build -t  todoApp .'
            }
        }
    }
}
